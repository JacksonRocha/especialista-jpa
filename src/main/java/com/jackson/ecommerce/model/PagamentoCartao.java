package com.jackson.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@DiscriminatorValue("cartao")
@Entity
public class PagamentoCartao extends Pagamento{

    @Column(name = "numero_cartao", length = 50, nullable = false)
    private String numeroCartao;
}
