package Data;

public class Address {
    public String addressLine1;
    public String addressLine2;
    public int zipcode;

    public Address(String addressLine1, String addressLine2, int zipcode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.zipcode = zipcode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
