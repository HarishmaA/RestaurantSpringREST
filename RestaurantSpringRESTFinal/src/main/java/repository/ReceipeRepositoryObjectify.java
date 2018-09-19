package repository;

//import static com.googlecode.objectify.ObjectifyService.ofy;

import static repository.OfyService.ofy;

import org.springframework.stereotype.Repository;

import com.googlecode.objectify.Key;

import model.Receipe;


@Repository
public class ReceipeRepositoryObjectify implements ReceipeRepositoryDatastore{
	public Receipe create(Long receipeId, String receipeName) {
		Key key = Key.create(Receipe.class, receipeId);
		Receipe receipe = new Receipe(receipeId, receipeName);
		ofy().save().entity(receipe).now();
		Receipe result = (Receipe)ofy().load().key(key).now();
		System.out.println(result);
		return result;
	}

	public Receipe read(Long receipeId) {
		Key key = Key.create(Receipe.class, receipeId);
		Receipe result = (Receipe)ofy().load().key(key).now();
		return result;		
	}

	public void update(Long receipeId, String receipeName) {

		Key key = Key.create(Receipe.class, receipeId);
		Receipe result = ofy().load().type(Receipe.class).id(receipeId).now();
		result.update(receipeName);
		ofy().save().entity(result).now();

	}

	public String delete(Long receipeId) {
		Key key = Key.create(Receipe.class, receipeId);
		Receipe result = null;
		result = (Receipe) ofy().load().key(key).now();
		if(result==null)
		{   
			return new String("Oops!!!Receipe not found!!");
			
		}
		ofy().delete().type(Receipe.class).id(receipeId).now(); 
		//ofy().delete().entity(result);
		return new String("Successfully deleted ReceipeId = "+receipeId);
		
	} 

}


