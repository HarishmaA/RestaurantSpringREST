package repository;

import org.springframework.stereotype.Repository;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.Receipe;


@Repository
public class ReceipeRepositoryLowLevelAPI  implements ReceipeRepositoryDatastore{

	public 	Receipe create(Long receipeId, String receipeName) {
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
			e.printStackTrace();
		}
		Receipe receipeDetails = new Receipe((Long) result.getProperty("receipeId"),
				(String) result.getProperty("receipeName"));
		return receipeDetails;
	}

	public Receipe read(Long receipeId) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key receipeKey = KeyFactory.createKey("Receipe", receipeId);
		Entity result = null;
		try {
			result = datastore.get(receipeKey);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		Receipe receipeDetails = new Receipe((Long) result.getProperty("receipeId"),
				(String) result.getProperty("receipeName"));
		return receipeDetails;
	}

	public void update(Long receipeId, String receipeName) {

		Key receipeKey = KeyFactory.createKey("Receipe", receipeId);
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		Entity result = null;

		try {
			result = datastoreService.get(receipeKey);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		result.setProperty("receipeName", receipeName);
		datastoreService.put(result);

	}

	public String delete(Long receipeId) {
		Key receipeKey = KeyFactory.createKey("Receipe", receipeId);
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		Entity result = null;
		try {
			result = datastoreService.get(receipeKey);
			datastoreService.delete(receipeKey);
			return new String("Successfully deleted ReceipeId = "+receipeId);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return new String("Oops!!!Receipe not found!!");
			
		}

	}
}
