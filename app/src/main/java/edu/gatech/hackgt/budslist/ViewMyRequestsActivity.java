package edu.gatech.hackgt.budslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import edu.gatech.hackgt.budslist.R;
import edu.gatech.hackgt.budslist.models.Book;
import edu.gatech.hackgt.budslist.models.Model;

public class ViewMyRequestsActivity extends AppCompatActivity {
    Model model;
    String userEmail;

    Spinner outgoing;
    Spinner incoming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_requests);

        Bundle extras = getIntent().getExtras();
        userEmail = extras.getString("user_email");
        model = Model.getInstance();

        Spinner outgoing = (Spinner)findViewById(R.id.spinner_outgoing);
        outgoing.setAdapter(new ArrayAdapter<Book>(this, android.R.layout.simple_spinner_item, ));

        Spinner userType = (Spinner)findViewById(R.id.myListingsSpinner);
        userType.setAdapter(new ArrayAdapter<Book>(this, android.R.layout.simple_spinner_item, listings));
    }
}
