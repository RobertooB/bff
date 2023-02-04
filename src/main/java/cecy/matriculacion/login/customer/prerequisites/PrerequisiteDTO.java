package cecy.matriculacion.login.customer;

import lombok.Data;

@Data
public class PrerequisiteDTO {
    private long id;
    private String name;
    private String observation; 
    private String route;
    private boolean state;
    
}
