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
	
	private Publisher publisher = new Publisher();
	
	public List<Publisher> getList(){
		return publishers.all();
	}

	public String save(){
		publishers.save(publisher);
		return "/list?faces-redirect=true";
	}
	
	public String update(){
		publishers.update(publisher);
		return "/list?faces-redirect=true";
	}
	
	public String delete(Publisher publisher){
		publishers.remove(publisher.getId());
		return "/list?faces-redirect=true";
	}
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
}
