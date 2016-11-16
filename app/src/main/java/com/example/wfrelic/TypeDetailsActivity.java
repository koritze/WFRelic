package com.example.wfrelic;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class TypeDetailsActivity extends Activity {

    ArrayList<Item> listItems;
    ListAdapter laAdapter;
    ListView lvItems;
    String strType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_details);

        strType = getIntent().getStringExtra(MainActivity.TYPE);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //database.setPersistenceEnabled(true);

        listItems = new ArrayList<>();
        lvItems = (ListView)findViewById(R.id.lvItems);

        DatabaseReference myRef = database.getReference().child("Items");
        myRef.orderByChild("ducat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    Item item = ds.getValue(Item.class);
                    System.out.println(item.getName() + " " + item.getPart());
                    if (item.getRelics().contains(strType)) {
                        listItems.add(item);
                    }
                }
                ItemArrayAdapter adItems = new ItemArrayAdapter(TypeDetailsActivity.this, listItems);
                lvItems.setAdapter(adItems);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
}
