package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class ViewChosenRequestActivity extends AppCompatActivity {

    String userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_chosen_request);

        Bundle extras = getIntent().getExtras();
        userEmail = extras.getString("user_email");
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, ViewMyRequestsActivity.class);
        intent.putExtra("user_email", userEmail);
        startActivity(intent);
    }
}
