package controllers;

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

@RestController
public class CreateController {
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public Receipe create(@RequestBody Receipe receipeCreated) {

		Long receipeId = receipeCreated.getReceipeId();
		String receipeName = receipeCreated.getReceipeName();

		Key receipeKey = KeyFactory.createKey("Receipe", receipeId);
		Entity receipe = new Entity("Receipe", receipeId);
		receipe.setProperty("receipeId", receipeId);
		receipe.setProperty("receipeName", receipeName);
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(receipe);
		Entity result = null;
		try {
			result = datastore.get(receipeKey);
		} catch (EntityNotFoundException e) {

		}
		Receipe receipeDetails = new Receipe((Long) result.getProperty("receipeId"),
				(String) result.getProperty("receipeName"));

		return receipeDetails;
	}
}





// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// return new ResponseEntity<Receipe>(receipeDetails, HttpStatus.OK);
// ResponseEntity<Receipe>
// @GetMapping("/")
// public String home() {
// return "home";
// }

// @GetMapping("/")
// public ModelAndView home1()
// {
// ModelAndView modelAndView = new ModelAndView("home");
// return modelAndView;
// }
