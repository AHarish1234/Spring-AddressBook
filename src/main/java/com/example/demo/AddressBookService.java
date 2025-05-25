package com.example.demo;


import com.example.demo.AddressBookDTO;
import com.example.demo.AddressBookModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

    public List<AddressBookModel> getAllAddresses() {
        
        List<AddressBookModel> list = new ArrayList<>();
        list.add(new AddressBookModel("John Doe", "123 Main St"));
        list.add(new AddressBookModel("Jane Smith", "456 Oak Ave"));
        list.add(new AddressBookModel("Alice Johnson", "789 Pine Rd"));
        return list;
    }

    public AddressBookModel addAddress(AddressBookDTO dto) {
        
        return new AddressBookModel(dto.getName(), dto.getAddress());
    }
}
