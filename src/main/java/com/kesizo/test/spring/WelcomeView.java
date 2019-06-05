package com.kesizo.test.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route(value = "welcome")
public class WelcomeView extends VerticalLayout {

    public WelcomeView () {
        if (VaadinSession.getCurrent().getAttribute(UserLogin.class.toString()) == null) {
            Button buttonGoBack = new Button("Login");
            buttonGoBack.addClickListener(e -> {
                getUI().ifPresent(ui -> ui.navigate(""));
            });
            this.add(buttonGoBack);
        }
        else {

            String myUser = VaadinSession.getCurrent().getAttribute(UserLogin.class.toString()).toString();
            Label label = new Label("Hola " + myUser);

            Button buttonLogout = new Button("Logout");
            buttonLogout.addClickListener(e -> {
                VaadinSession.getCurrent().setAttribute(UserLogin.class.toString(), null);
                getUI().ifPresent(ui -> ui.navigate(""));
            });

            this.add(label);
            this.add(buttonLogout);
        }
    }
}
