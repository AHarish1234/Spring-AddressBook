package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    public List<AddressBookModel> getAllAddresses() {
        return addressBookRepository.findAll();
    }

    public Optional<AddressBookModel> getAddressById(int id) {
        return addressBookRepository.findById(id);
    }

    public AddressBookModel addAddress(AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel();
        model.setName(dto.getName());
        model.setAddress(dto.getAddress());
        return addressBookRepository.save(model);
    }

    public Optional<AddressBookModel> updateAddress(int id, AddressBookDTO dto) {
        return addressBookRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setAddress(dto.getAddress());
            return addressBookRepository.save(existing);
        });
    }

    public boolean deleteAddress(int id) {
        if (addressBookRepository.existsById(id)) {
            addressBookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
