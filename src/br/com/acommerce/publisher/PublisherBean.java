package br.com.acommerce.publisher;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class PublisherBean {

	@Inject
	private PublisherDAO publishers;
	
	public List<Publisher> getList(){
		return publishers.all();
	}
}
