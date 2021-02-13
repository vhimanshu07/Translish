/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file

        setContentView(R.layout.activity_main);
        //either by over riding or by making a new class
//        NumberListener x=new NumberListener();
//
//        xy.setOnClickListener(x);
//this is for toast message but u have to comment out the latter setOnclicklistener


        //new class is numberlistener we over rided onclicklistener class's function
        TextView xy = (TextView) findViewById(R.id.numbers);
        xy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Numbers.class);
       startActivity(i);
            }
        });


        //for family
        TextView fam = (TextView) findViewById(R.id.family);
        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Familyactivity.class);
       startActivity(i);
                            }
        });

        //color
        TextView colors = (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener(){
                      @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Colorsactivity.class);
                startActivity(i);
            }

        });

        //phrases
        TextView phrases = (TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(
                new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           Intent i = new Intent(MainActivity.this, Phrasesactivity.class);
                                           startActivity(i);
                                       }
                                   });




        //These functions are of no use now as we have made intent as well as toast above only
//    public void Numberact(View view)
//    {
//        Intent i = new Intent(this, Numbers.class);
//        startActivity(i);
//    }
//    public void Familyact(View view)
//    {
//        Intent i = new Intent(this, Familyactivity.class);
//        startActivity(i);
//    }
//    public void Coloract(View view)
//    {
//        Intent i = new Intent(this, Colorsactivity.class);
//        startActivity(i);
//    }
//    public void Phrasesact(View view)
//
//    {
//        Intent i = new Intent(this, Phrasesactivity.class);
//        startActivity(i);
//    }

    }
}