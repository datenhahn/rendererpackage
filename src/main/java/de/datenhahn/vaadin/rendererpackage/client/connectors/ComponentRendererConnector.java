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
package de.datenhahn.vaadin.rendererpackage.client.connectors;

import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorMap;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.connectors.AbstractRendererConnector;
import com.vaadin.client.renderers.ImageRenderer;
import com.vaadin.shared.ui.Connect;
import de.datenhahn.vaadin.rendererpackage.client.ComponentRenderer;
import elemental.json.JsonValue;

/**
 * A connector for {@link ImageRenderer}.
 * 
 * @since 7.4
 * @author Vaadin Ltd
 */
@Connect(de.datenhahn.vaadin.rendererpackage.ComponentRenderer.class)
public class ComponentRendererConnector extends AbstractRendererConnector<ComponentConnector> {

    @Override
    public ComponentRenderer getRenderer() {
        ComponentRenderer renderer = (ComponentRenderer) super.getRenderer();
        return renderer;
    }

    public ComponentConnector decode(JsonValue value) {
        ServerConnector decodedValue = ConnectorMap.get(getConnection()).getConnector(value.toString());
        decodedValue.setParent(getParent());
        return (ComponentConnector) decodedValue;
    }
}
