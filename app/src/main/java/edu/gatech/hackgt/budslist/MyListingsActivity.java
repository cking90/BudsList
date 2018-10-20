package edu.gatech.hackgt.budslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.hackgt.budslist.models.Book;
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
}