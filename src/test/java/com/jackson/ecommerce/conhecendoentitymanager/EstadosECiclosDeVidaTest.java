package com.jackson.ecommerce.conhecendoentitymanager;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Categoria;
import org.junit.jupiter.api.Test;

public class EstadosECiclosDeVidaTest extends EntityManagerTest {

    @Test
    public void analisarEstados() {
        Categoria categoriaNovo = new Categoria();
        categoriaNovo.setNome("Eletrônicos");

        Categoria categoriaGerenciadaMerge = entityManager.merge(categoriaNovo);

        Categoria categoriaGerenciada = entityManager.find(Categoria.class, 1);

        entityManager.remove(categoriaGerenciada);
        entityManager.persist(categoriaGerenciada);

        entityManager.detach(categoriaGerenciada);
    }
}
