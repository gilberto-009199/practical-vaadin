package com.example.demo.ui.component;

import java.util.Arrays;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasEnabled;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.dom.DomEventListener;

@Tag("img")
public class PictureButtonWithMixins extends Component implements HasSize, HasEnabled{

	public PictureButtonWithMixins(String imageUrl) {
		getElement().setAttribute("src", imageUrl);
		
		var style = getElement().getStyle();
		style.set("border", "1em solid #333");
		style.set("box-sizing", "border-box");
		String shadow = "1em 1em 1em #777";
		style.set("box-shadow", shadow); 
		DomEventListener mousermove = event -> {
			style.set("transform", "scale(0.93)");
			style.remove("box-shadow");
		};
		
		getElement().addEventListener("mousemove", mousermove); 
		getElement().addEventListener("pointermove", mousermove);
		
		getElement().addEventListener("mouseleave", event ->{
			style.remove("transform");
			style.set("box-shadow", shadow);
		});
		
	}

}