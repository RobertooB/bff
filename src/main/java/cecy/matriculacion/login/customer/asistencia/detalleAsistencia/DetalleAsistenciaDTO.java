package cecy.matriculacion.login.customer.asistencia.detalleAsistencia;

import cecy.matriculacion.login.customer.asistencia.asistencia.AsistenciaDTO;
import cecy.matriculacion.login.customer.asistencia.catalogoAsistencia.CatalogoAsistenciaDTO;
import lombok.Data;

@Data
public class DetalleAsistenciaDTO {
    private long id;
    private long personaId;
    private AsistenciaDTO asistenciaId;
    private CatalogoAsistenciaDTO catalogoId;
}
