package com.elice.service;

import java.util.List;
import com.elice.entity.Contact;
import com.elice.repository.ContactRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Page<Contact> findContacts(int page, int size) {
        PageRequest pages = PageRequest.of(page -1, size, Sort.by("contactId").descending());
        return contactRepository.findAll(pages);
    }
    
    public List<Contact> findContacts() {
        return contactRepository.findAll();
    }
}
