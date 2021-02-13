package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrasesactivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrasesactivity);
        final ArrayList<word> words = new ArrayList<word>();

        words.add(new word("तुम कहाँ जा रहे हो","Where are you going?" ,R.raw.first));
        words.add(new word("आप का नाम क्या है ","What is your name?" ,R.raw.second));
        words.add(new word( "मेरा नाम है...","My name is...",R.raw.third));
        words.add(new word("आप कैसा महसूस कर रहे हैं?","How are you feeling?",R.raw.fourth ));
        words.add(new word( "मैं अच्छा महसूस कर रहा हूँ।","I’m feeling good.",R.raw.fifth));
        words.add(new word("घर कब आ रहे है?","When are you coming home?",R.raw.sixth));
        words.add(new word("हाँ, आ रहा हूं।","Yes, I’m coming." ,R.raw.seventh));
        words.add(new word("चलो चलते हैं।","Let’s go.",R.raw.eigth));
        words.add(new word("यहाँ आओ।","Come here.",R.raw.ninth));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        wordadapter adapter = new wordadapter(this, words,R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.dee);

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
                mMediaPlayer = MediaPlayer.create(Phrasesactivity.this, word.getsound());

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
