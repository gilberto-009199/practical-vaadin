package com.example.demo.ui.views;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.example.demo.ui.model.Product;
import com.example.demo.ui.model.Purveyor;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataKeyMapper;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.data.renderer.Rendering;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {

	public final List<Purveyor> setPurveyor;
	private final List<Product> listProduct;

	private Grid<Product> tblProduct;

	{
		setPurveyor = Arrays.asList( 
				new Purveyor(
						"Amazon", 
						false
				),
				new Purveyor(
						"TARGET",
						true
				),
				new Purveyor(
						"VIA_VAREJO",
						true
				)
		);
		
		listProduct = new ArrayList<Product>();

		for(var i : new int[95]) {
			
			listProduct.add(new Product(1L, "Milk", "A1", setPurveyor.get(0), LocalDate.of(2025, 6, 5), true));
			listProduct.add(new Product(2L, "Eye", "A2", setPurveyor.get(1), LocalDate.of(2025, 6, 5), false));
			listProduct.add(new Product(3L, "Bread", "A3", setPurveyor.get(2), LocalDate.of(2025, 7, 10), true));
			listProduct.add(new Product(4L, "Cheese", "A4", setPurveyor.get(0), LocalDate.of(2025, 8, 20), true));
			listProduct.add(new Product(5L, "Butter", "A5", setPurveyor.get(1), LocalDate.of(2025, 9, 1), false));
			listProduct.add(new Product(6L, "Juice", "B1", setPurveyor.get(2), LocalDate.of(2025, 6, 30), true));
			listProduct.add(new Product(7L, "Water", "B2", setPurveyor.get(0), LocalDate.of(2026, 1, 15), true));
			listProduct.add(new Product(8L, "Yogurt", "B3", setPurveyor.get(1), LocalDate.of(2025, 7, 5), false));
			listProduct.add(new Product(9L, "Eggs", "B4", setPurveyor.get(2), LocalDate.of(2025, 6, 25), true));
			listProduct.add(new Product(10L, "Apple", "B5", setPurveyor.get(0), LocalDate.of(2025, 6, 18), true));
			listProduct.add(new Product(11L, "Banana", "C1", setPurveyor.get(1), LocalDate.of(2025, 6, 16), false));
			listProduct.add(new Product(12L, "Tomato", "C2", setPurveyor.get(2), LocalDate.of(2025, 6, 22), true));
			listProduct.add(new Product(13L, "Lettuce", "C3", setPurveyor.get(0), LocalDate.of(2025, 6, 19), true));
			listProduct.add(new Product(14L, "Carrot", "C4", setPurveyor.get(1), LocalDate.of(2025, 7, 2), false));
			listProduct.add(new Product(15L, "Onion", "C5", setPurveyor.get(2), LocalDate.of(2025, 6, 28), true));
			listProduct.add(new Product(16L, "Rice", "D1", setPurveyor.get(0), LocalDate.of(2026, 2, 10), true));
			listProduct.add(new Product(17L, "Beans", "D2", setPurveyor.get(1), LocalDate.of(2026, 3, 5), false));
			listProduct.add(new Product(18L, "Pasta", "D3", setPurveyor.get(2), LocalDate.of(2025, 12, 20), true));
			listProduct.add(new Product(19L, "Oil", "D4", setPurveyor.get(0), LocalDate.of(2026, 1, 1), true));
			listProduct.add(new Product(20L, "Salt", "D5", setPurveyor.get(1), LocalDate.of(2027, 1, 1), true));
			listProduct.add(new Product(21L, "Sugar", "E1", setPurveyor.get(2), LocalDate.of(2026, 5, 15), false));
			listProduct.add(new Product(22L, "Coffee", "E2", setPurveyor.get(0), LocalDate.of(2026, 4, 4), true));
			listProduct.add(new Product(23L, "Tea", "E3", setPurveyor.get(1), LocalDate.of(2026, 6, 18), true));
			listProduct.add(new Product(24L, "Chocolate", "E4", setPurveyor.get(2), LocalDate.of(2026, 3, 30), false));
			listProduct.add(new Product(25L, "Cereal", "E5", setPurveyor.get(0), LocalDate.of(2025, 11, 10), true));
			listProduct.add(new Product(26L, "Ketchup", "F1", setPurveyor.get(1), LocalDate.of(2026, 8, 15), true));
			listProduct.add(new Product(27L, "Mayonnaise", "F2", setPurveyor.get(2), LocalDate.of(2025, 10, 5), false));
			listProduct.add(new Product(28L, "Vinegar", "F3", setPurveyor.get(0), LocalDate.of(2027, 2, 2), true));
			listProduct.add(new Product(29L, "Mustard", "F4", setPurveyor.get(1), LocalDate.of(2026, 9, 30), true));
			listProduct.add(new Product(30L, "Jam", "F5", setPurveyor.get(2), LocalDate.of(2026, 12, 1), false));

		}
		
	}
	
	
    public HomeView() {

    	add( tblProduct() );

    }

	private Grid tblProduct() {
		
    	if(tblProduct == null ) tblProduct = new Grid<>(Product.class);
    	
    	//tblProduct.removeAll(); 
    	/*
    	tblProduct
		.addColumn(Product::getId)
		.setHeader("ID");
    	
    	tblProduct
		.addColumn(Product::getCode)
		.setHeader("Codigo");

    	tblProduct
		.addColumn(Product::getName)
		.setHeader("Name")
		.setAutoWidth(true);
		
    	tblProduct
		.addColumn(book -> book.getPurveyor().name())
		.setHeader("Fornecedor"); 
		*/
    	
    	 tblProduct
    	.getColumnByKey("name")
    	.setHeader("Nome");
    	
    	tblProduct
    	.getColumnByKey("code")
    	.setHeader("Codigo");

    	tblProduct
    	.getColumnByKey("validate")
    	.setHeader("Data de Validade");

    	tblProduct.removeColumnByKey("purveyor");
    	tblProduct.addColumn("purveyor.name")
    	.setHeader("Fonecedor");
    	
    	tblProduct.setColumns("avaliable", "name", "code", "purveyor.name");
    	tblProduct.getColumnByKey("purveyor.name").setHeader("Fonecedor");
    	
    	
    	/*
    	 
    	  Usando DataProvider

    	  
		  tblProduct.setDataProvider(dataProvider);
    	  
    	 */
    	var dataProvider = new ListDataProvider<>(listProduct);
    	tblProduct.setItems(listProduct);
    	tblProduct.setDataProvider(dataProvider);
    	
    	tblProduct.addSelectionListener(event ->{
    		event.getFirstSelectedItem().ifPresent(p ->{
    			
    			Notification.show("Selecionado: "+p.getName());
    			
    			listProduct.forEach(p0 -> {
    				if(p0.getId() == p.getId()) {
    					p0.setName("!!!!!!!");
    				}
    			});
    			p.setName("@@@@");
    			tblProduct.getDataProvider().refreshItem(p);

    			
    			
    		});
    	});
    	
    	tblProduct
    	.getColumnByKey("avaliable")
    	.setHeader("Disponivel")
    	.setFooter("Footer?")
    	
    	.setComparator((p0,p1) -> (p0.isAvaliable() && !p1.isAvaliable() ? 1: 0) );
    	
    	tblProduct
    	.addComponentColumn((p) -> {
    		var check = new Checkbox(p.isAvaliable());
    		
    		check.addClickListener(event ->{
    			
    			var value = event.getSource().getValue();
    			
    			listProduct.stream()
                .filter(p0 -> Objects.equals(p0.getId(), p.getId()))
                .findFirst()
                .ifPresent(p0 -> p0.setAvaliable( value ) );

    			tblProduct.getDataProvider().refreshItem(p);

    		});
    		
    		return check;
    	})
    	.setHeader("ReAvaliar?");
    	
    	/*tblProduct.setItems(query ->{
    		return listProduct
    				.stream()
    				.skip(query.getOffset())
    				.limit(query.getLimit());
    	});*/
    	
    	int pageSize = 10;
/*
    	tblProduct.setItems(
    	    query -> {
    		        
    	    	Stream<Product> stream = listProduct.stream();
    	    	 
		        // Ordenação baseada nos sort orders
		        for (QuerySortOrder sortOrder : query.getSortOrders()) {
		            Comparator<Product> comparator = null;

		            switch (sortOrder.getSorted()) {
		                case "name":
		                    comparator = Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER);
		                    break;
		                case "id":
		                    comparator = Comparator.comparing(Product::getId);
		                    break;
		                case "code":
		                    comparator = Comparator.comparing(Product::getCode, String.CASE_INSENSITIVE_ORDER);
		                    break;
		                case "validate":
		                	comparator = Comparator.comparing(Product::getValidate);
		                    break;
		                case "avaliable":
		                	comparator = Comparator.comparing(Product::isAvaliable);
		                    break;
		            }

		            if (comparator != null) {
		                if (sortOrder.getDirection() == SortDirection.DESCENDING) {
		                    comparator = comparator.reversed();
		                }

		                stream = stream.sorted(comparator);
		            }
		        }
		        
		        
		        // Aplicar paginação
		        return stream
		                .skip(query.getOffset())
		                .limit(query.getLimit());
    	    });
*/
    	// Para garantir limite de página no frontend (opcional, geralmente automático)
    	tblProduct.setPageSize(pageSize);


    	    	
    	
		return tblProduct;
	}

}