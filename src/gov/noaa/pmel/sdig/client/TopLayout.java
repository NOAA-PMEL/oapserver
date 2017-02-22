/**
 * 
 */
package gov.noaa.pmel.sdig.client;

import com.google.gwt.user.client.ui.VerticalPanel;

import gov.noaa.pmel.sdig.client.panels.AbstractPanel;
import gov.noaa.pmel.sdig.client.panels.InvestigatorPanel;
import gov.noaa.pmel.sdig.client.panels.SubmitterPanel;

/**
 * @author burger
 *
 */
public class TopLayout extends VerticalPanel {

	public TopLayout() {
		InvestigatorPanel panel1 = new InvestigatorPanel();
		InvestigatorPanel panel2 = new InvestigatorPanel();
		SubmitterPanel panel3 = new SubmitterPanel();
		AbstractPanel panel4 = new AbstractPanel();
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
	}


}
