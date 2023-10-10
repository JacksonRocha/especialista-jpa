package com.jackson.ecommerce.jpql;

import com.jackson.ecommerce.EntityManagerTest;
import com.jackson.ecommerce.dto.ProdutoDTO;
import com.jackson.ecommerce.model.Cliente;
import com.jackson.ecommerce.model.Pedido;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.List;

public class BasicoJPQLTest extends EntityManagerTest {

    @Test
    public void prejetarNoDTO() {
        String jpql = "select new com.jackson.ecommerce.dto.ProdutoDTO(id, nome) from Produto";

        TypedQuery<ProdutoDTO> typedQuery = entityManager.createQuery(jpql, ProdutoDTO.class);
        List<ProdutoDTO> lista = typedQuery.getResultList();

        Assertions.assertFalse(lista.isEmpty());
        lista.forEach(p -> System.out.println(p.getId() + ", " + p.getNome()));
    }


    @Test
    public void projetarOResultado() {
        String jpql = "select id, nome from Produto";

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();

        Assertions.assertTrue(lista.get(0).length == 2);

        lista.forEach(arr -> System.out.println(arr[0] + ", " + arr[1]));
    }

    @Test
    public void selecionarUmAtributoParaRetorno() {
        String jpql = "select p.nome from Produto p";

        TypedQuery<String> typedQuery = entityManager.createQuery(jpql, String.class);
        List<String> lista = typedQuery.getResultList();
        Assertions.assertTrue(String.class.equals(lista.get(0).getClass()));

        String jpqlCliente = "select p.cliente from Pedido p";
        TypedQuery<Cliente> typedQueryClientes = entityManager.createQuery(jpqlCliente, Cliente.class);
        List<Cliente> listaClientes = typedQueryClientes.getResultList();
        Assertions.assertTrue(Cliente.class.equals(listaClientes.get(0).getClass()));
    }

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

    @Test
    public void mostrarDiferencaQueries() {
        String jpql = "select p from Pedido p where p.id = 1";

        TypedQuery<Pedido> typedQuery = entityManager.createQuery(jpql, Pedido.class);
        Pedido pedido1 = typedQuery.getSingleResult();
        Assertions.assertNotNull(pedido1);



        Query query = entityManager.createQuery(jpql);
        Pedido pedido2 = (Pedido) query.getSingleResult();
        Assertions.assertNotNull(pedido2);

//        List<Pedido> lista = query.getResultList();
//        Assertions.assertFalse(lista.isEmpty());
    }
}
