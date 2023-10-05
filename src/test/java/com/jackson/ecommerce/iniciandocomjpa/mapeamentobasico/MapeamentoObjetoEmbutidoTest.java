package com.jackson.ecommerce.iniciandocomjpa.mapeamentobasico;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.model.Cliente;
import com.jackson.ecommerce.model.EnderecoEntregaPedido;
import com.jackson.ecommerce.model.Pedido;
import com.jackson.ecommerce.model.StatusPedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest {


    @Test
    public void analisarMapeamentoObjetoEmbutido() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
        endereco.setCep("72210-082");
        endereco.setLogradouro("Qsc 19 Conjunto F");
        endereco.setNumero("34");
        endereco.setComplemento("Chacara 25");
        endereco.setBairro("Taguatinga-Sul");
        endereco.setCidade("Brasilia");
        endereco.setEstado("DF");

        Pedido pedido = new Pedido();
        //pedido.setId(1); //Estamos usando o IDENTITY na entidade
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal(1000));
        pedido.setEnderecoEntrega(endereco);
        pedido.setCliente(cliente);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assertions.assertNotNull(pedidoVerificacao);
        Assertions.assertNotNull(pedidoVerificacao.getEnderecoEntrega());
        Assertions.assertNotNull(pedidoVerificacao.getEnderecoEntrega().getCep());


    }
}
