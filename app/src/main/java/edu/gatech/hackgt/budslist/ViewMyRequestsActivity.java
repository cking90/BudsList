package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import edu.gatech.hackgt.budslist.R;
import edu.gatech.hackgt.budslist.models.Book;
import edu.gatech.hackgt.budslist.models.Model;
import edu.gatech.hackgt.budslist.models.Request;

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

        Log.d("pleasecoco", userEmail);
        Log.d("pleasee", model.getRequests().get(0).getBuyer());
        outgoing = (Spinner)findViewById(R.id.spinner_outgoing);
        outgoing.setAdapter(new ArrayAdapter<Request>(this, android.R.layout.simple_spinner_item, model.getRequestsForBuyer(userEmail)));

        incoming = (Spinner)findViewById(R.id.spinner_offers);
        incoming.setAdapter(new ArrayAdapter<Request>(this, android.R.layout.simple_spinner_item, model.getRequestsForSeller(userEmail)));
    }
    public void onClickViewDetails(View view) {
        Request r = (Request) ((Spinner) findViewById(R.id.spinner_offers)).getSelectedItem();
        if(r == null) {
            Toast.makeText(this,"Cannot view details", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, ViewChosenRequestActivity.class);
            intent.putExtra("seller_email", userEmail);
            intent.putExtra("buyer_email", r.getBuyer());
            intent.putExtra("book_isbn", r.getBook().getIsbn());
            intent.putExtra("date", r.getDate().toString());
            intent.putExtra("price", r.getBook().getPrice());
            startActivity(intent);
        }
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, MainPageActivity.class);
        intent.putExtra("user_email", userEmail);
        startActivity(intent);
    }
}
