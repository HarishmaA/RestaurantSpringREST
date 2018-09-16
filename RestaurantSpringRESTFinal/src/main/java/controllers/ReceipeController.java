package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Receipe;
import service.ReceipeService;

@RestController
public class ReceipeController {

	private ReceipeService service;

	@Autowired
	public ReceipeController(ReceipeService service) {
		this.service = service;
	}

	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public Receipe create(@RequestBody Receipe receipeCreated) {

		Long receipeId = receipeCreated.getReceipeId();
		String receipeName = receipeCreated.getReceipeName();
		Receipe receipeDetails = this.service.create(receipeId, receipeName);
		return receipeDetails;

	}

	@GetMapping(path = "/read", produces = "application/json")
	public Receipe read(@RequestParam(value = "receipeId") Long receipeId) {

		Receipe receipeDetails = this.service.read(receipeId);
		return receipeDetails;
	}

	@PutMapping(path = "/update", consumes = "application/json")
	public void update(@RequestBody Receipe receipeCreated) {
		Long receipeId = receipeCreated.getReceipeId();
		String receipeName = receipeCreated.getReceipeName();
		service.update(receipeId, receipeName);

	}

	@DeleteMapping(path = "/delete")
	public void delete(@RequestParam(value = "receipeId") Long receipeId) {

		service.delete(receipeId);

	}
}
