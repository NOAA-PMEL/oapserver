package gov.noaa.pmel.sdig.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import gov.noaa.pmel.sdig.client.widgets.CustomTextBox;

public class InvestigatorPanel extends Composite {
	
//	@UiField Label subjectTitle;
//	@UiField TextBox investigatorName;
//	@UiField TextBox institution;
	@UiField CustomTextBox address;
	
	private final String title = "";
	private final String hint = "";
	private final String defaultText = "";
	
	

	private static InvestigatorPanelUiBinder uiBinder = GWT.create(InvestigatorPanelUiBinder.class);

	interface InvestigatorPanelUiBinder extends UiBinder<Widget, InvestigatorPanel> {
	}
	
	
	
	public InvestigatorPanel() {
		initWidget(uiBinder.createAndBindUi(this));	
	}
	
	@UiFactory CustomTextBox makeCustomTextBox() {
		return new CustomTextBox(title, hint, defaultText);
	}

}
