package co.beitech.testBeitech.repositories;

import co.beitech.testBeitech.models.CustomerProductModel;
import co.beitech.testBeitech.models.CustomerProductPkModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProductRepository extends JpaRepository<CustomerProductModel, CustomerProductPkModel> {


}
