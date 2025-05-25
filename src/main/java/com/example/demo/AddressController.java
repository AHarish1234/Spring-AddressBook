package com.example.demo;



import com.example.demo.AddressBookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/addressbook")
public class AddressController {

    // In-memory list to simulate data storage
    private List<AddressBookDTO> addressBookList = new ArrayList<>();

    // GET all records
    @GetMapping("/get")
    public ResponseEntity<List<AddressBookDTO>> getAll() {
        return new ResponseEntity<>(addressBookList, HttpStatus.OK);
    }

    // GET by index (as ID)
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        if (id >= 0 && id < addressBookList.size()) {
            return new ResponseEntity<>(addressBookList.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ID not found", HttpStatus.NOT_FOUND);
        }
    }

    // POST - Add new address
    @PostMapping("/post")
    public ResponseEntity<String> create(@RequestBody AddressBookDTO dto) {
        addressBookList.add(dto);
        return new ResponseEntity<>("Address Added Successfully", HttpStatus.CREATED);
    }

    // PUT - Update existing address by index
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        if (id >= 0 && id < addressBookList.size()) {
            addressBookList.set(id, dto);
            return new ResponseEntity<>("Address Updated Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ID not found", HttpStatus.NOT_FOUND);
        }
    }

    // DELETE - Remove address by index
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if (id >= 0 && id < addressBookList.size()) {
            addressBookList.remove(id);
            return new ResponseEntity<>("Address Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ID not found", HttpStatus.NOT_FOUND);
        }
    }
}


