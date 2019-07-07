package edu.gsu.student.csc4360;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        this.createBrandsSpinner();
        this.createModelsSpinner();
    }

    /**
     * Creates the Brands Dropdown menu
     */
    private void createBrandsSpinner() {
        Spinner brands_spinner = findViewById(R.id.brands_dropdown);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.brands_dropdown, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        brands_spinner.setAdapter(adapter);
    }

    /**
     * Creates the Models Dropdown menu
     */
    private void createModelsSpinner() {
        Spinner models_spinner = findViewById(R.id.models_dropdown);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.models_dropdown, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        models_spinner.setAdapter(adapter);
    }
}