package com.sveval.wakeup;

import java.util.ArrayList;

/**
 * Created by Swetko on 30. 12. 2016.
 */
public class Destination {
    public static ArrayList<Destination> destinations = new ArrayList<Destination>();
    public String vstop;
    public String iztop;

    public Destination (String vstop, String iztop) {
        this.vstop = vstop;
        this.iztop = iztop;
    }

    public static ArrayList<Destination> getDestinations() {

        //destinations.add(new Destination("Ljubljana", "Maribor"));
        //destinations.add(new Destination("Maribor", "Koper"));

        return destinations;
    }
}
