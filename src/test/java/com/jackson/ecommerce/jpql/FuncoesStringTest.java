package com.jackson.ecommerce.jpql;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Categoria;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FuncoesStringTest extends EntityManagerTest {

    @Test
    public void aplicarFuncao() {
        // concat, length, locate, substring, lower, upper, trim

        String jpql = "select c.nome, length(c.nome) from Categoria c " +
                " where substring(c.nome, 1, 1) = 'N'";

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        Assertions.assertFalse(lista.isEmpty());

        lista.forEach(arr -> System.out.println(arr[0] + " - " + arr[1]));
    }
}
