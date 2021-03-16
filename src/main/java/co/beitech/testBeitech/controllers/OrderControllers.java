package co.beitech.testBeitech.controllers;

import co.beitech.testBeitech.models.dtos.OrderCustomerProductDTO;
import co.beitech.testBeitech.models.dtos.OrderDTO;
import co.beitech.testBeitech.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/order")
@Api(tags = "Order Api")
public class OrderControllers {

    private final OrderService orderService;

    @Autowired
    public OrderControllers(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/idCustomer={idCustomer}/initialDate={initialDate}/finalDate={finalDate}")
    @ApiOperation(value = "Get Orders By Id", response = OrderCustomerProductDTO.class)
    public List<OrderCustomerProductDTO> findByCustomerModelCustomerId(@PathVariable(value = "idCustomer") Long idCustomer ,
                                                                       @PathVariable(value = "initialDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date initialDate,
                                                                       @PathVariable(value = "finalDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date finalDate){
        return orderService.findByCustomerModelCustomerId(idCustomer,initialDate,finalDate);
    }

    @PostMapping(path = "/save")
    @ApiOperation(value = "Insert Ordert ", response = OrderDTO.class)
    public OrderDTO saveOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.saveOrder(orderDTO);
    }



}
