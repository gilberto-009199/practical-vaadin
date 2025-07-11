package com.example.demo.ui.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;

@Tag("img")
public class PictureButton extends Component {

	public PictureButton(String imageUrl) {
		getElement().setAttribute("src", imageUrl); 
		
		// Style inline
		var style = getElement().getStyle();
		style.set("border", "1em solid #333");
		style.set("box-sizing", "border-box");
		style.set("box-shadow", "1em 1em 1em #777");
		
	}

}
