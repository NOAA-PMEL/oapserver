package gov.noaa.pmel.sdig.client.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import gov.noaa.pmel.sdig.client.ClientFactory;
import gov.noaa.pmel.sdig.client.Constants;
import gov.noaa.pmel.sdig.client.event.SectionSave;
import gov.noaa.pmel.sdig.shared.bean.Platform;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Form;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.gwt.CellTable;
import org.gwtbootstrap3.extras.notify.client.constants.NotifyPlacement;
import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;
import org.gwtbootstrap3.extras.notify.client.ui.NotifySettings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rhs on 3/7/17.
 */
public class PlatformPanel extends Composite {

    ClientFactory clientFactory = GWT.create(ClientFactory.class);
    EventBus eventBus = clientFactory.getEventBus();

    @UiField
    TextBox name;
    @UiField
    TextBox platformId;
    @UiField
    TextBox country;
    @UiField
    TextBox owner;
    @UiField
    TextBox platformType;

    @UiField
    CellTable platforms;

    @UiField
    Button save;
    @UiField
    Form form;

    boolean showTable = true;

    String type = Constants.SECTION_PLATFORMS;

    interface PlatformPanelUiBinder extends UiBinder<HTMLPanel, PlatformPanel> {
    }

    private static PlatformPanelUiBinder ourUiBinder = GWT.create(PlatformPanelUiBinder.class);

    public PlatformPanel() {
        initWidget(ourUiBinder.createAndBindUi(this));
        platforms.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);

        // Add a text column to show the name.
        TextColumn<Platform> nameColumn = new TextColumn<Platform>() {
            @Override
            public String getValue(Platform object) {
                return object.getName();
            }
        };
        platforms.addColumn(nameColumn, "Name");

        TextColumn<Platform> platformTypeColumn = new TextColumn<Platform>() {
            @Override
            public String getValue(Platform object) {
                return object.getPlatformType();
            }
        };
        platforms.addColumn(platformTypeColumn, "Platform ID");

        TextColumn<Platform> platformIdColumn = new TextColumn<Platform>() {
            @Override
            public String getValue(Platform object) {
                return object.getPlatformId();
            }
        };
        platforms.addColumn(platformIdColumn, "Platform ID");
    }

    public Platform getPlatform() {
        Platform platform = new Platform();
        platform.setCountry(country.getText().trim());
        platform.setName(name.getText().trim());
        platform.setOwner(owner.getText().trim());
        platform.setPlatformId(platformId.getText().trim());
        platform.setPlatformType(platformType.getText().trim());
        return platform;
    }
    public void show(Platform platform) {
        if ( platform.getCountry() != null ) {
            country.setText(platform.getCountry());
        }
        if ( platform.getName() != null ) {
            name.setText(platform.getName());
        }
        if ( platform.getOwner() != null ) {
            owner.setText(platform.getOwner());
        }
        if ( platform.getPlatformId() != null ) {
            platformId.setText(platform.getPlatformId());
        }
        if ( platform.getPlatformType() != null ) {
            platformType.setText(platform.getPlatformType());
        }
    }
    @UiHandler("save")
    public void onSave(ClickEvent clickEvent) {

        // For some reason this returns a "0" in debug mode.
        String valid = String.valueOf(form.validate());
        if (valid.equals("false") || valid.equals("0")) {
            NotifySettings settings = NotifySettings.newSettings();
            settings.setType(NotifyType.WARNING);
            settings.setPlacement(NotifyPlacement.TOP_CENTER);
            Notify.notify("Entry is not complete! See form fields highlighted in red.", settings);
        } else {
            List<Platform> plats = new ArrayList<Platform>();
            Platform p = getPlatform();
            plats.add(p);
            eventBus.fireEventFromSource(new SectionSave(p, this.type), PlatformPanel.this);
            platforms.setRowData(platforms.getRowCount(), plats);
            NotifySettings settings = NotifySettings.newSettings();
            settings.setType(NotifyType.SUCCESS);
            settings.setPlacement(NotifyPlacement.TOP_CENTER);
            Notify.notify("Entry Saved!", settings);
            if ( showTable ) {
                platforms.setVisible(true);
                form.reset();
            }
        }
    }
    public CellTable getPlatforms() {
        return platforms;
    }
}