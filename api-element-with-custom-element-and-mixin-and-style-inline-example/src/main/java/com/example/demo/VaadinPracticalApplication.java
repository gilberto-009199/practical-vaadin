package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;

@SpringBootApplication
@Theme("my-theme")
@Push
public class VaadinPracticalApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(VaadinPracticalApplication.class, args);
    }
}
