package edu.gsu.student.csc4360;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        this.add_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // todo insert into database
            }
        });
    }
}
