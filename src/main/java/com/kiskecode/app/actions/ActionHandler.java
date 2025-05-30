package com.kiskecode.app.actions;

import com.kiskecode.app.beans.InfoClienteBean;

public class ActionHandler {

    public InfoClienteBean clientes() {

        InfoClienteBean myCliente = new InfoClienteBean(1,"Lluis Alsina","lalsina883@gmail.com");
        
        return myCliente;
    }

    // Aquí puedes seguir agregando métodos
}