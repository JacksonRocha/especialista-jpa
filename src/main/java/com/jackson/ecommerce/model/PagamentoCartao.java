package com.jackson.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "pagamento_cartao")
public class PagamentoCartao extends Pagamento{

    @Column(name = "numero_cartao")
    private String numeroCartao;
}
