package com.jackson.ecommerce.conhecendoentitymanager;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Categoria;
import com.jackson.ecommerce.model.Produto;
import org.junit.jupiter.api.Test;

public class CachePrimeiroNivelTest extends EntityManagerTest {

    @Test
    public void verificaCache() {
        Produto produto = entityManager.find(Produto.class, 1);
        System.out.println(produto.getNome());

        System.out.println("-----------------");

        Produto produtoResgatado = entityManager.find(Produto.class, produto.getId());
        System.out.println(produto.getNome());
    }
}
