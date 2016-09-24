package com.vernesoftware;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vernesoftware.ResponsiveLayout.RLCol;
import com.vernesoftware.ResponsiveLayout.RLContainer;
import com.vernesoftware.ResponsiveLayout.RLRow;

import java.util.Random;

/**
 * Created by JarekToro on 9/23/16.
 */
public class TeamMemberView extends RLRow {

    public TeamMemberView() {

        RLCol imageCol = new RLCol(4, 4, 4, 4);
        imageCol.setComponent(getButtonofSize("image", "100px", "100%"));
        RLCol titleCol = new RLCol(8, 4, 4, 4);
        titleCol.setComponent(new Label("Jarek Toro"));
        RLCol buttonCol = new RLCol(12, 4, 4, 4);
        buttonCol.setComponent(getButtonofSize("View", "100%", "100%"));
        addColumn(imageCol);
        addColumn(titleCol);
        addColumn(buttonCol);
        setHorizontalSpacing(15);
        setVerticalSpacing(15);


    }

    public Button getButtonofSize(String title, String h, String w) {
        Button button = new Button(title);
        button.setHeight(h);
        button.setWidth(w);

        button.addStyleName("primary");

//        int num = new Random().nextInt(3);
//
//        if (num == 0) {
//            button.addStyleName("primary");
//
//        } else if (num == 1) {
//            button.addStyleName("friendly");
//        } else {
//            button.addStyleName("danger");
//
//        }


        return button;

    }


    public RLCol getInColumn(int xs, int sm, int md, int lg) {

        RLCol col = new RLCol(xs, sm, md, lg);
        col.setComponent(this);

        return col;

    }
}
