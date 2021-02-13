package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Numbers extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

       // String b[]={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
       final ArrayList<word> a=new ArrayList<>();
        a.add(new word("एक","One",R.drawable.number_one,R.raw.number_one));
        a.add(new word( "दो","Two" ,R.drawable.number_two,R.raw.number2));
        a.add(new word( "तीन","Three" ,R.drawable.number_three,R.raw.number3));
        a.add(new word( "चार","Four" ,R.drawable.number_four,R.raw.number4));
        a.add(new word( "पांच", "Five",R.drawable.number_five,R.raw.number5));
        a.add(new word("छह" ,"Six",R.drawable.number_six ,R.raw.number6));
        a.add(new word("सात" ,"Seven" ,R.drawable.number_seven,R.raw.number7));
        a.add(new word( "आठ", "Eight",R.drawable.number_eight,R.raw.number8));
        a.add(new word("नौ" ,"Nine" ,R.drawable.number_nine,R.raw.number9));
        a.add(new word( "दस", "Ten",R.drawable.number_ten,R.raw.number10));



        //it was used to add linear layout to the numbers class
        // but if the value of arraylist is too long then the memory allocated is too large
        //so we will use list view and array adapter

//        LinearLayout x=(LinearLayout)findViewById(R.id.line);
//        for(int i=0;i<a.size();i++) {
//            TextView word = new TextView(this);
//            word.setText(a.get(i));
//            x.addView(word);
//        }

//        ArrayAdapter<word> itemsAdapter = new ArrayAdapter<word>(this, android.R.layout.simple_list_item_1, a);
//yeh by default layout hota h we created our own layout



        //ArrayAdapter<word> itemsAdapter = new ArrayAdapter<word>(this, R.layout.layoutfile, a);

        //  In by default arrayadapter problem starts coming as word class has two string
        //so we had to make our own arrayadapter i.e wordadapter which extends arrayadapter
        //so it's method need to be over ridden



        wordadapter itemsAdapter=new wordadapter(this,a,R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                word word = a.get(position);

//                 Create and setup the {@link MediaPlayer} for the audio resource associated
//                 with the current word
                mMediaPlayer = MediaPlayer.create(Numbers.this, word.getsound());

                // Start the audio file
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        //code
                    }
                });
            }
        });

//        Log.v("Numbers","value of second index"+a.get(0));
        //used to show value
    }

}
