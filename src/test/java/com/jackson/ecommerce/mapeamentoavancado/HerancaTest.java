package com.jackson.ecommerce.mapeamentoavancado;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Cliente;
import com.jackson.ecommerce.model.SexoCliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class HerancaTest extends EntityManagerTest {

    @Test
    public void salvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Fernanda Morais");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assertions.assertNotNull(clienteVerificacao.getId());
    }
}
