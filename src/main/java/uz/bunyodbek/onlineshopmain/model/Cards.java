package uz.bunyodbek.onlineshopmain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String cardnumber;
    @Column(nullable = false)
    private String expireDate;
    @Column(nullable = false)
    private String cardname;

}
