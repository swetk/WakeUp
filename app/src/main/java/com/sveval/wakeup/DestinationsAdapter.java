package com.sveval.wakeup;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Swetko on 30. 12. 2016.
 */
public class DestinationsAdapter extends ArrayAdapter<Destination> {
    public DestinationsAdapter (Context context, ArrayList<Destination> destinations) {
        super(context, 0, destinations);
    }

    public View getView (final int position, View convertView, ViewGroup parent) {
        final Destination destination = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.destination_list, parent, false);
        }

        TextView textVstop = (TextView) convertView.findViewById(R.id.twVstop);
        textVstop.setText("Start: " + destination.vstop);

        TextView textIztop = (TextView) convertView.findViewById(R.id.twIztop);
        textIztop.setText("Cilj: " + destination.iztop);

        /*
        Button btnDestination = (Button) convertView.findViewById(R.id.buttonDestionation);
        btnDestination.setText(destination.vstop + " - " + destination.iztop);
        btnDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ee = Destination.destinations.get(position).vstop;
                String eee = Destination.destinations.get(position).iztop;
                System.out.println("position " + position);
                System.out.println(ee);
                System.out.println(eee);
            }
        });
        */

        Switch switchOnOff = (Switch) convertView.findViewById(R.id.switchOnOff);
        switchOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    System.out.println("switch on position: " + position + " set on");
                }
                else {
                    System.out.println("switch on position: " + position + " set off");
                }
            }
        });

        /*
        ImageButton imgButtonDelete = (ImageButton) convertView.findViewById(R.id.imgButtonDelete);
        imgButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("position " + position);
                Toast.makeText(getContext(),  "Destination removed",
                        Toast.LENGTH_LONG).show();
                Destination.destinations.remove(position);
            }
        });
        */

        return convertView;
    }
}
