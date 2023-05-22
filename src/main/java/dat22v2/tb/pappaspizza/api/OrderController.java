package dat22v2.tb.pappaspizza.api;

import dat22v2.tb.pappaspizza.dto.order.OrderRequest;
import dat22v2.tb.pappaspizza.dto.order.OrderResponse;
import dat22v2.tb.pappaspizza.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrderController {


    OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping()
    public List<OrderResponse> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/viewConfirmed")
    public List<OrderResponse> getConfirmedOrders(){
        return orderService.getConfirmedOrders();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/viewNonConfirmed")
    public List<OrderResponse> getNonConfirmedOrders(){
        return orderService.getNonConfirmedOrders();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/confirm/{id}")
    public void confirmOrder(@PathVariable Integer id){
        orderService.confirmOrder(id);

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("status/{id}")
    public void changeStatus(@PathVariable Integer id, @RequestParam String newStatus){
        orderService.changeStatus(id, newStatus);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        path = "/addOrder"  )
    public OrderResponse addOrder(@RequestBody OrderRequest body){
        return orderService.addOrder(body);
    }
}
