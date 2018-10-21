package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.gatech.hackgt.budslist.models.Book;
import edu.gatech.hackgt.budslist.models.Model;

public class ViewListingActivity extends AppCompatActivity {


    TextView bookTitleTextView;
    TextView isbnTextView;
    TextView priceTextView;
    TextView authorTextView;
    TextView bindingTextView;
    TextView courseTextView;

    String userEmail;
    String bookISBN;
    String bookPrice;
    Model model;
    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_listing);

        Bundle extras = getIntent().getExtras();
        userEmail = extras.getString("seller_email");
        bookPrice = extras.getString("book_price");
        bookISBN = extras.getString("book_isbn");

        model = Model.getInstance();
        book = model.getBookWith_seller_price_isbn(userEmail, bookPrice, bookISBN);
        bookTitleTextView = findViewById(R.id.textView_bookTitle_id);
        isbnTextView = findViewById(R.id.textView_isbnReplace_id);
        priceTextView = findViewById(R.id.textView_priceReplace_id);
        authorTextView = findViewById(R.id.authorTextView);
        bindingTextView = findViewById(R.id.bindingTextView);
        courseTextView = findViewById(R.id.courseTextView);

        bookTitleTextView.setText(book.getName());
        isbnTextView.setText(book.getIsbn());
        priceTextView.setText(book.getPrice());
        authorTextView.setText(book.getAuthor());
        bindingTextView.setText(book.getType().toString());
        courseTextView.setText(book.getCourse().toString());

    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, MyListingsActivity.class);
        intent.putExtra("user_email", userEmail);
        startActivity(intent);
    }


}
