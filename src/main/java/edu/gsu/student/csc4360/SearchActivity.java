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

    RecyclerView recyclerView;

    Button   search_button, help_button;

    EditText search_text;

    //vars
    private ArrayList<Tire> tires     = new ArrayList<>();

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
                // TODO Retrieve the content from the database based on the search parameter and add them to
                //      the tires ArrayList. This will need to be done on button click.


                for ( int i = 0; i < 100; i++ ) {
                    Tire tire = new Tire();

                    Brands brands = new Brands();
                    brands.setName("MT" + i);

                    Models models = new Models();
                    models.setName("ATZP" + i);

                    tire.setBrand( brands );
                    tire.setModel( models );

                    tire.setPart_number("900000" + i);
                    tire.setWidth("245");
                    tire.setConstruction("R");
                    tire.setWheel_diameter("17");
                    tire.setImage("abc" + i + ".jpg");
                    tires.add( tire );
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
