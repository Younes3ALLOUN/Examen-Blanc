package dtos.owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class OwnerUpdateReqDto {
    private String name;
    private Date dat_naissance;
    private String email;

    private  String id;

}
