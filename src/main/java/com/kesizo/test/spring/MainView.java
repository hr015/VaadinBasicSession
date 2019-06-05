package com.kesizo.test.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {

        TextField textField = new TextField();
        textField.setLabel("User Name");
        textField.setPlaceholder("type user name");

        Button button = new Button("Login");
        button.addClickListener(e -> {
            UserLogin userLogin = new UserLogin(textField.getValue());
            VaadinSession.getCurrent().setAttribute(UserLogin.class.toString(), userLogin.userLoginName);
            getUI().ifPresent(ui -> ui.navigate("welcome"));
        });


        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password");
        passwordField.setPlaceholder("type password");

        this.add(textField);
        this.add(passwordField);
        this.add(button);

    }

}
