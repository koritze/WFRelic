package com.example.wfrelic;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

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
    EditText txtSearch;
    ProgressBar pbLoad;
    ItemArrayAdapter adItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_details);

        strType = getIntent().getStringExtra(MainActivity.TYPE);
        FirebaseDatabase database = FirebaseDatabase.getInstance();


        listItems = new ArrayList<>();
        lvItems = (ListView)findViewById(R.id.lvItems);

        pbLoad = (ProgressBar)findViewById(R.id.progressBar);

        DatabaseReference myRef = database.getReference().child("Items");

        DatabaseReference connectedRef = FirebaseDatabase.getInstance().getReference(".info/connected");
        connectedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                boolean connected = snapshot.getValue(Boolean.class);
                if (!connected) {
                        Toast.makeText(TypeDetailsActivity.this, R.string.networknotavailable, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.err.println("Listener was cancelled");
            }
        });

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
                adItems = new ItemArrayAdapter(TypeDetailsActivity.this, listItems);
                lvItems.setAdapter(adItems);
                pbLoad.setVisibility(View.GONE);
                txtSearch.setEnabled(true);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        txtSearch = (EditText)findViewById(R.id.inputSearch);
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                TypeDetailsActivity.this.adItems.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
