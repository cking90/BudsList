package edu.gatech.hackgt.budslist;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BookRecyclerViewAdapter extends
        RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> bookNames = new ArrayList<>();
    private ArrayList<String> bookAuthors = new ArrayList<>();
    private ArrayList<String> bookPrices = new ArrayList<>();
    private ArrayList<String> bookSellers = new ArrayList<>();
    private ArrayList<String> bookISBNs = new ArrayList<>();
    private Context mContext;

    public BookRecyclerViewAdapter(ArrayList<String> bookNames, ArrayList<String> bookPrices,
                                        ArrayList<String> bookAuthors, ArrayList<String> bookSellers,
                                        ArrayList<String> isbns, Context context) {
        this.bookAuthors = bookAuthors;
        this.bookNames = bookNames;
        this.bookSellers = bookSellers;
        this.bookPrices = bookPrices;
        this.bookISBNs = isbns;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_book_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bookName.setText(bookNames.get(position));
        holder.bookPrice.setText(bookPrices.get(position));
        holder.bookAuthor.setText(bookAuthors.get(position));
        holder.bookSeller.setText(bookSellers.get(position));
        holder.bookIsbn.setText(bookISBNs.get(position));

    }

    @Override
    public int getItemCount() {
        return bookAuthors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView bookName;
        TextView bookPrice;
        TextView bookSeller;
        TextView bookAuthor;
        TextView bookIsbn;
        RelativeLayout parentLayout;

        /**
         * References the layout_location_item
         * used to map individual elements in the recycler view
         * @param itemView the layout_location_item
         */
        public ViewHolder(View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.bookNameTextView);
            bookPrice = itemView.findViewById(R.id.bookPriceTextView);
            bookSeller = itemView.findViewById(R.id.bookSellerTextView);
            bookAuthor = itemView.findViewById(R.id.bookAuthorTextView);
            bookIsbn = itemView.findViewById(R.id.bookISBNTextView);
            parentLayout = itemView.findViewById(R.id.bookAdapterLayout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), MakeRequestActivity.class);
                    intent.putExtra("seller_email", bookSeller.getText().toString());
                    intent.putExtra("book_price", bookPrice.getText().toString());
                    intent.putExtra("book_isbn", bookIsbn.getText().toString());

                    view.getContext().startActivity(intent);
                }
            });

        }
    }
}
