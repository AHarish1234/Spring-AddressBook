package com.example.demo;



import com.example.demo.AddressBookDTO;
import java.util.List;
import com.example.demo.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.AddressBookModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping("/get")
    public ResponseEntity<List<AddressBookModel>> getAddressBook() {
        List<AddressBookModel> list = addressBookService.getAllAddresses();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/post")
    public ResponseEntity<AddressBookModel> addAddress(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookModel added = addressBookService.addAddress(addressBookDTO);
        return ResponseEntity.ok(added);
    }
}

