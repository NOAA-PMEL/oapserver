package gov.noaa.pmel.sdig.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.RootPanel;

import gov.noaa.pmel.sdig.client.event.NavLink;
import gov.noaa.pmel.sdig.client.event.NavLinkHandler;
import gov.noaa.pmel.sdig.client.event.SectionSave;
import gov.noaa.pmel.sdig.client.event.SectionSaveHandler;
import gov.noaa.pmel.sdig.client.panels.CitationPanel;
import gov.noaa.pmel.sdig.client.panels.DicPanel;
import gov.noaa.pmel.sdig.client.panels.FundingPanel;
import gov.noaa.pmel.sdig.client.panels.InvestigatorPanel;
import gov.noaa.pmel.sdig.client.panels.PhPanel;
import gov.noaa.pmel.sdig.client.panels.PlatformPanel;
import gov.noaa.pmel.sdig.client.panels.Submitter;
import gov.noaa.pmel.sdig.client.panels.TaPanel;
import gov.noaa.pmel.sdig.client.panels.TimeAndLocationPanel;
import gov.noaa.pmel.sdig.shared.bean.Funding;
import gov.noaa.pmel.sdig.shared.bean.Person;
import gov.noaa.pmel.sdig.shared.bean.Citation;
import gov.noaa.pmel.sdig.shared.bean.Platform;
import gov.noaa.pmel.sdig.shared.bean.TimeAndLocation;
import gov.noaa.pmel.sdig.shared.bean.Variable;
import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.extras.notify.client.constants.NotifyPlacement;
import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;
import org.gwtbootstrap3.extras.notify.client.ui.NotifySettings;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class OAPMetadataEditor implements EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network " + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    //private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    ClientFactory clientFactory = GWT.create(ClientFactory.class);
    EventBus eventBus = clientFactory.getEventBus();

    List<Person> investigators = new ArrayList<Person>();
    Person theSubmitter = null;

    String activeSection = Constants.SECTION_INVESTIGATOR;

    InvestigatorPanel investigatorPanelPanel = new InvestigatorPanel();
    Submitter submitterPanel = new Submitter();

    CitationPanel citationPanel = new CitationPanel();
    Citation citation = null;

    TimeAndLocationPanel timeAndLocationPanel = new TimeAndLocationPanel();
    TimeAndLocation timeAndLocation = null;

    FundingPanel fundingPanel = new FundingPanel();
    Funding funding = null;

    PlatformPanel platformPanel = new PlatformPanel();
    List<Platform> platforms = new ArrayList<Platform>();

    DicPanel dicPanel = new DicPanel();
    Variable dic = null;

    TaPanel taPanel = new TaPanel();
    Variable ta = null;

    PhPanel phPanel = new PhPanel();
    Variable ph = null;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final DashboardLayout topLayout = new DashboardLayout();
        RootPanel.get().add(topLayout);
        topLayout.setMain(investigatorPanelPanel);
        eventBus.addHandler(SectionSave.TYPE, new SectionSaveHandler() {
            @Override
            public void onSectionSave(SectionSave event) {
                String type = event.getType();
                if (type.equals(Constants.SECTION_INVESTIGATOR)) {
                    Person person = (Person) event.getSectionContents();
                    investigators.add(person);
                } else if ( type.equals(Constants.SECTION_SUBMITTER) ) {
                    theSubmitter = (Person) event.getSectionContents();
                    if ( citation != null ) {
                        citationPanel.show(citation);
                    }
                    topLayout.setMain(citationPanel);
                } else if ( type.equals(Constants.SECTION_CITATION) ) {
                    citation = (Citation) event.getSectionContents();
                    if ( timeAndLocation != null ) {
                        timeAndLocationPanel.show(timeAndLocation);
                    }
                    topLayout.setMain(timeAndLocationPanel);
                } else if ( type.equals(Constants.SECTION_TIMEANDLOCATION) ) {
                    timeAndLocation = (TimeAndLocation) event.getSectionContents();
                    if ( funding != null ) {
                        fundingPanel.show(funding);
                    }
                    topLayout.setMain(fundingPanel);
                } else if ( type.equals(Constants.SECTION_FUNDING) ) {
                    funding = (Funding) event.getSectionContents();
                    topLayout.setMain(platformPanel);
                } else if ( type.equals(Constants.SECTION_PLATFORMS) ) {
                    Platform platform = (Platform) event.getSectionContents();
                    platforms.add(platform);
                } else if ( type.equals(Constants.SECTION_DIC) ) {
                    dic = (Variable) event.getSectionContents();
                    topLayout.setMain(taPanel);
                } else if ( type.equals(Constants.SECTION_TA) ) {
                    ta = (Variable) event.getSectionContents();
                    topLayout.setMain(phPanel);
                } else if ( type.equals(Constants.SECTION_PH) ) {
                    ph = (Variable) event.getSectionContents();
                    // PCO2A topLayout.setMain(p)
                }
            }
        });
        eventBus.addHandler(NavLink.TYPE, new NavLinkHandler() {
            @Override
            public void onNavLink(NavLink event) {
                AnchorListItem link = (AnchorListItem) event.getSource();
                if ( link.getText().equals(Constants.SECTION_INVESTIGATOR) ) {
                    topLayout.setMain(investigatorPanelPanel);
                    if ( investigators.size() > 0 ) {
                        investigatorPanelPanel.getPeople().setVisible(true);
                        investigatorPanelPanel.getPeople().setRowData(investigators);
                    }
                } else if ( link.getText().equals(Constants.SECTION_SUBMITTER) ) {
                    if ( theSubmitter != null ) {
                        submitterPanel.show(theSubmitter);
                    }
                    topLayout.setMain(submitterPanel);
                } else if ( link.getText().equals(Constants.SECTION_CITATION) ) {
                    if ( citation != null ) {
                        citationPanel.show(citation);
                    }
                    topLayout.setMain(citationPanel);
                }  else if ( link.getText().equals(Constants.SECTION_TIMEANDLOCATION) ) {
                    if ( timeAndLocation != null ) {
                        timeAndLocationPanel.show(timeAndLocation);
                    }
                    topLayout.setMain(timeAndLocationPanel);
                } else if ( link.getText().equals(Constants.SECTION_FUNDING) ) {
                    if ( funding != null ) {
                        fundingPanel.show(funding);
                    }
                    topLayout.setMain(fundingPanel);
                } else if ( link.getText().equals(Constants.SECTION_PLATFORMS) ) {
                    topLayout.setMain(platformPanel);
                    if ( platforms.size() > 0 ) {
                        platformPanel.getPlatforms().setVisible(true);
                        platformPanel.getPlatforms().setRowData(platforms);
                    }
                } else if ( link.getText().equals(Constants.SECTION_DIC) ) {
                    if ( platforms.size() > 0 ) {
                        List<String> names = new ArrayList<String>();
                        List<String> values = new ArrayList<String>();
                        for (int i = 0; i < platforms.size(); i++ ) {
                            names.add(platforms.get(i).getName());
                            values.add(platforms.get(i).getName());
                        }
                        dicPanel.getSamplingInstrument().init("Choose a Platform ", names, values);
                        dicPanel.getAnalyzingInstrument().init("Choose a Platform ", names, values);
                        topLayout.setMain(dicPanel);
                        if ( dic != null ) {
                            dicPanel.show(dic);
                        }
                    } else {
                        NotifySettings settings = NotifySettings.newSettings();
                        settings.setType(NotifyType.WARNING);
                        settings.setPlacement(NotifyPlacement.TOP_CENTER);
                        Notify.notify("You must have entered at least one platform.", settings);
                    }
                } else if ( link.getText().equals(Constants.SECTION_TA) ) {
                    if ( platforms.size() > 0 ) {
                        List<String> names = new ArrayList<String>();
                        List<String> values = new ArrayList<String>();
                        for (int i = 0; i < platforms.size(); i++ ) {
                            names.add(platforms.get(i).getName());
                            values.add(platforms.get(i).getName());
                        }
                        taPanel.getSamplingInstrument().init("Choose a Platform ", names, values);
                        taPanel.getAnalyzingInstrument().init("Choose a Platform ", names, values);
                        topLayout.setMain(taPanel);
                        if (ta != null) {
                            taPanel.show(ta);
                        }
                    } else {
                        NotifySettings settings = NotifySettings.newSettings();
                        settings.setType(NotifyType.WARNING);
                        settings.setPlacement(NotifyPlacement.TOP_CENTER);
                        Notify.notify("You must have entered at least one platform.", settings);
                    }
                } else if ( link.getText().equals(Constants.SECTION_PH) ) {
                    if (platforms.size() > 0) {
                        List<String> names = new ArrayList<String>();
                        List<String> values = new ArrayList<String>();
                        for (int i = 0; i < platforms.size(); i++) {
                            names.add(platforms.get(i).getName());
                            values.add(platforms.get(i).getName());
                        }
                        phPanel.getSamplingInstrument().init("Choose a Platform ", names, values);
                        phPanel.getAnalyzingInstrument().init("Choose a Platform ", names, values);
                        topLayout.setMain(phPanel);
                        if (ph != null) {
                            phPanel.show(ph);
                        }
                    } else {
                        NotifySettings settings = NotifySettings.newSettings();
                        settings.setType(NotifyType.WARNING);
                        settings.setPlacement(NotifyPlacement.TOP_CENTER);
                        Notify.notify("You must have entered at least one platform.", settings);
                    }
                }
            }
        });
    }
}
