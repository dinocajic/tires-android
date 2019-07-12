package edu.gsu.student.csc4360;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private Button          search_button, help_button;
    private EditText        search_text;
    private ArrayList<Tire> tires = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        init();
    }

    private void init(){
        this.search_button = findViewById( R.id.searchButton );
        this.help_button   = findViewById( R.id. helpButton );
        this.search_text   = findViewById( R.id.search_text );

        this.search_button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                for ( Tire t : Globals.db.getProducts( search_text.getText().toString() ) ) {
                    tires.add(t);
                }

                initRecyclerView();
            }
        } );

        // Opens the Help page
        this.help_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpIntent = new Intent( SearchActivity.this, HelpActivity.class );
                startActivity( helpIntent );
            }
        });
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        TireRecyclerViewAdapter adapter = new TireRecyclerViewAdapter(this, tires);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
