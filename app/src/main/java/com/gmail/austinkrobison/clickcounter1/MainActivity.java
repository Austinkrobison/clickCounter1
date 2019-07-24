package com.gmail.austinkrobison.clickcounter1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class MainActivity extends AppCompatActivity implements OnClickListener{
    //initializing widgets, count, sharedValues
    private Button addCount;
    private Button resetCount;
    private TextView countLabel;
    private TextView countDisplay;
    private int count = 0;
    private SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //mandatory lines of onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting widgets & Listener
        addCount = (Button) findViewById(R.id.addCount);
        resetCount = (Button) findViewById(R.id.resetCount);
        countLabel = (TextView) findViewById(R.id.countLabel);
        countDisplay = (TextView) findViewById(R.id.countDisplay);

        addCount.setOnClickListener(this);
        resetCount.setOnClickListener(this);

        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }
    @Override
    public void onPause(){
        //ensures that count will be retained when activity is paused
        Editor editor = savedValues.edit();
        editor.putString("countString", count+"");
        editor.commit();
        super.onPause();
    }
    @Override
    public void onClick(View v){
        //ensures that program responds to button clicks
        switch (v.getId()){
            case R.id.resetCount:
                count = 0;
                countDisplay.setText("0");
                break;
            case R.id.addCount:
                count += 1;
                countDisplay.setText(count + "");
                break;

        }
    }

}
