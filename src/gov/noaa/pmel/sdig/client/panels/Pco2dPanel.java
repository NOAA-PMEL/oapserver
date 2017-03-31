package gov.noaa.pmel.sdig.client.panels;

/**
 * Created by rhs on 3/30/17.
 */
public class Pco2dPanel extends CommonVariablePanel {
    public Pco2dPanel() {
        super();
        abbreviation.setText("pCO2");
        abbreviation.setEnabled(false);
        fullVariableName.setText("pCO2");
        fullVariableName.setEnabled(false);
        heading.setText("Enter the information for pCO2D.");
    }
}

