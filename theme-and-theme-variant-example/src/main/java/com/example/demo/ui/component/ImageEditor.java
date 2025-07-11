package com.example.demo.ui.component;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.dependency.JsModule;

import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.dom.Element;


@Tag("image-editor")
@JsModule("./src/image-editor.ts")
public class ImageEditor extends LitTemplate {
	
	@Id("btnZoomIn")
	private Button zoomIn;
	
	@Id("btnZoomOut")
	private Button zoomOut;
	
	@Id("btnRotate")
	private Button rotate;
	
	@Id("btnReset")
	private Button reset;
	
	public ImageEditor() {
		
		zoomIn.addClickListener(event -> {
			getElement().executeJs("this.zoomIn()");
		});
		zoomOut.addClickListener(event -> {
			getElement().executeJs("this.zoomOut()");
		});
		rotate.addClickListener(event -> {
			getElement().executeJs("this.rotate()");
		});
		reset.addClickListener(event -> {
			getElement().executeJs("this.reset()");
		});
		
    }
	
	@ClientCallable
	public void showResetInfo() {
		System.out.println("ssss");
		Notification.show("Editor Resetado");
	}
	
}
