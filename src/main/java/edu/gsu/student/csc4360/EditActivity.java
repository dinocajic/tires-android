package edu.gsu.student.csc4360;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    private String   imported_part_number;

    private Tire     populate_tire;

    private Spinner  brands_dropdown, models_dropdown;

    private EditText part_number, width, aspect_ratio, construction, wheel_diameter, max_load, max_psi, ply,
            load_rating, speed_rating, weight, cost, sales_price, qty_per_unit;

    private Switch   has_warranty, is_dot_approved, is_disco;

    private Button   upload_image, modify_button, delete_button;

    private Tire     tire;

    private Uri      imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PrefManager.loadPreferences(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // Get the part number that was passed from Search (TireRecyclerViewAdapter)
        this.imported_part_number = "";

        if ( savedInstanceState == null ) {
            Bundle extras = getIntent().getExtras();

            if( extras == null ) {
                this.imported_part_number = "";
            } else {
                this.imported_part_number = extras.getString("part_number");
            }
        } else {
            imported_part_number = (String) savedInstanceState.getSerializable("part_number");
        }

        this.populate_tire = Globals.db.getProductByPartNumber( this.imported_part_number );

        this.init();
        this.createBrandsSpinner();
        this.createModelsSpinner();
    }

    private void init() {
        this.brands_dropdown = findViewById( R.id.brands_dropdown );
        this.models_dropdown = findViewById( R.id.models_dropdown );
        this.width           = findViewById( R.id.width );
        this.part_number     = findViewById( R.id.part_number );
        this.aspect_ratio    = findViewById( R.id.aspect_ratio );
        this.construction    = findViewById( R.id.construction );
        this.wheel_diameter  = findViewById( R.id.wheel_diameter );
        this.max_load        = findViewById( R.id.max_load );
        this.max_psi         = findViewById( R.id.max_psi );
        this.ply             = findViewById( R.id.ply );
        this.load_rating     = findViewById( R.id.load_rating );
        this.speed_rating    = findViewById( R.id.speed_rating );
        this.weight          = findViewById( R.id.weight );
        this.cost            = findViewById( R.id.cost );
        this.sales_price     = findViewById( R.id.sales_price );
        this.qty_per_unit    = findViewById( R.id.qty_per_unit );
        this.has_warranty    = findViewById( R.id.has_warranty );
        this.is_dot_approved = findViewById( R.id.dot_approved );
        this.is_disco        = findViewById( R.id.is_discontinued );
        this.upload_image    = findViewById( R.id.upload_image );
        this.modify_button   = findViewById( R.id.modifyButton );
        this.delete_button   = findViewById( R.id.deleteButton );
        this.imageUri        = null;

        this.part_number.setText(    populate_tire.getPart_number() );
        this.width.setText(          populate_tire.getWidth() );
        this.aspect_ratio.setText(   populate_tire.getAspect_ratio() );
        this.construction.setText(   populate_tire.getConstruction() );
        this.wheel_diameter.setText( populate_tire.getWheel_diameter() );
        this.max_load.setText(       populate_tire.getMax_load() );
        this.max_psi.setText(        populate_tire.getMax_psi() );
        this.ply.setText(            populate_tire.getPly() );
        this.load_rating.setText(    populate_tire.getLoad_rating() );
        this.speed_rating.setText(   populate_tire.getSpeed_rating() );
        this.weight.setText(         populate_tire.getWeight() );

        this.imageUri = Uri.parse( populate_tire.getImage() );

        this.cost.setText(           populate_tire.getCost() );
        this.sales_price.setText(    populate_tire.getSales_price() );
        this.qty_per_unit.setText(   populate_tire.getQty_per_unit() );

        this.has_warranty.setChecked(    populate_tire.getHas_warranty() );
        this.is_dot_approved.setChecked( populate_tire.getIs_dot_approved() );
        this.is_disco.setChecked(        populate_tire.getIs_discontinued() );

        // Calls the method to close the keyboard when the user presses the Return Key
        this.closeKeyboardHelper( this.part_number, this.width, this.aspect_ratio, this.construction,
                this.wheel_diameter, this.max_load, this.max_psi, this.ply, this.load_rating, this.speed_rating,
                this.weight, this.cost, this.sales_price, this.qty_per_unit );

        // Opens the File Explorer window when the user clicks on the Upload Image button
        // onActivityResult() method takes care of grabbing the content
        this.upload_image.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                final int ACTIVITY_SELECT_IMAGE = 1234;
                startActivityForResult(i, ACTIVITY_SELECT_IMAGE);
            }
        });

        // Checks to make sure everything is correct before inserting the data into the Tire object
        // and submitting it to the database.
        this.modify_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( imageUri == null ) {
                    Toast.makeText(getApplicationContext(), "Must Select Image", Toast.LENGTH_SHORT).show();
                    return;
                }

                tire = new Tire();
                tire.setId( populate_tire.getId() );

                Brand brand = Globals.db.getBrand( brands_dropdown.getSelectedItem().toString() );

                if ( !tire.setBrand(brand) ) {
                    Toast.makeText( getApplicationContext(),
                            "Brand must be selected from the dropdown",
                            Toast.LENGTH_LONG ).show();
                    return;
                }

                Model model = Globals.db.getModel( models_dropdown.getSelectedItem().toString() );

                if ( !tire.setModel(model) ) {
                    Toast.makeText( getApplicationContext(),
                            "Model must be selected from the dropdown",
                            Toast.LENGTH_LONG ).show();
                    return;
                }

                if ( !tire.setPart_number( part_number.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Part number must be between 1 and 20 alphanumeric characters and unique",
                            Toast.LENGTH_LONG ).show();
                    return;
                }

                if ( !tire.setWidth( width.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Width must be numeric with length 2 or 3, i.e. 245",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                if ( !tire.setAspect_ratio( aspect_ratio.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Aspect ratio must be numeric with length 2, i.e. 45",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                if ( !tire.setConstruction( construction.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Specify correct internal construction,  i.e. R, ZR",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                if ( !tire.setWheel_diameter( wheel_diameter.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Specify correct numeric wheel diameter, i.e. 17, 18, 22.5",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                if ( !tire.setMax_load( max_load.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Specify correct numeric Max Load, i.e. 950, 1700",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                if ( !tire.setMax_psi( max_psi.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Specify correct PSI, i.e. 35, 35.5, 104, 104.5",
                            Toast.LENGTH_LONG ).show();
                    return;
                }

                if ( !tire.setPly( ply.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Specify correct ply, i.e. 4, 5, 12",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                if ( !tire.setLoad_rating( load_rating.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Specify correct load rating, i.e. E, F",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                if ( !tire.setSpeed_rating( speed_rating.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Specify correct speed rating, i.e. Z, S",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                if ( !tire.setWeight( weight.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Specify correct weight, i.e. 50, 45.5, 105, 125.5",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                if ( !tire.setCost( cost.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Specify correct cost, i.e. 50, 99.99",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                if ( !tire.setSales_price( sales_price.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Specify sales price, i.e. 50, 99.99",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                if ( !tire.setQty_per_unit( qty_per_unit.getText().toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Specify quantity per unit, i.e. 1, 4",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                tire.setHas_warranty( has_warranty.isChecked() );
                tire.setIs_dot_approved( is_dot_approved.isChecked() );
                tire.setIs_discontinued( is_disco.isChecked() );

                // Image URI is retrieved in the onActivityResult() method
                if ( !tire.setImage( imageUri.toString() ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Please select a valid image, i.e. .jpg, .png",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                if ( Globals.db.partNumberExists( tire.getPart_number()) && !tire.getPart_number().equals( imported_part_number ) ) {
                    Toast.makeText( getApplicationContext(),
                            "Part number already exists",
                            Toast.LENGTH_SHORT ).show();
                    return;
                }

                tire.setLatestCostId(  populate_tire.getLatestCostId() );
                tire.setLatestPriceId( populate_tire.getLatestSalesPriceId() );
                tire.setImageId(       populate_tire.getImageId() );

                Globals.db.modifyProduct( tire );
                Toast.makeText(getApplicationContext(), "Tire updated successfully", Toast.LENGTH_SHORT).show();
            }
        });

        this.delete_button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Globals.db.delete( part_number.getText().toString() );
                Toast.makeText( getApplicationContext(),
                        "Item has been deleted successfully",
                        Toast.LENGTH_SHORT ).show();

                // Redirect to Search after 2 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent searchIntent = new Intent( EditActivity.this, MainActivity.class );
                        searchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity( searchIntent );
                    }
                }, 2000);
            }
        });

    }

    /**
     * Executes once the user selects the image from the gallery
     *
     * @param requestCode - request code
     * @param resultCode  - result code
     * @param data        - data
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 1234:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();

                    this.imageUri = selectedImage;
                    this.upload_image.setText( "Upload..." + selectedImage.toString().substring(0, 20) + "..." );
                } else {
                    Log.e("Image", "Not ok");
                }
        }
    }

    /**
     * Creates the Brand Dropdown menu
     */
    private void createBrandsSpinner() {
        List<String> spinnerArray =  new ArrayList<>();

        // Grab the brands from the brands table and populate them
        for ( Brand brand : Globals.db.getBrands() ) {
            spinnerArray.add( brand.getName() );
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner brands = findViewById(R.id.brands_dropdown);
        brands.setAdapter(adapter);
        brands.setSelection( adapter.getPosition( this.populate_tire.getBrand().getName()));
    }

    /**
     * Creates the Model Dropdown menu
     */
    private void createModelsSpinner() {
        List<String> spinnerArray =  new ArrayList<>();

        // Grab the brands from the brands table and populate them
        for ( Model model : Globals.db.getModels() ) {
            spinnerArray.add( model.getName() );
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner models = findViewById(R.id.models_dropdown);
        models.setAdapter(adapter);
        models.setSelection( adapter.getPosition( this.populate_tire.getModel().getName()));
    }

    /**
     * Closes the keyboard after completion. The user can press return to minimize the keyboard.
     */
    private void closeKeyboardHelper( EditText... editText ) {
        for ( EditText eText : editText ) {
            eText.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    closeKeyboard();
                }
            } );
        }
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
                startActivity( new Intent( EditActivity.this, HelpActivity.class ) );
                break;
            case R.id.menu_add_new_item:
                startActivity( new Intent( EditActivity.this, AddActivity.class ) );
                break;
            case R.id.menu_search:
                startActivity( new Intent( EditActivity.this, SearchActivity.class ) );
                break;
            case R.id.settings:
                startActivity( new Intent(EditActivity.this, SettingsActivity.class )
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK) );
                break;
            default:
                Log.e("Activity", "Default case accessed in onOptionsItemSelected()");
        }

        return super.onOptionsItemSelected(item);
    }
}