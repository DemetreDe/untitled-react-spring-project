package deme.backend.springbootbackend.repository;

import deme.backend.springbootbackend.model.OrderSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

//Communicates with DB
public interface OrderSessionRepository extends JpaRepository<OrderSession, Integer> {

    List<OrderSession> findByEmail(String email);

    @Query(value = "SELECT * FROM order_session \n" +
            "WHERE email = :emailSearch \n" +
            "ORDER BY order_date desc \n" +
            "LIMIT 1;", nativeQuery = true)
    OrderSession findLatestOrderByEmail(@Param("emailSearch")String email);

}
