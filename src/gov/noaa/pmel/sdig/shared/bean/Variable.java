package gov.noaa.pmel.sdig.shared.bean;

/**
 * Created by rhs on 3/8/17.
 */
public class Variable {

    String abbreviation;
    String manipulationMethod;
    String observationType;
    String observationDetail;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getManipulationMethod() {
        return manipulationMethod;
    }

    public void setManipulationMethod(String manipulationMethod) {
        this.manipulationMethod = manipulationMethod;
    }

    public String getObservationType() {
        return observationType;
    }

    public void setObservationType(String observationType) {
        this.observationType = observationType;
    }

    public String getObservationDetail() {
        return observationDetail;
    }

    public void setObservationDetail(String observationDetail) {
        this.observationDetail = observationDetail;
    }
}
