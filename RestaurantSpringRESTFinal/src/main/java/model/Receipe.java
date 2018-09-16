package model;

public class Receipe {
	private Long receipeId;
	private String receipeName;

	public Receipe() {}
	public Receipe(Long receipeId, String receipeName) {
		this.receipeId = receipeId;
		this.receipeName = receipeName;
	}

	@Override
	public String toString() {
		return "The receipe is... ReceipeId= " + this.receipeId + "	 ReceipeName= " + this.receipeName;
	}

	public Long getReceipeId() {
		return this.receipeId;
	}

	public String getReceipeName() {
		return this.receipeName;
	}
}
