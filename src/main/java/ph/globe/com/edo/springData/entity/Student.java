package ph.globe.com.edo.springData.entity;




import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studNo;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();


    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate = new Date();

    private String fullName;

    private String username;

    private String password;

    private String program;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
