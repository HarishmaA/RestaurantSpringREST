package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
public class CreateController {
	private ServiceCRUD service;

	@Autowired
	public CreateController(ServiceCRUD service) {
		this.service = service;
	}

	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public Receipe create(@RequestBody Receipe receipeCreated) {

		Long receipeId = receipeCreated.getReceipeId();
		String receipeName = receipeCreated.getReceipeName();
		Receipe receipeDetails = this.service.create(receipeId, receipeName);
		return receipeDetails;

	}
}
