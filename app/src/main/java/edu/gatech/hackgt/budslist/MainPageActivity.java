package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainPageActivity extends AppCompatActivity {

    String userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Bundle extras = getIntent().getExtras();
        userEmail = extras.getString("user_email");
    }
    public void onClickLogout(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void onClickSellBook(View view) {
        Intent intent = new Intent(this, CreateListingActivity.class);
        intent.putExtra("user_email", userEmail);
        startActivity(intent);
    }

    public void onClickMyListings(View view) {
        Intent intent = new Intent(this, MyListingsActivity.class);
        intent.putExtra("user_email", userEmail);
        startActivity(intent);
    }

    public void onClickSearchBooks(View view) {
        Intent intent = new Intent(this, SearchForBooksActivity.class);
        intent.putExtra("user_email", userEmail);
        startActivity(intent);
    }



}
