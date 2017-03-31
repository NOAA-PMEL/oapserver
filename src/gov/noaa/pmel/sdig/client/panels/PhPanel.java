package gov.noaa.pmel.sdig.client.panels;

/**
 * Created by rhs on 3/22/17.
 */
public class PhPanel extends CommonVariablePanel {
    public PhPanel() {

        super();
        abbreviation.setText("pH");
        abbreviation.setEnabled(false);
        fullVariableName.setText("pH");
        fullVariableName.setEnabled(false);
        heading.setText("Enter the information for pH.");

        // 005 Variable unit
        unitsForm.setVisible(false);
  
  
    }
}
