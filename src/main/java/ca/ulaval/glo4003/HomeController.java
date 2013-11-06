package ca.ulaval.glo4003;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
		@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(OrderViewModel order, Model model) {
		model.addAttribute("order", order);
		return "home";
	}
	
	@ModelAttribute(value="order")
	public OrderViewModel buildInitialOrder() {
	    List<ItemViewModel> items = new LinkedList<ItemViewModel>();
	    items.add(createItem(1, "First item", 1));
	    items.add(createItem(2, "Second item", 1));
	    items.add(createItem(3, "Third item", 1));
	    items.add(createItem(4, "Fourth item", 1));
	    
	    OrderViewModel order = new OrderViewModel();
	    order.items = items;
	    return order;
	}

    private ItemViewModel createItem(int id, String name, int quantity) {
        ItemViewModel item = new ItemViewModel();
        item.id = id;
        item.name= name;
        item.quantity = quantity;
        item.deleted = false;
        return item;
    }
	
}
