package edu.gatech.hackgt.budslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
