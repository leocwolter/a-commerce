package br.com.acommerce.publisher;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.infra.MessageContainer;

@RequestScoped
@Named
public class PublisherBean {

	@Inject
	private PublisherDAO publishers;
	
	@Inject
	private MessageContainer messages;
	
	private Publisher publisher;
	
	@PostConstruct
	public void setup(){
		this.publisher = new Publisher();
	}
	
	public List<Publisher> getList(){
		return publishers.all();
	}

	public void save(){
		publishers.save(publisher);
		setup();
		messages.addInfo("created");
	}
	
	public void update(){
		publishers.update(publisher);
		messages.addInfo("updated");
	}
	
	public void delete(Publisher publisher){
		publishers.remove(publisher.getId());
		messages.addInfo("deleted");
	}
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
}
