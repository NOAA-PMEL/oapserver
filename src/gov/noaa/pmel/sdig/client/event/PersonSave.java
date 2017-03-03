package gov.noaa.pmel.sdig.client.event;

import com.google.gwt.event.shared.GwtEvent;
import gov.noaa.pmel.sdig.shared.bean.Person;

/**
 * Created by rhs on 2/28/17.
 */
public class PersonSave extends GwtEvent<PersonSaveHandler> {

    Person person;
    String type;

    public PersonSave(Person person, String type) {
        this.type = type;
        this.person = person;
    }

    public static Type<PersonSaveHandler> TYPE = new Type<PersonSaveHandler>();

    public Type<PersonSaveHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(PersonSaveHandler handler) {
        handler.onPersonSave(this);
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public Person getPerson() {
        return this.person;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
