package uz.bunyodbek.onlineshopmain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.AnnotationUtils;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    private Timestamp period_date;
    @Column(nullable = false)
    private Integer amount;
    @Column(nullable = false)
    private String savat;
    @Column(nullable = false)
    private String description;

}
