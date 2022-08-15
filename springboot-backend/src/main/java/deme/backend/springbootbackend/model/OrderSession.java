package deme.backend.springbootbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.sql.Date;

//Structure for entities in db
@Data
@Entity
@Table(name="orderSession")
public class OrderSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    @Column(name = "ocp_order_id")
    private String ocpOrderID;

    @Column(name = "shopify_order_number")
    private String shopifyOrderNum;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "order_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date orderDate;

    @Column(name = "order_total")
    private float orderTotal;

    @Column(name = "email")
    private String email;


}
