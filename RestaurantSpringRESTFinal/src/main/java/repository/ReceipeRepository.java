package repository;

import org.springframework.stereotype.Repository;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Repository
public class ReceipeRepository {

	public Entity create(Long receipeId, String receipeName) {
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
		return result;
	}

	public Entity read(Long receipeId) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key receipeKey = KeyFactory.createKey("Receipe", receipeId);
		Entity result = null;
		try {
			result = datastore.get(receipeKey);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		return result;
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

	public void delete(Long receipeId) {
		Key receipeKey = KeyFactory.createKey("Receipe", receipeId);
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.delete(receipeKey);
	}
}
