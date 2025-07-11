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

import com.example.demo.ui.component.ImageEditor;
import com.example.demo.ui.component.ImageEditorWithSlots;
import com.example.demo.ui.layout.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
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
public class HomeView extends VerticalLayout{

    public HomeView() {
		
    	add( new H1("home") );

    	add( new ImageEditor() );
    	
    	add( new ImageEditorWithSlots() );
		
    }

}