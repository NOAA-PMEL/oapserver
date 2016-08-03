package gov.noaa.pmel.sdig.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class InvestigatorPanel extends Composite {

	private static InvestigatorPanelUiBinder uiBinder = GWT.create(InvestigatorPanelUiBinder.class);

	interface InvestigatorPanelUiBinder extends UiBinder<Widget, InvestigatorPanel> {
	}

	@UiField
	Label subjectTitle;
	
	public InvestigatorPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		
		
		
	}

}
