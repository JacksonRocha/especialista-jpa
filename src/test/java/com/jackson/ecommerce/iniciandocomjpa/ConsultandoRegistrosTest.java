package com.jackson.ecommerce.iniciandocomjpa;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsultandoRegistrosTest extends EntityManagerTest {

    @Test
    public  void buscarPorIdentificador() {
        Produto produto = entityManager.find(Produto.class, 1);
//        Produto produto = entityManager.getReference(Produto.class, 1);

        Assertions.assertNotNull(produto);
        Assertions.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void atualizarAReferencia() {
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Microfone Samsung");

        entityManager.refresh(produto);

        Assertions.assertEquals("Kindle", produto.getNome());
    }
}
