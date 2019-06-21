package com.cloubiot.buddyWAPI.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cloubiot.buddyWAPI.model.dbentity.Contact;

public interface ContactRepository extends MongoRepository<Contact, String>{

}
