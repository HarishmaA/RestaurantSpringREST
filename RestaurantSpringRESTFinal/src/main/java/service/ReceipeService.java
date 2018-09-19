package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import model.Receipe;
import repository.ReceipeRepositoryDatastore;


@Service
public class ReceipeService {
	private ReceipeRepositoryDatastore repo;

	@Autowired
	public ReceipeService(@Qualifier("receipe-repo-objectify")ReceipeRepositoryDatastore repo) {
		this.repo = repo;
	}

	public Receipe create(Long receipeId, String receipeName) {
		Receipe result = this.repo.create(receipeId, receipeName);
		return result;
	}

	public Receipe read(Long receipeId) {
		Receipe result = this.repo.read(receipeId);	
		return result;
	}

	public void update(Long receipeId, String receipeName) {
		repo.update(receipeId, receipeName);
	}

	public String delete(Long receipeId) {
		return repo.delete(receipeId);
	}
}
