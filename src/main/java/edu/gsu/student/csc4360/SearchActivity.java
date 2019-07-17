package edu.gsu.student.csc4360;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
        PrefManager.loadPreferences(this);

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

                tires.clear();

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

    /**
     * Creates the menu from res/menu/options
     *
     * @param menu - menu bar
     * @return boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate( R.menu.options, menu );

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Allows for the user to switch to other activities
     *
     * @param item - menu item
     * @return - boolean
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch( item.getItemId() ) {

            case R.id.menu_help:
                startActivity( new Intent( SearchActivity.this, HelpActivity.class ) );
                break;
            case R.id.menu_add_new_item:
                startActivity( new Intent( SearchActivity.this, AddActivity.class ) );
                break;
            case R.id.settings:
                finish();
                startActivity( new Intent(SearchActivity.this, SettingsActivity.class )
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK) );
                break;
            default:
                Log.e("Activity", "Default case accessed in onOptionsItemSelected()");
        }

        return super.onOptionsItemSelected(item);
    }
}
