package edu.gatech.hackgt.budslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import edu.gatech.hackgt.budslist.models.Book;
import edu.gatech.hackgt.budslist.models.Model;

public class SearchForBooksActivity extends AppCompatActivity {

    Model model;
    RecyclerView listView;
    private ArrayList<String> bookNames = new ArrayList<>();
    private ArrayList<String> bookAuthors = new ArrayList<>();
    private ArrayList<String> bookPrices = new ArrayList<>();
    private ArrayList<String> bookSellers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_books);
        listView = findViewById(R.id.bookRecyclerView);
        model = Model.getInstance();
        initBookData();

    }

    private void initBookData() {
        for (Book book : model.getBooks()) {
            bookNames.add(book.getName());
            bookAuthors.add(book.getAuthor());
            bookPrices.add(book.getPrice());
            bookSellers.add(book.getSeller().getName());
        }
        initRecyclerView();
        Log.d("initRecyclerView", "initRecycler: initialization complete");
    }

    private void initRecyclerView() {
        Log.d("initRecyclerView", "initRecycler: started");
        RecyclerView recyclerView = findViewById(R.id.bookRecyclerView);
        BookRecyclerViewAdapter adapter = new BookRecyclerViewAdapter(bookNames,
                bookPrices, bookAuthors, bookSellers, this);
        Log.d("initRecyclerView", "initRecycler: adapter instantiated");
        recyclerView.setAdapter(adapter);
        Log.d("initRecyclerView", "initRecycler: adapter Set");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d("initRecyclerView", "initRecycler: layout Set");
    }

}
