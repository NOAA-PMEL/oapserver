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

public class SubmitterPanel extends Composite {

	@UiField CustomTextBox insititution;
	@UiField CustomTextBox address;
	@UiField NameTextBox name;
	@UiField PhoneNumber phoneNumber;

	private static SubmitterPanelUiBinder uiBinder = GWT.create(SubmitterPanelUiBinder.class);
	private ValueServiceAsync services;
	interface SubmitterPanelUiBinder extends UiBinder<Widget, SubmitterPanel> {
	}

	public SubmitterPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		//initWidget(uiBinder.createAndBindUi(this));

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

}
