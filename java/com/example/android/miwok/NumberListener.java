package com.example.android.miwok;


import android.view.View;
import android.widget.Toast;

public class NumberListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(),"Open the list of Numbers",Toast.LENGTH_LONG).show();
    }
}
