/**
 * 
 */
package gov.noaa.pmel.sdig.client;

import com.google.gwt.user.client.ui.VerticalPanel;

import gov.noaa.pmel.sdig.client.panels.InvestigatorPanel;

/**
 * @author burger
 *
 */
public class TopLayout extends VerticalPanel {

	public TopLayout() {
		InvestigatorPanel panel1 = new InvestigatorPanel();
		InvestigatorPanel panel2 = new InvestigatorPanel();
		this.add(panel1);
		this.add(panel2);
	}


}
