package gov.noaa.pmel.sdig.client.panels;

import gov.noaa.pmel.sdig.client.Constants;

/**
 * Created by rhs on 2/27/17.
 */
public class Investigator extends PersonPanel {
    public Investigator() {
        super();
        setType(Constants.SECTION_INVESTIGATOR);
        heading.setText("Enter the information for this investigator.");
    }
}
