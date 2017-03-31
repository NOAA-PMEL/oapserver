package gov.noaa.pmel.sdig.shared.bean;

/**
 * Created by rhs on 3/7/17.
 */
public class Funding {
    String agencyName;
    String grantTitle;
    String grandNumber;

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getGrantTitle() {
        return grantTitle;
    }

    public void setGrantTitle(String title) {
        this.grantTitle = title;
    }

    public String getGrandNumber() {
        return grandNumber;
    }

    public void setGrandNumber(String grandNumber) {
        this.grandNumber = grandNumber;
    }
}
