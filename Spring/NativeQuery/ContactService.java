package com.elice.service;

import com.elice.entity.Contact;
import com.elice.repository.ContactRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    
    private final ContactRepository contactRepository;
    
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    
    public List<Contact> getContactByNameStartingWith(String name) {
        return contactRepository.findByNameStartingWith(name);
    }
    
    public List<Contact> getContactByEmailEndingWith(String email) {
        return contactRepository.findByEmailEndingWith(email);
    }

}
