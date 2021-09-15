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
    @Column(name = "studNo")
    private Long studNo;

    @Column(updatable = false, name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    @Column(name = "updatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate = new Date();

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "program")
    private String program;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
