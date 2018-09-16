package controllers;

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

@RestController
public class UpdateController {
	@PutMapping(path = "/update",consumes="application/json" , produces = "text/plain")
	public String update(@RequestBody Receipe receipeCreated) {
		Long receipeId = receipeCreated.getReceipeId();
		String receipeName = receipeCreated.getReceipeName();
		Key receipeKey = KeyFactory.createKey("Receipe", receipeId);
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity result = null;
		try {
			result = datastore.get(receipeKey);
		} catch (EntityNotFoundException e) {
			return new String("Oops! Receipe not found!!");
		}
		result.setProperty("receipeName", receipeName);
		datastore.put(result);
		return new String("Successfully Updated!!!");
	}
}

