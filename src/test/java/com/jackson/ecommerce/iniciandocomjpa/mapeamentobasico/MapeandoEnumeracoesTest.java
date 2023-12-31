package com.jackson.ecommerce.iniciandocomjpa.mapeamentobasico;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Cliente;
import com.jackson.ecommerce.model.SexoCliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapeandoEnumeracoesTest extends EntityManagerTest {

    @Test
    public void testEnum() {
        Cliente cliente = new Cliente();
        // cliente.setId(4); //Estamos usando o IDENTITY na entidade
        cliente.setNome("José Mineiro");
        cliente.setCpf("93874");
        cliente.setSexo(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class,cliente.getId());
        Assertions.assertNotNull(clienteVerificacao);
    }
}
