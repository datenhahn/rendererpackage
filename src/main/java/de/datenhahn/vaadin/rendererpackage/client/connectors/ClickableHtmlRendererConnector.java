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

import com.google.web.bindery.event.shared.HandlerRegistration;
import com.vaadin.client.connectors.ClickableRendererConnector;
import com.vaadin.client.renderers.ClickableRenderer.RendererClickHandler;
import com.vaadin.client.renderers.ImageRenderer;
import com.vaadin.shared.ui.Connect;
import de.datenhahn.vaadin.rendererpackage.client.ClickableHtmlRenderer;
import elemental.json.JsonObject;

/**
 * A connector for {@link ImageRenderer}.
 * 
 * @since 7.4
 * @author Vaadin Ltd
 */
@Connect(de.datenhahn.vaadin.rendererpackage.ClickableHtmlRenderer.class)
public class ClickableHtmlRendererConnector extends ClickableRendererConnector<String> {

    @Override
    public ClickableHtmlRenderer getRenderer() {
        return (ClickableHtmlRenderer) super.getRenderer();
    }

    @Override
    protected HandlerRegistration addClickHandler(
            RendererClickHandler<JsonObject> handler) {
        return getRenderer().addClickHandler(handler);
    }
}
