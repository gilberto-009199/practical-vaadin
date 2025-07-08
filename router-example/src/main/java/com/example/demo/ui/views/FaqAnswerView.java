package com.example.demo.ui.views;

import java.util.Map;

import com.example.demo.ui.layout.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteParameters;
import com.vaadin.flow.router.RouterLink;

@Route(value = "faq/:answer", layout = MainLayout.class)
public class FaqAnswerView extends VerticalLayout implements BeforeEnterObserver{


	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		var answer = event.getRouteParameters().get("answer").get();
		
		add(new Span("Question: "+ answer + "?"));
		add(new Span("R: ....."));
	}
	 
	public FaqAnswerView() {
		
		
		add(new Span("Faq......."));
		
		
	}


	public static RouteParameters createRouteParameters(String answer) {
        return new RouteParameters(
            Map.of(
                "answer", answer
            )
        );
	 }
}