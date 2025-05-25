package com.example.demo;

import com.example.demo.AddressBookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressController {

    private List<AddressBookDTO> addressBookList = new ArrayList<>();

    // GET all entries
    @GetMapping("/get")
    public ResponseEntity<List<AddressBookDTO>> getAddressBook() {
        return ResponseEntity.ok(addressBookList);
    }

    // POST new entry
    @PostMapping("/post")
    public ResponseEntity<String> addAddress(@RequestBody AddressBookDTO addressBookDTO) {
        addressBookList.add(addressBookDTO);
        return ResponseEntity.ok("Added successfully: " + addressBookDTO.getName() + ", " + addressBookDTO.getAddress());
    }
}
