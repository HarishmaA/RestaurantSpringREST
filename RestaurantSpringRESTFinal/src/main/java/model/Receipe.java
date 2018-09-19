package model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Receipe{
	@Id
	private Long receipeId;
	@Index
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
	
	public void update(String receipeName)
	{
		if(receipeName!=null)
		{
			this.receipeName=receipeName;
		}
	}
}
