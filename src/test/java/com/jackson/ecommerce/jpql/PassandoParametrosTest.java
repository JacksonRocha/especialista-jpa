package com.jackson.ecommerce.jpql;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Pedido;
import com.jackson.ecommerce.model.StatusPagamento;
import com.jackson.ecommerce.model.StatusPedido;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PassandoParametrosTest extends EntityManagerTest {

    @Test
    public void passarParametro() {
        String jpql = "select p from Pedido p join p.pagamento pag " +
                " where p.id = ?1 and pag.status =?2 ";

        TypedQuery<Pedido> typedQuery = entityManager.createQuery(jpql, Pedido.class);
        typedQuery.setParameter(1, 2);
        typedQuery.setParameter(2, StatusPagamento.PROCESSANDO);

        List<Pedido> lista = typedQuery.getResultList();
        Assertions.assertTrue(lista.size() == 1);
    }
}
