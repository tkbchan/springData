package ph.globe.com.edo.springData.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String country;
}
