package controllers;

import javax.validation.Path.ReturnValueNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import service.ServiceCRUD;

@RestController
public class DeleteController {
	private ServiceCRUD service;

	@Autowired
	public DeleteController(ServiceCRUD service) {
		this.service = service;
	}

	@DeleteMapping(path = "/delete", produces = "text/plain")
	public String delete(@RequestParam(value = "receipeId") Long receipeId) {

		return service.delete(receipeId);

	}
}
