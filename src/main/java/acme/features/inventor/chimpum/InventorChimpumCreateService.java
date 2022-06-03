package acme.features.inventor.chimpum;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chimpum.Chimpum;
import acme.entities.item.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorChimpumCreateService implements AbstractCreateService<Inventor, Chimpum> {

	@Autowired
	protected InventorChimpumRepository chimpumRepository;
	
	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;

		
		boolean result;
		int itemId;
		final Item item;

		itemId = request.getModel().getInteger("id");
		item = this.chimpumRepository.findItemById(itemId);
		result = request.getPrincipal().getActiveRoleId() == item.getInventor().getId();

		return result;
	}

	@Override
	public void bind(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "code", "creationMoment", "title", "description", "startsAt", "finishesAt", "budget", "link");
		

	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "creationMoment", "title", "description", "startsAt", "finishesAt", "budget", "link");
		model.setAttribute("id", request.getModel().getAttribute("id"));

	}

	@Override
	public Chimpum instantiate(final Request<Chimpum> request) {
		assert request != null;
		
		final Chimpum result = new Chimpum();
		final Item item = this.chimpumRepository.findItemById(request.getModel().getInteger("id"));
		final Inventor inventor = this.chimpumRepository.findInventorByUserAccountId(request.getPrincipal().getAccountId());
		
		final Money money = new Money();
		money.setCurrency("EUR");
		money.setAmount(0.00);
		
		final Date creationDate = new Date();
		final Date startDate = new Date();
		final Date finishDate = new Date();
		
		result.setCode("");
		result.setCreationMoment(creationDate);
		result.setTitle("");
		result.setDescription("");
		result.setStartsAt(startDate);
		result.setFinishesAt(finishDate);
		result.setBudget(money);
		result.setLink("");
		result.setItem(item);
		result.setInventor(inventor);
		
		return result;
	}

	@Override
	public void validate(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void create(final Request<Chimpum> request, final Chimpum entity) {
		assert request != null;
		assert entity != null;
		
		entity.setInventor(this.chimpumRepository.findInventorByUserAccountId(request.getPrincipal().getAccountId()));
		entity.setItem(this.chimpumRepository.findItemById(request.getModel().getInteger("id")));
		
		this.chimpumRepository.save(entity);
	}

	
}
