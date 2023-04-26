public class Address {
    private String streetName;
    private String streetNumber;
    private int flatNumber;
    private String city;

    public Address(String streetName, String streetNumber, int flatNumber, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.flatNumber = flatNumber;
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Adres: " + streetName + " " + streetNumber + "/" + flatNumber + ", " + city;
    }
}
