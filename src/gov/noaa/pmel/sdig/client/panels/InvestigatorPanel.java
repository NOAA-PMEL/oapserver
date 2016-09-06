package gov.noaa.pmel.sdig.client.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gov.noaa.pmel.sdig.client.ValueService;
import gov.noaa.pmel.sdig.client.ValueServiceAsync;
import gov.noaa.pmel.sdig.client.widgets.CustomTextBox;
import gov.noaa.pmel.sdig.client.widgets.NameTextBox;
import gov.noaa.pmel.sdig.client.widgets.PhoneNumber;
import gov.noaa.pmel.sdig.shared.CountryCodes;

public class InvestigatorPanel extends Composite {

	@UiField
	CustomTextBox insititution;
	@UiField
	CustomTextBox address;
	@UiField
	NameTextBox name;
	@UiField
	PhoneNumber phoneNumber;

	private final String title = "";
	private final String hint = "";
	private final String defaultText = "";

	private static InvestigatorPanelUiBinder uiBinder = GWT.create(InvestigatorPanelUiBinder.class);
	private ValueServiceAsync services;

	interface InvestigatorPanelUiBinder extends UiBinder<Widget, InvestigatorPanel> {
	}

	public InvestigatorPanel() {
		initWidget(uiBinder.createAndBindUi(this));

		services = GWT.create(ValueService.class);

		services.getCountryCodes(new AsyncCallback<CountryCodes>() {

			@Override
			public void onSuccess(CountryCodes result) {
				phoneNumber.setCountryCodes(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}
	
	public String getInstitution() {
		return insititution.getCustomTextBoxValue();
	}
	
	
//	@UiFactory CustomTextBox makeCustomTextBox() {
//		return new CustomTextBox(title, hint, defaultText);
//	}

}
