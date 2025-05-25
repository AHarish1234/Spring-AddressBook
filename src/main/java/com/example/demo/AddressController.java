package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping("/get")
    public ResponseEntity<List<AddressBookModel>> getAllAddresses() {
        return ResponseEntity.ok(addressBookService.getAllAddresses());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookModel> getAddressById(@PathVariable int id) {
        return addressBookService.getAddressById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/post")
    public ResponseEntity<AddressBookModel> addAddress(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.addAddress(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookModel> updateAddress(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        return addressBookService.updateAddress(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
        boolean deleted = addressBookService.deleteAddress(id);
        if (deleted) {
            return ResponseEntity.ok("Address with id " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
