package com.cloubiot.buddyWAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloubiot.buddyWAPI.dao.ContactRepository;
import com.cloubiot.buddyWAPI.model.dbentity.Contact;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}
}
