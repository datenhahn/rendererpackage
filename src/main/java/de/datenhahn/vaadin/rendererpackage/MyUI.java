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


    private HorizontalLayout createDemoLayout(String text) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.addComponent(new Label(FontAwesome.SMILE_O.getHtml(), ContentMode.HTML));

        Label label = new Label(text);
        label.setDescription(text);

        layout.addComponent(label);

        return layout;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);


        Grid myGrid = new Grid();

        myGrid.addColumn("foo");
        myGrid.addColumn("bar", Component.class).setRenderer(new ComponentRenderer());
        myGrid.addColumn("bar2", Component.class).setRenderer(new ComponentRenderer());
        myGrid.addColumn("bar3", Component.class).setRenderer(new ComponentRenderer());




        for (int i = 0; i < 30000; i++) {
            myGrid.addRow("test", createDemoLayout("1 - " +i),createDemoLayout("2 - " +i), createDemoLayout("3 - " +i));
        }

        layout.addComponent(myGrid);


    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
