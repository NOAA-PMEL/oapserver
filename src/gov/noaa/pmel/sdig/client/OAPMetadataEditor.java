package gov.noaa.pmel.sdig.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.RootPanel;

import gov.noaa.pmel.sdig.client.event.NavLink;
import gov.noaa.pmel.sdig.client.event.NavLinkHandler;
import gov.noaa.pmel.sdig.client.event.PersonSave;
import gov.noaa.pmel.sdig.client.event.PersonSaveHandler;
import gov.noaa.pmel.sdig.client.panels.Investigator;
import gov.noaa.pmel.sdig.client.panels.PlatformPanel;
import gov.noaa.pmel.sdig.client.panels.Submitter;
import gov.noaa.pmel.sdig.shared.bean.Person;
import gov.noaa.pmel.sdig.shared.bean.Platform;
import org.gwtbootstrap3.client.ui.AnchorListItem;

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

	Investigator investigator = new Investigator();
	Submitter submitter = new Submitter();

	PlatformPanel platformPanel = new PlatformPanel();
	Platform platform;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final DashboardLayout topLayout = new DashboardLayout();
		RootPanel.get().add(topLayout);
		topLayout.setMain(investigator);
		// RootPanel.get().add(new InvestigatorPanel());
		eventBus.addHandler(PersonSave.TYPE, new PersonSaveHandler() {
			@Override
			public void onPersonSave(PersonSave event) {
				Person person = event.getPerson();
				String type = event.getType();
				if (type.equals(Constants.SECTION_INVESTIGATOR)) {
					investigators.add(person);
				} else if ( type.equals(Constants.SECTION_SUBMITTER) ) {
					theSubmitter = person;
				}
			}
		});
		eventBus.addHandler(NavLink.TYPE, new NavLinkHandler() {
			@Override
			public void onNavLink(NavLink event) {
				AnchorListItem link = (AnchorListItem) event.getSource();
				if ( link.getText().equals(Constants.SECTION_INVESTIGATOR) ) {
					topLayout.setMain(investigator);
					if ( investigators.size() > 0 ) {
						investigator.getPeople().setVisible(true);
						investigator.getPeople().setRowData(investigators);

					}
				} else if ( link.getText().equals(Constants.SECTION_SUBMITTER) ) {
					if ( theSubmitter != null ) {
						submitter.show(theSubmitter);
					}
					topLayout.setMain(submitter);
				} else if ( link.getText().equals(Constants.SECTION_PLATFORM) ) {
					if ( platform != null ) {
						platformPanel.show(platform);
					}
					topLayout.setMain(platformPanel);
				}
			}
		});
	}
}
