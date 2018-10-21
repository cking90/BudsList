package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.hackgt.budslist.models.Binding;
import edu.gatech.hackgt.budslist.models.Course;
import edu.gatech.hackgt.budslist.models.Department;
import edu.gatech.hackgt.budslist.models.Model;
import edu.gatech.hackgt.budslist.models.User;

public class CreateListingActivity extends AppCompatActivity {
    Model model;
    String userEmail;
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

    public void onClickMakeListing(View view) {
        Log.d("5555", Integer.toString(DataGetter.getData("https://isbndb.com/book/9780136019701").length));
        String[] data = new String[2];

        EditText isbn_box = (EditText)findViewById(R.id.editText_isbn_id);
        String isbn = isbn_box.getText().toString();
        EditText price_box = (EditText)findViewById(R.id.editText_price_id);
        String price = price_box.getText().toString();

        Spinner binding = (Spinner)findViewById(R.id.spinner_binding_id);
        Binding selected_binding = (Binding)binding.getSelectedItem();
        Spinner department = (Spinner)findViewById(R.id.spinner_department_id);
        Department selected_department = (Department)department.getSelectedItem();

        EditText num_box = (EditText)findViewById(R.id.editText_courseNum_id);
        String course_num = num_box.getText().toString();

        String email = userEmail;
        User user = model.getUserByEmail(userEmail);

        String name =  data[0];
        String author = data[1];
        model.addBook(new Course(selected_department, course_num), user, name, price, isbn, author, selected_binding);


        Intent intent = new Intent(this, MyListingsActivity.class);
        intent.putExtra("user_email", userEmail);
        startActivity(intent);
    }

}
