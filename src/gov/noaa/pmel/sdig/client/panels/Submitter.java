package gov.noaa.pmel.sdig.client.panels;

import gov.noaa.pmel.sdig.client.Constants;

/**
 * Created by rhs on 2/27/17.
 */
public class Submitter extends PersonPanel {
    public Submitter() {
        super();
        setType(Constants.SECTION_SUBMITTER);
        heading.setText("Enter the information for this data submitter.");
        people.setVisible(false);
        showTable = false;
    }
}
