package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button buttonsearch= findViewById(R.id.button_search);
        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView editdate = findViewById(R.id.edit_date);
                String date = editdate.getText().toString();
                TextView editdeparture = findViewById(R.id.edit_departure);
                TextView editdestination = findViewById(R.id.edit_destination);
                String departure= editdeparture.getText().toString();
                String destination = editdestination.getText().toString();
                if(editdeparture.length()==0 || destination.length()==0){
                    Toast.makeText(Main2Activity.this, "Enter Departure and Destination", Toast.LENGTH_SHORT).show();
                }else {
                   /* Intent appel = new Intent(Main2Activity.this, ItineraryListActivity.class);
                    startActivity(appel);

                    appel.putExtra("depart", editdeparture.getText().toString());
                    appel.putExtra("destination", destination);
                    startActivity(appel);*/

                    Intent intentSearch = new Intent(Main2Activity.this, ItineraryListActivity.class);
                    SearchModel troisEnUn = new SearchModel(departure, destination, date);
                    intentSearch.putExtra("troisEnUn",troisEnUn);
                    startActivity(intentSearch);
                }


            }
        });



    }
}