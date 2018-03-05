package fr.wcs.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * Created by wilder on 05/03/18.
 */

public class TripAdapter extends ArrayAdapter<TripModel> {
    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // Lookup view for data population
        TextView tvfirstname =  convertView.findViewById(R.id.text_firstname);
        TextView tvlastname = convertView.findViewById(R.id.text_lastname);
        TextView tvdate = convertView.findViewById(R.id.text_date);
        TextView tvprice = convertView.findViewById(R.id.text_price);

        // Populate the data into the template view using the data object
        String priceFormat = String.valueOf(trip.getPrice());

        // Return the completed view to render on screen
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
        String Dateshow = sdf.format(trip.getDate());
        String date = Dateshow + " PM";
        String price = priceFormat + "$";

        tvdate.setText(date);
        tvfirstname.setText(trip.getFilename());
        tvlastname.setText(trip.getLastname());
        tvprice.setText(price);

        return convertView;
    }

}
