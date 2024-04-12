package com.elice.controller;

import com.elice.entity.Contact;
import com.elice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    
    private final ContactService contactService;
    
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    
    
    // 지시사항에 따라 코드를 작성해 보세요. 
    @GetMapping("name-search")
    public List<Contact> getContactByNameStartingWith(@RequestParam String name){
        return contactService.getContactByNameStartingWith(name);
    }

    @GetMapping("email-search")
    public List<Contact> getContactByEmailEndingWith(@RequestParam String email) {
        return contactService.getContactByEmailEndingWith(email);
    }
       

    
    
}
