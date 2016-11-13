package com.example.wfrelic;

import android.app.Activity;
import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    public static final String TYPE = "Type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Button type1 = (Button)findViewById(R.id.type1);
        Button type2 = (Button)findViewById(R.id.type2);
        Button type3 = (Button)findViewById(R.id.type3);
        Button type4 = (Button)findViewById(R.id.type4);
        Button type5 = (Button)findViewById(R.id.type5);*/


    }

    public void sendOnClick(int type)
    {
        Intent intent = new Intent(this, TypeDetailsActivity.class);
        intent.putExtra(TYPE,type);
        startActivity(intent);
    }

    public void type1OnClick(View view)
    {
        sendOnClick(1);
    }

    public void type2OnClick(View view)
    {
        sendOnClick(2);
    }

    public void type3OnClick(View view)
    {
        sendOnClick(3);
    }

    public void type4OnClick(View view)
    {
        sendOnClick(4);
    }

    /*public void type5OnClick(View view)
    {
        sendOnClick(5);
    }*/
}