package gov.noaa.pmel.sdig.client.panels;

/**
 * Created by rhs on 3/8/17.
 */
public class DicPanel extends CommonVariablePanel {
    public DicPanel() {
        /*
DIC: Variable abbreviation in data files
DIC: Observation type
DIC: In-situ observation / manipulation condition / response variable
DIC: Manipulation method
DIC: Variable unit
DIC: Measured or calculated
DIC: Calculation method and parameters
DIC: Sampling instrument
DIC: Analyzing instrument
DIC: Detailed sampling and analyzing information
DIC: Field replicate information
DIC: Standardization technique description
DIC: Frequency of standardization
DIC: CRM manufacturer
DIC: Batch number
DIC: Poison used to kill the sample
DIC: Poison volume
DIC Poisoning correction description
DIC: Uncertainty
DIC: Data quality flag description
DIC: Method reference (citation)
DIC: Researcher Name
DIC: Researcher Institution
         */
        super();
        abbreviation.setText("DIC");
        abbreviation.setEnabled(false);
        fullVariableName.setText("Dissolved Inorganic Carbon");
        fullVariableName.setEnabled(false);
        heading.setText("Enter the information for Dissolved Inorganic Carbon (DIC)");

    }
}
