package fr.android.androidexercises;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by evyil on 22/01/2016.
 */
public class RecycledBookAdapter extends RecyclerView.Adapter<RecycledBookAdapter.ViewHolder> {
    private List<Book> books;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nameTextView;
        public TextView priceTextView;
        public ViewHolder(View v) {
            super(v);
            nameTextView = (TextView) v.findViewById(R.id.nameTextView);
            priceTextView = (TextView) v.findViewById(R.id.priceTextView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecycledBookAdapter(List<Book> books) {
        this.books = books;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecycledBookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view_item_book, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nameTextView.setText(books.get(position).name);
        holder.priceTextView.setText(String.valueOf(books.get(position).price));


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return books.size();
    }
}

