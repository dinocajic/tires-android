package edu.gsu.student.csc4360;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    //vars
    private ArrayList<Tire> brands     = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initImageBitmaps();
    }

    private void initImageBitmaps(){

        for ( int i = 0; i < 100; i++ ) {
            Tire tire = new Tire();
            tire.setBrand("MT" + i);
            tire.setModel("ATZP" + i);
            tire.setPart_number("900000" + i);
            tire.setWidth("245");
            tire.setConstruction("R");
            tire.setWheel_diameter("17");
            tire.setImage("abc" + i + ".jpg");
            brands.add( tire );
        }

        initRecyclerView();
    }

    private void initRecyclerView(){

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        TireRecyclerViewAdapter adapter = new TireRecyclerViewAdapter(this, brands);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
