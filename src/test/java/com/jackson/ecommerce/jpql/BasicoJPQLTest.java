package com.jackson.ecommerce.jpql;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Pedido;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BasicoJPQLTest extends EntityManagerTest {

    @Test
    public void buscarPorIdentificador() {
        // Java Persistence Query Language - JPQL

 /* A vantagem no jpql que referenciamos a entidade não a tabela no banco
     JPQL - select p from Pedido p where p.id = 1                   */

        // SQL - select p.* from pedido p where p.id = 1


        //entityManeger.find(Pedido.class, 1);
        TypedQuery<Pedido> typedQuery = entityManager
                .createQuery("select p from Pedido p where p.id = 1", Pedido.class);

        //select p.* from pedido p where p.id = 1;

        Pedido pedido = typedQuery.getSingleResult();
        Assertions.assertNotNull(pedido);

//        List<Pedido> lista = typedQuery.getResultList();
//        Assertions.assertNotNull(lista);
    }
}
