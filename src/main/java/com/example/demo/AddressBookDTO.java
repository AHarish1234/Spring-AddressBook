package com.example.demo;

public class AddressBookDTO {
    private String name;
    private String address;

    // Default constructor
    public AddressBookDTO() {
    }

    // Parameterized constructor
    public AddressBookDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // toString (optional, helpful for logging/debugging)
    @Override
    public String toString() {
        return "AddressBookDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
