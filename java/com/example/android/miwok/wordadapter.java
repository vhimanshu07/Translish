package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class wordadapter extends ArrayAdapter<word> {
private int colorid;
    public wordadapter(Context a, ArrayList<word> f,int id)
    {
        super(a,0, f);
        colorid=id;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.layoutfile, parent, false);
        }
        word local_word = getItem(position);

        TextView hind = (TextView) listItemView.findViewById(R.id.text1);
        hind.setText(local_word.gethindi());
        TextView engl = (TextView) listItemView.findViewById(R.id.text2);
        engl.setText(local_word.getenglish());
        ImageView    fa=(ImageView)listItemView.findViewById(R.id.hel);
        if (local_word.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            fa.setImageResource(local_word.getImageid());
            // Make sure the view is visible
            fa.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            fa.setVisibility(View.GONE);
        }
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), colorid);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);



        return listItemView;
    }


}
