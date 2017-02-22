/**
 * 
 */
package gov.noaa.pmel.sdig.client.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

import gov.noaa.pmel.sdig.client.widgets.CustomTextBox;

/**
 * @author burger
 *
 */
public class AbstractPanel extends Composite {

	private static AbstractPanelUiBinder uiBinder = GWT.create(AbstractPanelUiBinder.class);
	@UiField TextArea abstractEntry;
	@UiField CustomTextBox title;
	@UiField CustomTextBox purpose;
	
	
	
	interface AbstractPanelUiBinder extends UiBinder<Widget, AbstractPanel> {
	}

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	  *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public AbstractPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
