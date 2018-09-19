package repository;


import model.Receipe;

public interface ReceipeRepositoryDatastore {
	public Receipe create(Long receipeId, String receipeName);

	public Receipe read(Long receipeId);

	public void update(Long receipeId, String receipeName);

	public String delete(Long receipeId);
}
