package edu.gatech.hackgt.budslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.gatech.hackgt.budslist.R;
import edu.gatech.hackgt.budslist.models.Model;

public class ViewMyRequestsActivity extends AppCompatActivity {
    Model model;
    String userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_requests);

        Bundle extras = getIntent().getExtras();
        userEmail = extras.getString("user_email");
        model = Model.getInstance();
    }
}
