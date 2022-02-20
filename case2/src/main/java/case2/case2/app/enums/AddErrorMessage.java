package case2.case2.app.enums;

public enum AddErrorMessage {
    ADDRESS_ERROR_MESSAGE("Address not found!"),
    CITY_ERROR_MESSAGE("City not found!"),
    COUNTRY_ERROR_MESSAGE("Country not found!"),
    DISTRICT_ERROR_MESSAGE("District not found!"),
    NEIGHBORHOOD_ERROR_MESSAGE("Neighborhood not found!"),
    STREET_ERROR_MESSAGE("Street not found!"),
            ;

    private String message;
    AddErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
