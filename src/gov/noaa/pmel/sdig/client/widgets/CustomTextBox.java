package gov.noaa.pmel.sdig.client.widgets;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomTextBox extends Composite {//TextBox {
	
	 String textBoxTitle;
	 String textBoxHint;
	 String defaultText;
	 TextBox textBox = null;
	 InlineLabel label = null;
	 HorizontalPanel panel = null;

	public @UiConstructor CustomTextBox(String title, String hint, String defaultText) {
		// super();
		
		panel = new HorizontalPanel();
		this.textBoxTitle = title;
		this.textBoxHint = hint;
		this.defaultText = defaultText;
		this.textBox = new TextBox();
		textBox.setText(this.defaultText);
		this.label = new InlineLabel(this.textBoxTitle);
		label.setVisible(true);
		label.setText(this.textBoxTitle);
				
		panel.add(textBox);
		panel.add(label);
		
		initWidget(panel);
		GWT.log("--------------------------------The title: " + this.textBoxTitle);
		GWT.log("--------------------------------The default Text: " + this.defaultText);
	}


	/**
	 * @return the textBoxTitle
	 */
	public String getTextBoxTitle() {
		return textBoxTitle;
	}

	/**
	 * @param textBoxTitle the textBoxTitle to set
	 */
	public void setTitle(String textBoxTitle) {
		this.textBoxTitle = textBoxTitle;
	}

	/**
	 * @return the textBoxHint
	 */
	public String getTextBoxHint() {
		return textBoxHint;
	}

	/**
	 * @param textBoxHint the textBoxHint to set
	 */
	public void setHint(String textBoxHint) {
		this.textBoxHint = textBoxHint;
	}
	
	/**
	 * @return the defaultText
	 */
	public String getDefaultText() {
		return defaultText;
	}

	/**
	 * @param defaultText the defaultText to set
	 */
	public void setDefaultText(String defaultText) {
		this.defaultText = defaultText;
	}
	

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.ValueBoxBase#setText(java.lang.String)
	 */
//	@Override
//	public void setText(String text) {
//		// TODO Auto-generated method stub
//		super.setText(text);
//	}
	
	
}
