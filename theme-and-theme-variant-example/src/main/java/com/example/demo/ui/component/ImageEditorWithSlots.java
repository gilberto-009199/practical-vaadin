package com.example.demo.ui.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.dom.Element;

@Tag("image-editor-slots")
@JsModule("./src/image-editor-slots.ts")
public class ImageEditorWithSlots extends Component {
	
	public ImageEditorWithSlots() {
        Element controls = new Element("div");
        controls.setAttribute("slot", "controls");

        Button zoomIn = new Button("Zoom +", e ->
            getElement().executeJs("this.zoomIn()"));

        Button zoomOut = new Button("Zoom -", e ->
            getElement().executeJs("this.zoomOut()"));

        Button rotate = new Button("Rotate", e ->
            getElement().executeJs("this.rotate()"));

        Button reset = new Button("Reset", e ->
            getElement().executeJs("this.reset()"));

        controls.appendChild( 
    		zoomIn.getElement(),
    		zoomOut.getElement(), 
    		rotate.getElement(), 
    		reset.getElement()
        );
        
        getElement().appendChild(controls);
    }
	
}
