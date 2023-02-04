package cecy.matriculacion.login.customer.asistencia.asistencia;

import java.sql.Date;

import lombok.Data;

@Data
public class AsistenciaDTO {
    private long id;
    private String periodo;
    private long cursoId;
    private Date fecha;
}
