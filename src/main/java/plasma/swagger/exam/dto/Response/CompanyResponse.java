package plasma.swagger.exam.dto.Response;

import lombok.Data;

@Data
public class CompanyResponse {

    private Long companyId;
    private String companyName;
    private String locatedCountry;
}
