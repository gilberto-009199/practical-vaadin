package com.example.demo.ui.views;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.example.demo.ui.component.PictureButton;
import com.example.demo.ui.component.PictureButtonWithMixins;
import com.example.demo.ui.layout.MainLayout;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
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
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.BeforeLeaveObserver;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.router.RouterLink;

@Route(value = "", layout = MainLayout.class)
@JavaScript("script.js")
@CssImport("style.css")
public class HomeView extends VerticalLayout{

    public HomeView() {
		
    	add( new H1("home") );
    	

		// execute js
		add(
			new Button("Java to Javascript",
				event ->{
					UI
					.getCurrent()
					.getPage()
					.executeJs("app.show('hi!!!')");
				}
			)
		);
		
		
		// execute js and get result
		add(
				new Button("Java to Javascript returns",
					event ->{
						UI
						.getCurrent()
						.getPage()
						.executeJs("return { name:'myname', age: 87 }")
						.then(result ->{
							System.out.println( result.toJson() );
							Notification.show( result.toJson() );
						});
					}
				)
		);
    	
    	var div = getElement();
    	// API ELEMENTS
		div.setAttribute("id", "our-div");
		var picture			= new PictureButton("https://t.ctcdn.com.br/Pp8AcSBhklh28T5N1v1HYG5esJ4=/768x432/smart/i257652.jpeg"); 
		var pictureMoxin	= new PictureButtonWithMixins("https://ehgomes.com.br/wp-content/uploads/2023/08/Vectorizer.AI-A-Ferramenta-que-Transforma-Imagens-em-Vetores.webp");

		// custom element
		add( 
			picture,
			pictureMoxin 
		);
		
		picture.getElement().getStyle().setHeight("30vh");
		picture.getElement().getStyle().setWidth("30vw");
		
		// Mixins
		pictureMoxin.setHeight(30, Unit.VH);
		pictureMoxin.setWidth(30, Unit.VW);
		
		
		
    }
    
    @ClientCallable
    public void javaProcess(int x, int y) {
    	System.out.println( "x:"+x+", y:"+y );
    	Notification.show( "x:"+x+", y:"+y );
    }

}