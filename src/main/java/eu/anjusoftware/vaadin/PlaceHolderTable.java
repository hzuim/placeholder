package eu.anjusoftware.vaadin;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.gridpro.GridPro;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import eu.anjusoftware.dtos.PlaceHolder;
import eu.anjusoftware.services.PlaceHolderService;

@Route(value="placeholder")
@StyleSheet("placeholder.css")
public class PlaceHolderTable extends VerticalLayout {
	
	private static final long serialVersionUID = 1L;
	public final GridPro<PlaceHolder> grid;
	public PlaceHolderService placeHolderService;
	
	public PlaceHolderTable(PlaceHolderService placeHolderService) {
		this.placeHolderService = placeHolderService;
		this.grid = new GridPro<>();
		this.grid.addThemeNames("row-stripes");
		this.grid.setId("grid");
		this.grid.addColumn(PlaceHolder::getId).setHeader("ID");
		this.grid.addColumn(PlaceHolder::getUserId).setHeader("User ID");
		this.grid.addEditColumn(PlaceHolder::getTitle).text((item, newValue) -> {}).setHeader("Title (editable)");
		this.grid.addColumn(PlaceHolder::getCompleted).setHeader("Completed");
		add(grid);
		this.grid.setItems(placeHolderService.findAll());
	}

}
