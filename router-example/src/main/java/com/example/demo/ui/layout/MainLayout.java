package com.example.demo.ui.layout;

import com.example.demo.ui.views.AboutView;
import com.example.demo.ui.views.FaqView;
import com.example.demo.ui.views.HomeView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends VerticalLayout implements RouterLayout{

	public MainLayout() {
		
		add( new RouterLink("Page Home", HomeView.class) );		
		add( new RouterLink("Page About", AboutView.class) );		
		add( new RouterLink("Page Faq", FaqView.class) );
		
	}
}
