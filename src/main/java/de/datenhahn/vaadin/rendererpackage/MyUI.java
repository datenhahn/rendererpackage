package de.datenhahn.vaadin.rendererpackage;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

import static com.google.gwt.thirdparty.guava.common.collect.Lists.newArrayList;

/**
 *
 */
@Theme("mytheme")
@Widgetset("de.datenhahn.vaadin.rendererpackage.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);


        Grid myGrid = new Grid();

        myGrid.addColumn("foo");
        myGrid.addColumn("bar", Component.class).setRenderer(new ComponentRenderer());



        for (int i = 0; i < 10000; i++) {
            ComboBox myCombo = new ComboBox("", newArrayList("foo", "bar", "and", "more"));


            myGrid.addRow("test", myCombo);
        }

        layout.addComponent(myGrid);


    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
