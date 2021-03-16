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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_product")
public class CustomerProductModel implements Serializable {

    @EmbeddedId
    CustomerProductPkModel customerProductPkModelId;

    @OneToOne
    //@JoinColumn(name = "customer_product_customer_id_foreign", nullable = false, updatable = false)
   @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false, insertable = false, updatable = false)
    private CustomerModel customerModel;

    @OneToOne
   // @JoinColumn(name = "customer_product_product_id_foreign", nullable = false, updatable = false)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false, insertable = false, updatable = false)
    private ProductModel productModel;


}
