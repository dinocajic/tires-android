package edu.gsu.student.csc4360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @todo need to prepopulate some tires into the database when the application is launched
 * @todo need to process search
 */
public class MainActivity extends AppCompatActivity {

    private Button    add, search, help;
    private ImageView banner;
    private String    banner_uri = "http://mickeythompsontires.com";

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
        Globals.db = new DatabaseHelper(this);

        // @todo populate the database here @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        this.add        = findViewById(R.id.mainAddButton) ;
        this.search     = findViewById(R.id.mainSearchButton);
        this.help       = findViewById(R.id.mainHelpButton);
        this.banner     = findViewById(R.id.mickeyThompsonBanner);

        // Opens the Add new items page
        this.add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent( MainActivity.this, AddActivity.class );
                startActivity( addIntent );
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

        this.banner.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if ( !Connectivity.isOnline() ) {
                    Toast.makeText(getApplicationContext(), "Internet Not Available", Toast.LENGTH_LONG).show();
                    return;
                }

                Uri uri = Uri.parse( banner_uri );
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        } ) ;

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
