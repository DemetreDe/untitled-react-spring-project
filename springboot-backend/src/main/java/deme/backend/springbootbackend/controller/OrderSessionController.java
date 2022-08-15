package deme.backend.springbootbackend.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import deme.backend.springbootbackend.model.Email;
import deme.backend.springbootbackend.model.OrderSession;
import deme.backend.springbootbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Communicates with client
@RestController
@RequestMapping("/api/orders")
public class OrderSessionController {

    @Autowired
    private OrderService orderService;

    public OrderSessionController(OrderService orderService) {
        super();
        this.orderService = orderService;
    }

    //POST

    @PostMapping()
    public ResponseEntity<OrderSession> saveOrder(@RequestBody OrderSession orderSession){
        return new ResponseEntity<OrderSession>(orderService.saveOrderSession(orderSession), HttpStatus.CREATED);
    }

    //GET
    @GetMapping
    public List<OrderSession> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderSession>  getOrdersById(@PathVariable("id") int orderID){
        return new ResponseEntity<OrderSession>(orderService.getOrderByID(orderID), HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<List<OrderSession>> getOrdersByEmail(@RequestParam(name = "email") String email){
        return new ResponseEntity<List<OrderSession>>(orderService.findByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/email/count")
    public ResponseEntity<Integer> getEmailCount(@RequestParam(name = "email") String email){
        return new ResponseEntity<Integer>(orderService.countOrdersByEmail(email), HttpStatus.OK);
    }

//    @GetMapping("/email/latest")
//    public ResponseEntity<OrderSession> findLatestOrderByEmail(String email){
//        return new ResponseEntity<OrderSession>(orderService.findLatestOrderByEmail(email),HttpStatus.OK);
//    }

    @PostMapping("/email/latest")
    public ResponseEntity<OrderSession> findLatestOrderByEmail(@RequestBody Email emailReceived){
        String email = emailReceived.getEmail();
        return new ResponseEntity<OrderSession>(orderService.findLatestOrderByEmail(email),HttpStatus.OK);
    }
}
