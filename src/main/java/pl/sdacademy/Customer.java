package pl.sdacademy;

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private Integer phoneNo;


    public Customer(Integer id, String firstName, String lastName, String address, Integer phoneNo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }
}
