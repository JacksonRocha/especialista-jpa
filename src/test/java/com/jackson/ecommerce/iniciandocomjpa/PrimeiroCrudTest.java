package com.jackson.ecommerce.iniciandocomjpa;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Cliente;
import com.jackson.ecommerce.model.SexoCliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void criandoCliente() {
        Cliente cliente = new Cliente();

        //cliente.setId(3); //Estamos usando o IDENTITY na entidade
        cliente.setNome("Jackson Lucas");
        cliente.setSexo(SexoCliente.MASCULINO);
        cliente.setCpf("4444");


        entityManager.getTransaction().begin();
        cliente = entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assertions.assertNotNull(clienteVerificacao);
    }

    @Test
    public void buscandoCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Assertions.assertNotNull(cliente);
        Assertions.assertEquals("Fernando Medeiros", cliente.getNome());
        System.out.println(cliente.getNome());
    }

    @Test
    public void atualizandoCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 2);

        entityManager.getTransaction().begin();
        cliente = entityManager.merge(cliente);
        cliente.setNome("Lucas Batista");
        cliente.setCpf("01422222160");
        cliente.setSexo(SexoCliente.MASCULINO);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assertions.assertEquals("Lucas Batista", clienteVerificacao.getNome());
    }

    @Test
    public void deletarCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assertions.assertNull(clienteVerificacao);
    }
}
