
package controllers;

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

@RestController
public class ReadController {
	@GetMapping(path = "/read", produces = "application/json")
	public Receipe read(@RequestParam(value = "receipeId") Long receipeId) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key receipeKey = KeyFactory.createKey("Receipe", receipeId);
		Entity result = null;
		try {
			result = datastore.get(receipeKey);
		} catch (EntityNotFoundException e) {
			// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Receipe receipeDetails = new Receipe((Long) result.getProperty("receipeId"),
				(String) result.getProperty("receipeName"));
		// return new ResponseEntity<Receipe>(receipeDetails, HttpStatus.OK);
		return receipeDetails;
	}
}

// ResponseEntity<Receipe>