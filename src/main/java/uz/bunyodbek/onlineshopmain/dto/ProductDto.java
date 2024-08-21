package uz.bunyodbek.onlineshopmain.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {

    private String name;
    private Double price;
    private Integer amount;
    private String description;

}
