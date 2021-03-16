package co.beitech.testBeitech.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_product")
@IdClass(CustomerProductPkModel.class)
public class CustomerProductModel implements Serializable {

    @Id
    @Column(name = "customer_id")
    private Long customerId;

    @Id
    @Column(name = "product_id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "customer_product_customer_id_foreign", nullable = false, updatable = false)
    private CustomerModel customerModel;

    @ManyToOne
    @JoinColumn(name = "customer_product_product_id_foreign", nullable = false, updatable = false)
    private ProductModel productModel;


}
