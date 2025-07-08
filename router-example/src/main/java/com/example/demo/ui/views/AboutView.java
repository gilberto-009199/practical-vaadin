package com.example.demo.ui.views;

import com.example.demo.ui.layout.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;


@Route(value = "about", layout = MainLayout.class)
public class AboutView extends VerticalLayout implements BeforeEnterObserver{
	
	public AboutView() {

		add(new H1("About"));

		add(new Span("About......."));

	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		var queryParamters = event.getLocation().getQueryParameters();
		
		var country = queryParamters.getSingleParameter("country");
		
		if(country.isEmpty())return;
		
		add(new Paragraph("Your Contry is: "+ country.get()));		
	}

}
