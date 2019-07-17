package edu.gsu.student.csc4360;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    private Switch orange_theme;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PrefManager.loadPreferences(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        this.init();
    }

    private void init() {
        this.orange_theme = findViewById( R.id.settings_switch );

        if ( PreferenceManager.getDefaultSharedPreferences(this).getBoolean("orange_theme", true) ) {
            this.orange_theme.setChecked(true);
        }

        this.orange_theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences.Editor editor = prefs.edit();

                if ( isChecked ) {
                    editor.putBoolean("orange_theme", true);
                } else {
                    editor.putBoolean("orange_theme", false);
                }

                editor.commit();

                // Redirect to Search after 2 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        Intent searchIntent = new Intent( SettingsActivity.this, MainActivity.class );
                        searchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity( searchIntent );
                    }
                }, 500);
            }
        });
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
                startActivity( new Intent( SettingsActivity.this, HelpActivity.class ) );
                break;
            case R.id.menu_add_new_item:
                startActivity( new Intent( SettingsActivity.this, AddActivity.class ) );
                break;
            default:
                Log.e("Activity", "Default case accessed in onOptionsItemSelected()");
        }

        return super.onOptionsItemSelected(item);
    }
}
