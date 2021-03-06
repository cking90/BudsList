package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.hackgt.budslist.models.Book;
import edu.gatech.hackgt.budslist.models.Department;
import edu.gatech.hackgt.budslist.models.Model;

public class MyListingsActivity extends AppCompatActivity {

    Model model;
    String userEmail;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_listings);

        model = Model.getInstance();
        Bundle extras = getIntent().getExtras();
        userEmail = extras.getString("user_email");

        List<Book> listings = model.getBooksWithSellerEmail(userEmail);
        Spinner userType = (Spinner)findViewById(R.id.myListingsSpinner);
        userType.setAdapter(new ArrayAdapter<Book>(this, android.R.layout.simple_spinner_item, listings));


    }
    public void onClickDelete(View view) {

        model = Model.getInstance();
        Bundle extras = getIntent().getExtras();
        userEmail = extras.getString("user_email");

        Spinner book = (Spinner)findViewById(R.id.myListingsSpinner);
        Book selected_book = (Book)book.getSelectedItem();

        model.removeBook(selected_book);
        Intent intent = new Intent(this, MyListingsActivity.class);
        intent.putExtra("user_email", userEmail);
        startActivity(intent);


    }

    public void onClickMainPage(View view) {
        Intent intent = new Intent(this, MainPageActivity.class);
        intent.putExtra("user_email", userEmail);
        startActivity(intent);
    }

    public void onClickViewDetails(View view) {
        Book book = (Book) ((Spinner) findViewById(R.id.myListingsSpinner)).getSelectedItem();
        if (book == null) {
            Toast.makeText(this, "Cannot view details if a book is not selected.",
                    Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, ViewListingActivity.class);

            intent.putExtra("seller_email", book.getSeller().getEmail());
            intent.putExtra("book_price", book.getPrice());
            intent.putExtra("book_isbn", book.getIsbn());
            startActivity(intent);
        }
    }

}
