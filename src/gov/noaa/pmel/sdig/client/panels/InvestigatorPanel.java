package gov.noaa.pmel.sdig.client.panels;

import gov.noaa.pmel.sdig.client.Constants;
import gov.noaa.pmel.sdig.shared.bean.Person;

import java.util.List;

/**
 * Created by rhs on 2/27/17.
 */
public class InvestigatorPanel extends PersonPanel {
    public InvestigatorPanel() {
        super();
        setType(Constants.SECTION_INVESTIGATOR);
        heading.setText("Enter the information for this investigator.");
    }

}
