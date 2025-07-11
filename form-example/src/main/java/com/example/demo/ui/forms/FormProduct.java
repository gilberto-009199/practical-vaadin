package com.example.demo.ui.forms;

import java.time.LocalDate;
import java.util.Locale;

import com.example.demo.ui.model.Product;
import com.example.demo.ui.model.Purveyor;
import com.example.demo.ui.views.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;


public class FormProduct extends Composite<Component> {
	
	private static final long serialVersionUID = 3842604619019822012L;

	// Componets and Hooks
	private HomeView homeView;
	private Dialog dialog;
	private ComponentEventListener close;
	private ComponentEventListener listener;
	
	// Data
	private Product 			values		= new Product();
	private TextField 			name		= new TextField("Name:");
	private TextField 			code		= new TextField("Code:");
	private Checkbox 			avaliable	= new Checkbox("Disponivel:");
	private DatePicker 			validate 	= new DatePicker("Validate Date:");
	private ComboBox<Purveyor> 	purveyor 	= new ComboBox<Purveyor>("Fornecedor:");

	
	public FormProduct(HomeView homeView) {
		this.homeView = homeView;
		purveyor.setItems(homeView.setPurveyor);
		purveyor.setItemLabelGenerator(purveyor -> purveyor.name());
		
		validate.setLocale(Locale.ITALIAN);
		
	}

	@Override
	protected Component initContent() {

    	dialog = new Dialog();
    	dialog.setModal(true);
    	dialog.setCloseOnOutsideClick(false);
    	dialog.setCloseOnEsc(true);
    	
    	// header
    	dialog.getHeader().add(
    		new H3("Product")
    	);
    	
    	// Body
    	dialog.add(
    		new VerticalLayout(
    				name,
    				code,
    				validate,
    				purveyor,
    				avaliable
    		)
    	);
    	
    	// Footer
    	dialog.getFooter().add(
			new Button(
					"Salvar", 
					event -> listener.onComponentEvent(event)
			),
			new Button(
					"Fechar",
					VaadinIcon.CLOSE.create(),
					event -> {
						
						if(close != null) close.onComponentEvent(event);
						
						dialog.close();
					}
			)
    	);
    	
    	dialog.open();
    	
		return dialog;
	}
	
	public void close() { dialog.close(); }
	
	public Product values() {
		
		LocalDate dataSelecionada = validate.getValue();
		
		this.values = new Product(
				values.getId(),
				name.getValue(),
				code.getValue(),
				avaliable.getValue(),
				purveyor.getValue(),
				validate.getValue()
		);
		return this.values;
	}
	
	public FormProduct withProduct(Product product) {
		this.values = product;
		
		name.setValue(values.getName());
		code.setValue(values.getCode());
		avaliable.setValue(values.isAvaliable());
		purveyor.setValue(values.getPurveyor());
		validate.setValue(values.getValidate());
		
		return this;
	}
	
	public FormProduct withClose(ComponentEventListener close) {
		this.close = close;
		return this;
	}
	
	public FormProduct withListener(ComponentEventListener listener) {
		this.listener = listener;
		return this;
	}
	
	
}
