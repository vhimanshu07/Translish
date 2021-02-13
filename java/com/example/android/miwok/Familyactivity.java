package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Familyactivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familyactivity);

        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("पिता","Father",R.drawable.family_father,R.raw.father));
        words.add(new word("माँ ","Mother",R.drawable.family_mother,R.raw.mother));
        words.add(new word("बेटा","Son",R.drawable.family_son,R.raw.son));
        words.add(new word("बेटी","Daughter",R.drawable.family_daughter,R.raw.daughter));
        words.add(new word( "बड़ा भाई","Older brother",R.drawable.family_older_brother,R.raw.olderbro));
        words.add(new word("छोटा भाई","Younger brother",R.drawable.family_younger_brother,R.raw.yogbro));
        words.add(new word("बड़ी बहन ","Older sister",R.drawable.family_older_sister ,R.raw.oldsis));
        words.add(new word( "छोटी बहन","Younger sister",R.drawable.family_younger_sister,R.raw.yogsis));
        words.add(new word("दादी ","Grandmother ",R.drawable.family_grandmother,R.raw.grandmother));
        words.add(new word( "दादा ","Grandfather",R.drawable.family_grandfather,R.raw.grandfather));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        wordadapter adapter = new wordadapter(this, words,R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.woo);

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
                mMediaPlayer = MediaPlayer.create(Familyactivity.this, word.getsound());

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

