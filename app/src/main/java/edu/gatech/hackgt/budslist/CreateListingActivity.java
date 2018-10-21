package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.gatech.hackgt.budslist.models.Binding;
import edu.gatech.hackgt.budslist.models.Course;
import edu.gatech.hackgt.budslist.models.Department;
import edu.gatech.hackgt.budslist.models.Model;
import edu.gatech.hackgt.budslist.models.User;

public class CreateListingActivity extends AppCompatActivity {
    Model model;
    String userEmail;
    private String urlData = "";
    String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing);
        Bundle extras = getIntent().getExtras();
        userEmail = extras.getString("user_email");
        model = Model.getInstance();
        Spinner department = (Spinner)findViewById(R.id.spinner_department_id);
        department.setAdapter(new ArrayAdapter<Department>(this, android.R.layout.simple_spinner_item, Department.values()));
        Spinner binding = (Spinner)findViewById(R.id.spinner_binding_id);
        binding.setAdapter(new ArrayAdapter<Binding>(this, android.R.layout.simple_spinner_item, Binding.values()));
    }

    public void onClickMakeListing(View view) throws InterruptedException {
        EditText isbn_box = (EditText)findViewById(R.id.editText_isbn_id);
        String isbn = isbn_box.getText().toString();
        isbn = isbn.trim();
        isbn = isbn.replaceAll("-| ", "");
        setUrldata(isbn);
        EditText price_box = (EditText)findViewById(R.id.editText_price_id);
        String price = price_box.getText().toString();

        Spinner binding = (Spinner)findViewById(R.id.spinner_binding_id);
        Binding selected_binding = (Binding)binding.getSelectedItem();
        Spinner department = (Spinner)findViewById(R.id.spinner_department_id);
        Department selected_department = (Department)department.getSelectedItem();

        EditText num_box = (EditText)findViewById(R.id.editText_courseNum_id);
        String course_num = num_box.getText().toString();

        class Scrape implements Runnable {
            private volatile String data;

            public String getData() { return data; }
            @Override
            public void run() {
                String title =" ";
                String authorName = " ";
                try {
                    Document doc = Jsoup.connect(urlData).get();
                    String body = doc.body().text();

                    Pattern titlePattern = Pattern.compile("Full Title (.+?) ISBN");
                    Matcher titleMatcher = titlePattern.matcher(body);
                    if (titleMatcher.find()) {
                        title = titleMatcher.group(1);
                    }

                    Pattern authorPattern = Pattern.compile("Authors (.+?) [Overview|Edition]");
                    Matcher authorMatcher = authorPattern.matcher(body);
                    if (authorMatcher.find()) {
                        authorName = authorMatcher.group(1);
                    }

                    data = title + "###" + authorName;
                } catch (Exception e) {
                    data = "";
                }
            }
        }


        String email = userEmail;
        User user = model.getUserByEmail(userEmail);
        Scrape s = new Scrape();
        Thread t = new Thread(s);
        t.start();
        t.join();
        String resultString = s.getData();
        String[] data = resultString.split("###");
        if (resultString.length() == 5 || !isbn.matches("[0-9]{13}|[0-9]{10}")) {
            Toast.makeText(this, "ISBN is invalid. Please enter valid ISBN", Toast.LENGTH_LONG).show();
        }
        else {
            model.addBook(new Course(selected_department, course_num), user, data[0], price, isbn, data[1], selected_binding);

            Intent intent = new Intent(this, MyListingsActivity.class);
            intent.putExtra("user_email", userEmail);
            startActivity(intent);
        }

    }

    public void setUrldata(String url) {
        this.urlData = "https://isbndb.com/book/" + url;
    }

//    public String[] getData() {
//        return data;
//    }


}
