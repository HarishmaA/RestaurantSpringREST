
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class ReadController {

	private ServiceCRUD service;

	@Autowired
	public ReadController(ServiceCRUD service) {
		this.service = service;
	}

	@GetMapping(path = "/read", produces = "application/json")
	public Receipe read(@RequestParam(value = "receipeId") Long receipeId) {

		Receipe receipeDetails = this.service.read(receipeId);
		return receipeDetails;
	}
}
