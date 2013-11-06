package ca.ulaval.glo4003;

import java.util.List;

public class OrderViewModel {

    public List<ItemViewModel> items;

    public List<ItemViewModel> getItems() {
        return items;
    }

    public void setItems(List<ItemViewModel> items) {
        this.items = items;
    }
    
    
}
