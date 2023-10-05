package com.jackson.ecommerce.relacionamentos;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Pedido;
import org.junit.jupiter.api.Test;

public class EagerELazyTest extends EntityManagerTest {

    @Test
    public void verificarComportamento() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        pedido.getItens().isEmpty();
    }
}
