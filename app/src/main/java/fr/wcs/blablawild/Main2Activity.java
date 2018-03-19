package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button buttonsearch = findViewById(R.id.button_search);
        final TextView editdeparture = findViewById(R.id.edit_departure);
        final TextView editdestination = findViewById(R.id.edit_destination);
        final EditText editdate = (EditText) findViewById(R.id.edit_date);
        final Calendar myCalendar = Calendar.getInstance();


        final DatePickerDialog.OnDateSetListener dateClick = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(editdate, myCalendar);
            }


        };
        editdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Main2Activity.this, dateClick, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }


        });
        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String departure = editdeparture.getText().toString();
                String destination = editdestination.getText().toString();
                String date = editdate.getText().toString();
                if (editdeparture.length() == 0 || destination.length() == 0) {
                    Toast.makeText(Main2Activity.this, "Enter Departure and Destination", Toast.LENGTH_SHORT).show();
                } else {
                   /* Intent appel = new Intent(Main2Activity.this, ItineraryListActivity.class);
                    startActivity(appel);

                    appel.putExtra("depart", editdeparture.getText().toString());
                    appel.putExtra("destination", destination);
                    startActivity(appel);*/

                    Intent intentSearch = new Intent(Main2Activity.this, ItineraryListActivity.class);
                    SearchModel troisEnUn = new SearchModel(departure, destination, date);
                    intentSearch.putExtra("troisEnUn", troisEnUn);
                    startActivity(intentSearch);
                }


            }
        });

    }

    private void updateLabel(EditText editdate, Calendar myCalendar) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        editdate.setText(sdf.format(myCalendar.getTime()));
    }
}