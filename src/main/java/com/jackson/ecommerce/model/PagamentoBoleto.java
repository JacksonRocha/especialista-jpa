package com.jackson.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@DiscriminatorValue("boleto")
@Entity
public class PagamentoBoleto extends Pagamento{

    @Column(name = "codigo_barras", length = 100)
    private String codigoBarras;
}
