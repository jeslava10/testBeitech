package co.beitech.testBeitech.repositories;

import co.beitech.testBeitech.models.OrderDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailModel, Long> {

    List<OrderDetailModel>  findByOrderModelOrderIdIn(List<Long> listOrderId);

}
