package gov.noaa.pmel.sdig.client.panels;

/**
 * Created by rhs on 3/22/17.
 */
public class Pco2aPanel extends CommonVariablePanel {
    public Pco2aPanel() {
        super();
        abbreviation.setText("pCO2");
        abbreviation.setEnabled(false);
        fullVariableName.setText("pCO2");
        fullVariableName.setEnabled(false);
        heading.setText("Enter the information for pCO2A.");
    }
}
