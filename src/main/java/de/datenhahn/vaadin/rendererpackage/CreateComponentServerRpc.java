package de.datenhahn.vaadin.rendererpackage;

import com.vaadin.shared.communication.ServerRpc;

public interface CreateComponentServerRpc extends ServerRpc {
    void createComponent();
}
