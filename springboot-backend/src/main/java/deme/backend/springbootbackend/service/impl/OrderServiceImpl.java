package deme.backend.springbootbackend.service.impl;


import deme.backend.springbootbackend.exception.ResourceNotFoundException;
import deme.backend.springbootbackend.model.OrderSession;
import deme.backend.springbootbackend.repository.OrderSessionRepository;
import deme.backend.springbootbackend.service.OrderService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//implementation of OrderService interface methods
@Service
public class OrderServiceImpl implements OrderService {

    private OrderSessionRepository orderSessionRepository;

    public OrderServiceImpl(OrderSessionRepository orderSessionRepository) {
        super();
        this.orderSessionRepository = orderSessionRepository;
    }

    @Override
    public OrderSession saveOrderSession(OrderSession orderSession) {
        return orderSessionRepository.save(orderSession);
    }

    @Override
    public List<OrderSession> getAllOrders() {
        return orderSessionRepository.findAll();
    }

    @Override
    public OrderSession getOrderByID(int id) {
        Optional<OrderSession> orderSession = orderSessionRepository.findById(id);

        if(orderSession.isPresent()) {
            return orderSession.get();
        }else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public List<OrderSession> findByEmail(String email) {
        return orderSessionRepository.findByEmail(email);
    }

    @Override
    public int countOrdersByEmail(String email) {
        return findByEmail(email).size();
    }

    @Override
    public OrderSession findLatestOrderByEmail(String email) {
        return orderSessionRepository.findLatestOrderByEmail(email);
    }


}
