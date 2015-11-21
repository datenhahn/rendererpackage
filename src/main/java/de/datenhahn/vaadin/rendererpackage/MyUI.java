package de.datenhahn.vaadin.rendererpackage;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

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



        for (int i = 0; i < 100000; i++) {
            HorizontalLayout myLayout = new HorizontalLayout();
            Label label = new Label("Hello Component " + i);
            label.setDescription("Hello again");
            myLayout.addComponent(new Label(FontAwesome.SMILE_O.getHtml(), ContentMode.HTML));
            myLayout.addComponent(label);
            myGrid.addRow("test", myLayout);
        }

        layout.addComponent(new Label("foo"));
        layout.addComponent(myGrid);


    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
