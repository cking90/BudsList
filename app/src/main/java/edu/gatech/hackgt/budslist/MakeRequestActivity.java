package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MakeRequestActivity extends AppCompatActivity {

    TextView textView_title;
    TextView textView_isbn;
    TextView textView_price;
    TextView textView_author;
    TextView textView_binding;
    TextView textView_course;
    TextView textView_seller;


    String userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_request);

        Bundle extras = getIntent().getExtras();
        userEmail = extras.getString("user_email");


        textView_title = findViewById(R.id.textView_title);
        textView_isbn = findViewById(R.id.textView_isbn);
        textView_price = findViewById(R.id.textView_price);
        textView_author = findViewById(R.id.textView_author);
        textView_binding = findViewById(R.id.textView_binding);
        textView_course = findViewById(R.id.textView_course);
        textView_seller = findViewById(R.id.textView_seller);
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, MyListingsActivity.class);
        intent.putExtra("user_email", userEmail);
        startActivity(intent);
    }
}
