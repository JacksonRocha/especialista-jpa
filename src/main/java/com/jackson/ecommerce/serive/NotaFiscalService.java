package com.jackson.ecommerce.serive;

import com.jackson.ecommerce.model.Pedido;

public class NotaFiscalService {

    public void gerar(Pedido pedido) {
        System.out.println("Gerando nota para o pedido" + pedido.getId() + ".");
    }
}
