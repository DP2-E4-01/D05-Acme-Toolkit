package acme.features.inventor.chimpum;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.chimpum.Chimpum;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorChimpumController extends AbstractController<Inventor, Chimpum> {

	@Autowired
	protected InventorChimpumListService listByChimpumService;
	
	@Autowired
	protected InventorChimpumShowService showChimpumService;
	
	@Autowired
	protected InventorChimpumCreateService createChimpumService;
	
	@Autowired 
	protected InventorChimpumUpdateService updateChimpumService;
	
	@Autowired
	protected InventorChimpumDeleteService deleteChimpumService;
	
	@PostConstruct
	protected void initialize() {
		super.addCommand("list-mine", "list", this.listByChimpumService);
		super.addCommand("show", this.showChimpumService);
		super.addCommand("create", this.createChimpumService);
		super.addCommand("update", this.updateChimpumService);
		super.addCommand("delete", this.deleteChimpumService);
	}
}
