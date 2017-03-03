package gov.noaa.pmel.sdig.client.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import gov.noaa.pmel.sdig.shared.bean.Platform;
import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;

/**
 * Created by rhs on 3/3/17.
 */
public class PlatformPanel extends Composite {

    @UiField
    TextBox title;
    @UiField
    TextArea platformAbstract;

    interface PlatformPanelUiBinder extends UiBinder<HTMLPanel, PlatformPanel> {
    }

    private static PlatformPanelUiBinder ourUiBinder = GWT.create(PlatformPanelUiBinder.class);

    public PlatformPanel() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public void show(Platform platform) {
        if ( platform.getTitle() != null ) {
            title.setText(platform.getTitle());
        }
        if ( platform.getPlatformAbstract() != null ) {
            platformAbstract.setText(platform.getPlatformAbstract() );
        }
    }
}