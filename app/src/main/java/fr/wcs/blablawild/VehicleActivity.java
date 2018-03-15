package fr.wcs.blablawild;

import android.content.Context;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VehicleActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    String[] items = { "Please Select...", "Car", "Boat", "Plane"};
    boolean app_started = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        Spinner spinner = (Spinner) findViewById(R.id.vehicleslist);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(final AdapterView parent, View view, final int position, long id) {

        final String selectedItem = parent.getItemAtPosition(position).toString();
        {EditText speed = findViewById(R.id.editText_speed);
            String editspeed = speed.getText().toString();
            final EditText model = findViewById(R.id.editText_model);
            final String editmodel = model.getText().toString();
            final EditText brand = findViewById(R.id.editText_brand);
            final String editbrand = brand.getText().toString();
            String selectedItem1 = parent.getItemAtPosition(position).toString();
            Button buttonvs = findViewById(R.id.button_vs);
            final EditText kilo = findViewById(R.id.editText_kilometers);
            final String editkilo = kilo.getText().toString();
            EditText hours = findViewById(R.id.editText_Hours);
            String edithours = hours.getText().toString();
            brand.setText("");
            model.setText("");

            if (selectedItem.equals("Please Select...")) {
                model.setEnabled(false);
                brand.setEnabled(false);
                buttonvs.setEnabled(false);
                kilo.setVisibility(View.GONE);
                hours.setVisibility(View.GONE);

            }

            String selectedItem2 = parent.getItemAtPosition(position).toString();
            if (selectedItem.equals("Car")) {
                model.setEnabled(true);
                brand.setEnabled(true);
                kilo.setVisibility(View.VISIBLE);
                hours.setVisibility(View.GONE);
                speed.setVisibility(View.GONE);
                buttonvs.setEnabled(true);

            }

            String selectedItem3 = parent.getItemAtPosition(position).toString();
            if (selectedItem.equals("Boat")) {
                model.setEnabled(true);
                brand.setEnabled(true);
                hours.setVisibility(View.VISIBLE);
                kilo.setVisibility(View.GONE);
                speed.setVisibility(View.GONE);
                buttonvs.setEnabled(true);

            }

            String selectedItem4 = parent.getItemAtPosition(position).toString();
            if (selectedItem.equals("Plane")) {
                model.setEnabled(true);
                brand.setEnabled(true);
                hours.setVisibility(View.GONE);
                kilo.setVisibility(View.GONE);
                speed.setVisibility(View.VISIBLE);
                buttonvs.setEnabled(true);

            }

        }
        final Button buttonS = findViewById(R.id.button_vs);
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText speed = findViewById(R.id.editText_speed);
                String editspeed = speed.getText().toString();
                final EditText model = findViewById(R.id.editText_model);
                String editmodel = model.getText().toString();
                final EditText brand = findViewById(R.id.editText_brand);
                String editbrand = brand.getText().toString();
                String selectedItem1 = parent.getItemAtPosition(position).toString();
                editmodel = model.getText().toString();
                editbrand = brand.getText().toString();
                final EditText kilo = findViewById(R.id.editText_kilometers);
                String editkilo = kilo.getText().toString();
                EditText hours = findViewById(R.id.editText_Hours);
                String edithours = hours.getText().toString();

                if (selectedItem.equals("Car"))

                {editkilo = kilo.getText().toString();
                int kilo1 = Integer.parseInt(kilo.getText().toString());
                final VehiclesCar stat = new VehiclesCar(editmodel, editbrand, kilo1);
                Toast.makeText(VehicleActivity.this,stat.getDescription(), Toast.LENGTH_SHORT).show();}

                if (selectedItem.equals("Boat")){
                edithours = hours.getText().toString();
                    int hours11 = Integer.parseInt(hours.getText().toString());
                    final VehicleBoat stat1 = new VehicleBoat(editmodel, editbrand,hours11);
                    Toast.makeText(VehicleActivity.this,stat1.getDescription(), Toast.LENGTH_SHORT).show();}
                if (selectedItem.equals("Plane")){
                    editspeed = speed.getText().toString();
                    int speed1 = Integer.parseInt(speed.getText().toString());
                    final VehicleBoat stat2 = new VehicleBoat(editmodel, editbrand,speed1);
                    Toast.makeText(VehicleActivity.this,stat2.getDescription(), Toast.LENGTH_SHORT).show();}

            }
        });



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
