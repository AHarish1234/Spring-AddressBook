package com.example.demo;

import com.example.demo.AddressBookDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.Arrays;
import java.util.List;

@RestController
public class AddressController {

    @GetMapping("/addressbook")
    public List<AddressBookDTO> getAddressBookData() {
  
        return Arrays.asList(
            new AddressBookDTO("John Doe", "123 Main St"),
            new AddressBookDTO("Jane Smith", "456 Oak Ave"),
            new AddressBookDTO("Alice Johnson", "789 Pine Rd")
        );
    }
    @PostMapping("/create")
    public ResponseEntity<String> addAddressBookEntry(@RequestBody AddressBookDTO addressBookDTO) {
        return ResponseEntity.ok("Created Address Book Entry: " + addressBookDTO.toString());
    }

}
