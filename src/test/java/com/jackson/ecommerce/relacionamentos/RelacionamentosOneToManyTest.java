package com.jackson.ecommerce.relacionamentos;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentosOneToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setTotal(new BigDecimal(10));

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assertions.assertFalse(clienteVerificacao.getPedidos().isEmpty());
    }
    @Test
    public void verificandoRelacionamentoPedido() {
        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);
        pedido.setCliente(cliente);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(1);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assertions.assertFalse(pedidoVerificacao.getItensPedido().isEmpty());
    }

}
