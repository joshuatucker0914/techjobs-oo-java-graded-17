package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Location extends JobField {

    public Location(String value) {
        super(value);
    }

    public Location(int id, String value) {
        super(value); // Calling the super constructor to initialize the 'id' and 'value' fields.
    }

}
