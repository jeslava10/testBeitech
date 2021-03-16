package co.beitech.testBeitech.repositories;

import co.beitech.testBeitech.models.CustomerModel;
import co.beitech.testBeitech.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {

    List<OrderModel> findByCustomerModelCustomerIdAndCreationDateBetweenOrderByCreationDateAsc(Long idCustomer,Date initialDate,Date finalDate);
}
