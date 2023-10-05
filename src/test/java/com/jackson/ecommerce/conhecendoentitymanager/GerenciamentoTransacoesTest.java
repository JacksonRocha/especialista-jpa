package com.jackson.ecommerce.conhecendoentitymanager;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Pedido;
import com.jackson.ecommerce.model.Produto;
import com.jackson.ecommerce.model.StatusPedido;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GerenciamentoTransacoesTest extends EntityManagerTest {

    @Test
    public void abrirFecharCancelarTrasacoes() {
        Assertions.assertThrows(Exception.class, () -> erroEsperadoMetodoNegocio());
    }

    private void erroEsperadoMetodoNegocio() {
        try {
            entityManager.getTransaction().begin();
            metodoDeNegocio();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    private void metodoDeNegocio() {
        Pedido pedido = entityManager.find(Pedido.class, 1);
        pedido.setStatus(StatusPedido.PAGO);

        if (pedido.getPagamento() == null) {
            throw new RuntimeException("Pedido ainda nao foi pago");
        }
    }
}
