package edu.gsu.student.csc4360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

public class AddActivity extends AppCompatActivity {

    private Spinner  brands_dropdown, models_dropdown;

    private EditText part_number, width, construction, wheel_diameter, max_load, max_psi, ply,
                     load_rating, speed_rating, weight, cost, sales_price, qty_per_unit;

    private Switch   has_warranty, is_dot_approved, is_disco;

    private Button   upload_image, add_button;

    private Tire     tire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        this.init();

        // GENERAL OVERVIEW ------------------------------------------------------------------------
        // todo add listeners
        // todo on button click, grab all of the EditText fields
        // todo create Tire object and insert all of the data into it
        // todo tire object should verify data validity
        // todo call Globals.db.insert() and pass the Tire object to it
        // -----------------------------------------------------------------------------------------
    }

    private void init() {
        this.brands_dropdown = findViewById( R.id.brands_dropdown );
        this.models_dropdown = findViewById( R.id.models_dropdown );
        this.width           = findViewById( R.id.width );
        this.part_number     = findViewById( R.id.part_number );
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
        this.add_button      = findViewById( R.id.add_button );

        this.upload_image.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                final int ACTIVITY_SELECT_IMAGE = 1234;
                startActivityForResult(i, ACTIVITY_SELECT_IMAGE);
            }
        } );

        // todo Need to add on click listeners to most items so that the insides would clear if they match
        // todo certain text and then if empty need to re-add the tip-text

        this.add_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tire = new Tire();
                tire.setBrand( brands_dropdown.getSelectedItem().toString() );
                tire.setModel( models_dropdown.getSelectedItem().toString() );
                tire.setWidth( width.getText().toString() );
                tire.setPart_number( part_number.getText().toString() );
                tire.setConstruction( construction.getText().toString() );
                tire.setWheel_diameter( wheel_diameter.getText().toString() );
                tire.setMax_load( max_load.getText().toString() );
                tire.setMax_psi( max_psi.getText().toString() );
                tire.setPly( ply.getText().toString() );
                tire.setLoad_rating( load_rating.getText().toString() );
                tire.setSpeed_rating( speed_rating.getText().toString() );
                tire.setWeight( weight.getText().toString() );
                tire.setCost( cost.getText().toString() );
                tire.setSales_price( sales_price.getText().toString() );
                tire.setQty_per_unit( qty_per_unit.getText().toString() );
                tire.setHas_warranty( has_warranty.isChecked() );
                tire.setIs_dot_approved( is_dot_approved.isChecked() );
                tire.setIs_discontinued( is_disco.isChecked() );

                // todo need to add the ability to add photo to drawabale and move photo name
                // todo not sure if the bottom portion is correct
                tire.setImage( upload_image.getText().toString() );

                // Inserts the tire into the database
                Globals.db.insert( tire );
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 1234:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();


                    Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
                    /* Now you have choosen image in Bitmap format in object "yourSelectedImage". You can use it in way you want! */

                    Log.e("Image: ", selectedImage.toString());
                } else {
                    Log.e("Image", "Not ok");
                }
        }

    };
}
