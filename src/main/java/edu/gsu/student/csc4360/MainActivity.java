package edu.gsu.student.csc4360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @todo need to prepopulate some tires into the database when the application is launched
 * @todo need to process search
 */
public class MainActivity extends AppCompatActivity {

    // Needed to access the DatabaseHelper class
    private Globals globals;

    private Button  add, modify, search, help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.init();
    }

    /**
     * Initializes the database and tables.
     * Pre-populates the tables with content.
     * Initializes the buttons and sets their onClick listeners.
     */
    private void init() {
        // Starts the database class
        this.globals    = (Globals) getApplicationContext();
        this.globals.db = new DatabaseHelper(this);

        // @todo populate the database here @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        this.add        = findViewById(R.id.mainAddButton) ;
        this.modify     = findViewById(R.id.mainModifyButton);
        this.search     = findViewById(R.id.mainSearchButton);
        this.help       = findViewById(R.id.mainHelpButton);

        // Opens the Add new items page
        this.add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent( MainActivity.this, AddActivity.class );
                startActivity( addIntent );
            }
        });

        // Opens the Edit page
        this.modify.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modifyIntent = new Intent( MainActivity.this, EditActivity.class );
                startActivity( modifyIntent );
            }
        });

        // Opens the Help page
        this.help.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpIntent = new Intent( MainActivity.this, HelpActivity.class );
                startActivity( helpIntent );
            }
        });

        // Processes the search
        // @todo needs to be modified to actually process the search
        this.search.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent( MainActivity.this, SearchActivity.class );
                startActivity( searchIntent );
            }
        });
    }
}
