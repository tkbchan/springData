package ph.globe.com.edo.springData.dto;
import lombok.Data;

@Data
public class StudentDto {
    private Long studNo;
    private String fullName;
    private String username;
    private String password;
    private String program;

    private AddressDto address;
}
