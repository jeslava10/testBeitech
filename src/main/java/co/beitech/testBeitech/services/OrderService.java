package co.beitech.testBeitech.services;

import co.beitech.testBeitech.exceptions.GeneralServiceException;
import co.beitech.testBeitech.exceptions.NoDataFoundException;
import co.beitech.testBeitech.exceptions.ValidateServiceException;
import co.beitech.testBeitech.models.CustomerProductPkModel;
import co.beitech.testBeitech.models.OrderDetailModel;
import co.beitech.testBeitech.models.ProductModel;
import co.beitech.testBeitech.models.dtos.OrderDTO;
import co.beitech.testBeitech.models.dtos.OrderDetailDTO;
import co.beitech.testBeitech.models.dtos.ProductDetailDTO;
import co.beitech.testBeitech.models.transforms.CustomerTransform;
import co.beitech.testBeitech.models.transforms.OrderDetailTransform;
import co.beitech.testBeitech.models.transforms.OrderTransform;
import co.beitech.testBeitech.repositories.CustomerProductRepository;
import co.beitech.testBeitech.repositories.OrderDetailRepository;
import co.beitech.testBeitech.repositories.OrderRepository;
import co.beitech.testBeitech.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {

    private static final OrderTransform ORDER_TRANSFORM = new OrderTransform();
    private static final CustomerTransform CUSTOMER_TRANSFORM = new CustomerTransform();
    private static final OrderDetailTransform ORDER_DETAIL_TRANSFORM = new OrderDetailTransform();

    private final OrderDetailRepository orderDetailRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CustomerProductRepository customerProductRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository,OrderDetailRepository orderDetailRepository
    , ProductRepository productRepository ,  CustomerProductRepository customerProductRepository){
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productRepository = productRepository;
        this.customerProductRepository = customerProductRepository;
    }

    public List<OrderDTO> findByCustomerModelCustomerId(Long idCustomer,Date initialDate,Date finalDate){
        try {

            List<OrderDTO>  listOrderDto = orderRepository.findByCustomerModelCustomerIdAndCreationDateBetweenOrderByCreationDateAsc(idCustomer,initialDate,finalDate).stream()
                .map(ORDER_TRANSFORM::OrderToOrderDTO)
                .collect(Collectors.toList());

            List<OrderDetailModel> listOrderDetailModel = orderDetailRepository.findByOrderModelOrderIdIn(listOrderDto.stream().map(orderDTO -> orderDTO.getOrderId() ).collect(Collectors.toList()));

            for (OrderDTO element :listOrderDto ) {

                Map<String , Integer> productMap =
                (listOrderDetailModel.stream()
                        .filter( detailModel -> detailModel.getOrderModel().getOrderId().equals(element.getOrderId()))
                        .collect(Collectors.groupingBy(OrderDetailModel::getProductDescription,Collectors.summingInt(OrderDetailModel::getQuantity))));

                List<ProductDetailDTO> listProductDetailDTO = new ArrayList<>();
                productMap.forEach((nombre,cantidad)->listProductDetailDTO.add(new ProductDetailDTO(nombre,cantidad)));
                element.setListProductDTO(listProductDetailDTO);

            }

            return listOrderDto ;

        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;

        }catch (Exception e) {
                log.error(e.getMessage(), e);
                throw new GeneralServiceException(e.getMessage(), e);
            }

    }

    public OrderDTO saveOrder(OrderDTO orderDTO) {
        try {

            double total = 0;

            for(ProductDetailDTO element : orderDTO.getListProductDTO()) {

                ProductModel product = productRepository.findById(element.getProductId())
                        .orElseThrow(() -> new NoDataFoundException("No existe el producto " + element.getProductId()));

               customerProductRepository.findById(new CustomerProductPkModel(orderDTO.getCustomer().getCustomerId(),product.getProductId()  ))
                        .orElseThrow(() -> new NoDataFoundException("No es validado para el cliente" + orderDTO.getCustomer().getCustomerId()));

               if(element.getQuantity() > 5 ) new ValidateServiceException("la cantidad de elementos de debe ser mayor 5");


            }






            //OrderModel orderModel  = orderRepository.save(ORDER_TRANSFORM.OrderDTOToOrder(order));

            return orderDTO;

        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

}
