package com.vernesoftware;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vernesoftware.ResponsiveLayout.RLCol;
import com.vernesoftware.ResponsiveLayout.RLContainer;
import com.vernesoftware.ResponsiveLayout.RLRow;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {


//        new  VerticalLayout().setSpacing();

        RLContainer container = new RLContainer();

        RLRow navRow = new RLRow();

        RLCol logoCol = new RLCol(12, 3, 2);
        logoCol.setComponent(getButtonofSize("LOGO", "100%", "100%"));
        navRow.addColumn(logoCol);

        RLCol homeCol = new RLCol(12, 3);
        homeCol.setOffset(RLCol.DisplaySize.MD, 1);
        homeCol.setComponent(getButtonofSize("Home", "100%", "100%"));
        navRow.addColumn(homeCol);

        RLCol aboutCol = new RLCol(12, 3);
        aboutCol.setComponent(getButtonofSize("About Us", "100%", "100%"));
        navRow.addColumn(aboutCol);

        RLCol contactCol = new RLCol(12, 3);
        contactCol.setComponent(getButtonofSize("Contact", "100%", "100%"));
        navRow.addColumn(contactCol);

        navRow.setHorizontalSpacing(0);
        container.addRow(navRow);



        RLRow titleRow = new RLRow();

        RLCol titleCol = new RLCol(12);
        titleCol.setComponent(getButtonofSize("Our Team", "100%", "100%"));
        titleRow.addColumn(titleCol);


        container.addRow(titleRow);




        RLRow teamRow = new RLRow();

        for (int x = 0; x < 10; x++) {
            TeamMemberView teamMemberView = new TeamMemberView();
            teamRow.addColumn(teamMemberView.getInColumn(12, 6, 4, 3));
        }

        container.addRow(teamRow);
        //teamRow.setMargin(50);

        teamRow.setHorizontalSpacing(15);
        teamRow.setVerticalSpacing(15);

        setContent(container);
    }


    public Button getButtonofSize(String title, String h, String w) {
        Button button = new Button(title);
        button.setHeight(h);
        button.setWidth(w);

        return button;

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
