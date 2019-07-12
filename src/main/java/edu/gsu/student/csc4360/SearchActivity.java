package edu.gsu.student.csc4360;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                closeKeyboard();
                Tire[] global_tires = Globals.db.getProducts( search_text.getText().toString());

                if ( global_tires.length == 0 ) {
                    Toast.makeText( getApplicationContext(),
                            "No items found",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                for ( Tire t : global_tires ) {
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

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
