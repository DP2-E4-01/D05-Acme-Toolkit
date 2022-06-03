package acme.features.inventor.chimpum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chimpum.Chimpum;
import acme.features.administrator.configurations.AdministratorConfigurationRepository;
import acme.forms.MoneyExchange;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorChimpumListService implements AbstractListService<Inventor, Chimpum> {

	@Autowired 
	protected InventorChimpumRepository chimpumRepository;
	
	@Autowired
	protected AdministratorConfigurationRepository configRepository;
	
	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;
		
		final int id = request.getPrincipal().getActiveRoleId();
		final List<Chimpum> chimpums = this.chimpumRepository.findChimpumsByInventorId(id);
		return chimpums.get(0).getInventor().getId()==id;
	}

	@Override
	public List<Chimpum> findMany(final Request<Chimpum> request) {
		assert request != null;
		List<Chimpum> res;
		final int id = request.getPrincipal().getActiveRoleId();
		res = this.chimpumRepository.findChimpumsByInventorId(id);
		return res;
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final String defaultCurrency = this.configRepository.getDefaultCurrency();
		final MoneyExchange me = new MoneyExchange(entity.getBudget(), defaultCurrency);
		model.setAttribute("moneyExchange", me.getExchange());
		
		request.unbind(entity, model, "code","title", "startsAt", "finishesAt", "budget");
		
	}

}
