package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.appengine.api.datastore.Entity;

import model.Receipe;
import repository.RepositoryCRUD;

@Service
public class ServiceCRUD {
	private RepositoryCRUD repo;

	@Autowired
	public ServiceCRUD(RepositoryCRUD repo) {
		this.repo = repo;
	}

	public Receipe create(Long receipeId, String receipeName) {
		Entity result = this.repo.create(receipeId, receipeName);
		Receipe receipeDetails = new Receipe((Long) result.getProperty("receipeId"),
				(String) result.getProperty("receipeName"));
		return receipeDetails;
	}

	public Receipe read(Long receipeId) {
		Entity result = this.repo.read(receipeId);
		Receipe receipeDetails = new Receipe((Long) result.getProperty("receipeId"),
				(String) result.getProperty("receipeName"));
		return receipeDetails;
	}

	public String update(Long receipeId, String receipeName) {
		return repo.update(receipeId, receipeName);
	}

	public String delete(Long receipeId) {
		return repo.delete(receipeId);
	}
}
