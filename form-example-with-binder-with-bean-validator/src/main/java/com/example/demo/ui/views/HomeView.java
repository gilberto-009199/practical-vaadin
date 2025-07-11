package com.example.demo.ui.views;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.example.demo.ui.forms.FormProduct;
import com.example.demo.ui.model.Product;
import com.example.demo.ui.model.Purveyor;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {

	public final List<Purveyor> setPurveyor;
	private final List<Product> listProduct;
	
	private VerticalLayout buttons;
	private VerticalLayout tblProduct;
	
	{
		setPurveyor = Arrays.asList( 
				new Purveyor(
						"Amazon", 
						false
				),
				new Purveyor(
						"TARGET",
						true
				) 
		);
		
		listProduct = new ArrayList<Product>();

		listProduct.add(
			new Product(
				1l,
				"Milk",
				"A1", 
				setPurveyor.get(0),
				LocalDate.of(2025, 6, 5),
				true
			)
		);

		listProduct.add(
			new Product(
				2l,
				"Eye",
				"A2",
				setPurveyor.get(1),
				LocalDate.of(2025, 6, 5),
				false
			)
		);
		
	}
	
	
    public HomeView() {

    	add( buttons() );
    	add( tblProduct() );

    }

    private Component buttons() {
		
    	if(buttons == null ) buttons = new VerticalLayout();
    	
    	buttons.removeAll();
    	
    	buttons.add(
			new Button(
	    			"Create Product",
	    			VaadinIcon.PLUS.create(),
	    			event -> addProduct()
	    	)
    	);

    	return buttons;
    	
	}

	private VerticalLayout tblProduct() {
		
    	if(tblProduct == null ) tblProduct = new VerticalLayout();
    	
    	tblProduct.removeAll(); 
    	
    	listProduct.forEach(product -> 
    		tblProduct.add(
    				new HorizontalLayout(
    						new Span(
    								product.getId() != null
    							?
    								product.getId().toString()
    							: 
    								"?"
    						),
    						new Span(product.getName()),
    						new Span(product.getCode()),
    						new Span(product.getPurveyor().name()),
    						new Span( 
    								product.getValidate()
    								.format(
    									DateTimeFormatter.ofPattern("dd/MM/yyyy")
    								)
    						),
    						new Button(
    							"Edit",
    							event-> editProduct(product)
    						),
    						new Button(
    							"Remove",
    							event-> deleteProduct( product )
        					)
    				)
    		)
    	);
    	
		return tblProduct;
	}

	private void addProduct() {

    	var frm	= new FormProduct(this);
    	
    	frm.withListener(event -> {
    		
    		var product = frm.values();
    		
    		listProduct.add(product);
    		
    		tblProduct();
    		
    		frm.close();
    	});
    	
    	add(frm);
    	
    }
    
    private void editProduct(Product product) { 

    	var frm	= new FormProduct(this);
    	frm
    	.withProduct(product)
    	.withListener(event -> {
    		
    		var newproduct = frm.values();
    		
    		listProduct.forEach(item-> {
    			
    			if(item.getId().equals(product.getId())) {
    				item.setName(newproduct.getName());
    				item.setCode(newproduct.getCode());
    				item.setAvaliable(newproduct.isAvaliable());
    				item.setPurveyor(newproduct.getPurveyor());
    				item.setValidate(newproduct.getValidate());
    			}
    			
    		});
    		
    		tblProduct();
    		
    		frm.close();
    	});
    	
    	add(frm);
    }
    
    private void deleteProduct(Product product) { 
    	
    	listProduct.remove(product);
    	
    	tblProduct();
    	
    }

    
}
