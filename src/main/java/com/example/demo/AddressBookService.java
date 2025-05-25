package com.example.demo;

import com.example.demo.AddressBookDTO;
import com.example.demo.AddressBookModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    private List<AddressBookModel> addressList = new ArrayList<>();
    private int idCounter = 1;

    public AddressBookService() {
        addressList.add(new AddressBookModel(idCounter++, "John Doe", "123 Main St"));
        addressList.add(new AddressBookModel(idCounter++, "Jane Smith", "456 Oak Ave"));
        addressList.add(new AddressBookModel(idCounter++, "Alice Johnson", "789 Pine Rd"));
    }

    public List<AddressBookModel> getAllAddresses() {
        return addressList;
    }

    public Optional<AddressBookModel> getAddressById(int id) {
        return addressList.stream().filter(a -> a.getId() == id).findFirst();
    }

    public AddressBookModel addAddress(AddressBookDTO dto) {
        AddressBookModel newAddress = new AddressBookModel(idCounter++, dto.getName(), dto.getAddress());
        addressList.add(newAddress);
        return newAddress;
    }

    public Optional<AddressBookModel> updateAddress(int id, AddressBookDTO dto) {
        Optional<AddressBookModel> existingAddress = getAddressById(id);
        existingAddress.ifPresent(address -> {
            address.setName(dto.getName());
            address.setAddress(dto.getAddress());
        });
        return existingAddress;
    }

    public boolean deleteAddress(int id) {
        return addressList.removeIf(address -> address.getId() == id);
    }
}
