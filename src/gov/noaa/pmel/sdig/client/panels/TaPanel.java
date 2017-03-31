package gov.noaa.pmel.sdig.client.panels;

import gov.noaa.pmel.sdig.client.panels.VariablePanel;

/**
 * Created by rhs on 3/8/17.
 */
public class TaPanel extends CommonVariablePanel {
    public TaPanel() {

        super();
        abbreviation.setText("TA");
        abbreviation.setEnabled(false);
        fullVariableName.setText("Total Alkalinity");
        fullVariableName.setEnabled(false);
        heading.setText("Enter the information for Total Alkalinity (TA)");


    }
}
