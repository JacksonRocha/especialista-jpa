package com.jackson.ecommerce.jpql;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Pedido;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OperadoresLogicosTest extends EntityManagerTest {

    @Test
    public void usarOperadores() {
        String jpql = "select p from Pedido p " +
                " where (p.status = 'AGUARDANDO' or p.status = 'PAGO') and p.total > 100";

        TypedQuery<Pedido> typedQuery = entityManager.createQuery(jpql, Pedido.class);

        List<Pedido> lista = typedQuery.getResultList();
        Assertions.assertFalse(lista.isEmpty());
    }
}
