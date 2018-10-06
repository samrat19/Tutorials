package com.example.samrat.tutorials;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StorageAdapter extends ArrayAdapter<StoreList> {

    public StorageAdapter(Context context, List<StoreList> movieLists) {
        super(context, 0, movieLists);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.mystorage, parent, false);
        }

        StoreList movieList = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.topicname);

        nameTextView.setText(movieList.topicname);


        return listItemView;
    }
}
