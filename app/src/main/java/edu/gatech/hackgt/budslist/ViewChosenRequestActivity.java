package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.gatech.hackgt.budslist.models.Book;
import edu.gatech.hackgt.budslist.models.Model;


public class ViewChosenRequestActivity extends AppCompatActivity {

    TextView textView_book;
    TextView textView_buyer;
    TextView textView_seller;
    TextView textView_price;
    TextView textView_date;


    String seller_email;
    String buyer_email;
    String isbn;
    String price;
    String date;

    Book book;
    Model model;

    String userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_chosen_request);

        Bundle extras = getIntent().getExtras();
        seller_email = extras.getString("seller_email");
        buyer_email = extras.getString("buyer_email");
        price = extras.getString("price");
        isbn = extras.getString("book_isbn");
        date = extras.getString("date");

        model = Model.getInstance();
        book = model.getBookWith_seller_price_isbn(seller_email, price, isbn);

        textView_book = findViewById(R.id.textView_book);
        textView_buyer = findViewById(R.id.textView_buyer);
        textView_date = findViewById(R.id.textView_date);
        textView_price = findViewById(R.id.textView_price);
        textView_seller = findViewById(R.id.textView_seller);

        textView_book.setText(book.getName());
        textView_price.setText(price);
        textView_date.setText(date);
        textView_buyer.setText(buyer_email);
        textView_seller.setText(seller_email);

    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, ViewMyRequestsActivity.class);
        intent.putExtra("user_email", seller_email);
        startActivity(intent);
    }
}
