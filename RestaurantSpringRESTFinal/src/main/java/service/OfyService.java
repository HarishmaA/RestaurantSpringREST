package service;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import model.Receipe;

public class OfyService {
	static {
		factory().register(Receipe.class);
	}
	public static Objectify ofy() {
    return ObjectifyService.ofy();
	}
	public static ObjectifyFactory factory() {
	  return ObjectifyService.factory();
	}
}