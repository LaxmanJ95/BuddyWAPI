package com.cloubiot.buddyWAPI.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloubiot.buddyWAPI.base.SuccessResponse;
import com.cloubiot.buddyWAPI.common.CloubiotLogging;
import com.cloubiot.buddyWAPI.model.request.ContactRequest;
import com.cloubiot.buddyWAPI.service.ContactService;
import com.cloubiot.buddyWAPI.util.JSONUtil;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	ContactService contactService;

	@RequestMapping(method = RequestMethod.GET, value="/get")
	public String getString() {
		return "Hello World";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/saveContact")
	public SuccessResponse saveContact(@RequestBody ContactRequest request) {
		SuccessResponse response = new SuccessResponse();
		try {
			System.out.println("Contact "+JSONUtil.toJson(request.getContact()));
			contactService.saveContact(request.getContact());
			response.setSuccess(true);
		}
		catch(Exception e) {
			CloubiotLogging.logError(getClass(), "Save Contact failed", e);
		}
		return response;
	}
}
