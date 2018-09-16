package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.Receipe;
import service.ServiceCRUD;

@RestController
public class UpdateController {

	private ServiceCRUD service;

	@Autowired
	public UpdateController(ServiceCRUD service) {
		this.service = service;
	}

	@PutMapping(path = "/update", consumes = "application/json", produces = "text/plain")
	public String update(@RequestBody Receipe receipeCreated) {
		Long receipeId = receipeCreated.getReceipeId();
		String receipeName = receipeCreated.getReceipeName();
		return service.update(receipeId, receipeName);

	}

}
