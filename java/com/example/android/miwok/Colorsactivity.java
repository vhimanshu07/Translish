package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colorsactivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorsactivity);
        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word( "सफेद   ","White",R.drawable.color_white,R.raw.white));
        words.add(new word( "काली","Black",R.drawable.color_black,R.raw.black));
        words.add(new word("धूसर", "Gray",R.drawable.color_gray,R.raw.gray));
        words.add(new word("लाल", "Red",R.drawable.color_red,R.raw.red));
        words.add(new word("पीला", "Mustard yellow",R.drawable.color_dusty_yellow,R.raw.yellow));
        words.add(new word("हरा", "Green",R.drawable.color_green,R.raw.green));
        words.add(new word("भूरा", "Brown",R.drawable.color_brown,R.raw.brown));




        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        wordadapter adapter = new wordadapter(this, words,R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.hell);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(Colorsactivity.this, word.getsound());

                // Start the audio file
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        //code
                    }
                });
            }
        });
    }
}
