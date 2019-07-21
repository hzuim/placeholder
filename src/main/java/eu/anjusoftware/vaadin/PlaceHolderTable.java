package eu.anjusoftware.vaadin;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import eu.anjusoftware.dtos.PlaceHolder;
import eu.anjusoftware.services.PlaceHolderService;

@Route(value="placeholder")
public class PlaceHolderTable extends VerticalLayout {
	
	private static final long serialVersionUID = 1L;
	public final Grid<PlaceHolder> grid;
	public PlaceHolderService placeHolderService;
	
	public PlaceHolderTable(PlaceHolderService placeHolderService) {
		this.placeHolderService = placeHolderService;
		this.grid = new Grid<>(PlaceHolder.class);
		this.grid.setColumns("id", "userId", "title", "completed");		
		add(grid);
		listPlaceHolders();
	}
	
	private void listPlaceHolders() {
		grid.setItems(placeHolderService.findAll());
	}

}
