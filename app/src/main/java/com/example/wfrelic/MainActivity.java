package com.example.wfrelic;

import android.app.Activity;
import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends Activity {

    public static final String TYPE = "Type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendOnClick(View view)
    {
        //Toast.makeText(this,String.valueOf(view.getTag()),Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, TypeDetailsActivity.class);
        intent.putExtra(TYPE,String.valueOf(view.getTag()));
        startActivity(intent);
    }
}
