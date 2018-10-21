package edu.gatech.hackgt.budslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.gatech.hackgt.budslist.models.Book;
import edu.gatech.hackgt.budslist.models.Model;
import edu.gatech.hackgt.budslist.models.User;

public class MakeRequestActivity extends AppCompatActivity {

    TextView textView_title;
    TextView textView_isbn;
    TextView textView_price;
    TextView textView_author;
    TextView textView_binding;
    TextView textView_course;
    TextView textView_seller;

    String sellerEmail;
    String bookPrice;
    String bookISBN;
    String userEmail;
    Book book;

    Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_request);

        Bundle extras = getIntent().getExtras();
        sellerEmail = extras.getString("seller_email");
        bookPrice = extras.getString("book_price");
        bookISBN = extras.getString("book_isbn");

        model = Model.getInstance();

        for (Book b : model.getBooks()) {
            Log.d("sad", b.getAuthor());
        }

        Log.d("Why",Boolean.toString(model.getBooks().isEmpty()));

        userEmail = model.getCurrentUser();
        Log.d("Why",Boolean.toString(model.getBooks().isEmpty()));

        book = model.getBookWith_seller_price_isbn(sellerEmail, bookPrice, bookISBN);
        Log.d("please",Boolean.toString(book == null));
        Log.d("Why",Boolean.toString(model.getBooks().isEmpty()));
        User seller = model.getUserByEmail(sellerEmail);
        Log.d("Why",Boolean.toString(model.getBooks().isEmpty()));

        textView_title = findViewById(R.id.textView_title);
        textView_isbn = findViewById(R.id.textView_isbn);
        textView_price = findViewById(R.id.textView_price);
        textView_author = findViewById(R.id.textView_author);
        textView_binding = findViewById(R.id.textView_binding);
        textView_course = findViewById(R.id.textView_course);
        textView_seller = findViewById(R.id.textView_seller);

        textView_title.setText(book.getName());
        textView_isbn.setText(book.getIsbn());
        textView_price.setText(book.getPrice());
        textView_author.setText(book.getAuthor());
        textView_binding.setText(book.getType().toString());
        textView_course.setText(book.getCourse().toString());
        textView_seller.setText(seller.toString());
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, MyListingsActivity.class);
        intent.putExtra("user_email", userEmail);
        startActivity(intent);
    }

    //TODO: Verify that existing Request does not already exist.
    public void onClickMakeRequest(View view) {
        model.addRequest(userEmail, book);
        Intent intent = new Intent(this, ViewMyRequests.class);
    }
}
