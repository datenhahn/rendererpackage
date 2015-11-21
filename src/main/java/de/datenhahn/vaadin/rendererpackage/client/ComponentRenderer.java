/*
 * Copyright 2000-2014 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.datenhahn.vaadin.rendererpackage.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FlowPanel;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.renderers.WidgetRenderer;
import com.vaadin.client.widget.grid.RendererCellReference;

/**
 * A renderer that renders an image into a cell. Click handlers can be added to
 * the renderer, invoked every time any of the images rendered by that rendered
 * is clicked.
 * 
 * @since 7.4
 * @author Vaadin Ltd
 */
public class ComponentRenderer extends WidgetRenderer<ComponentConnector, FlowPanel> {

    @Override
    public FlowPanel createWidget() {

        FlowPanel panel = GWT.create(FlowPanel.class);
        return panel;
    }

    @Override
    public void render(RendererCellReference rendererCellReference, ComponentConnector componentConnector, FlowPanel widgets) {
        widgets.clear();
        widgets.add(componentConnector.getWidget());
    }

}
