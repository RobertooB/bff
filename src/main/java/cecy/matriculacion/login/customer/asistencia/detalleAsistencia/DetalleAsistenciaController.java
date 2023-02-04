package cecy.matriculacion.login.customer.asistencia.detalleAsistencia;

    import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

@RestController
@RequestMapping("api/detalleAsistencia")
@CrossOrigin({"*"})
public class DetalleAsistenciaController {
    @Autowired DetalleAsistenciaClient detalleAsistencia;

    @GetMapping("/")
    public List<DetalleAsistenciaDTO> findAll(){
        return detalleAsistencia.findAll();
    }

    @GetMapping("/{id}/")
    public DetalleAsistenciaDTO finById(@PathVariable Long id){
        return detalleAsistencia.findById(id);
    }

    @PostMapping("/")
    public DetalleAsistenciaDTO save(@RequestBody DetalleAsistenciaDTO entity){
        return detalleAsistencia.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        detalleAsistencia.deleteById(id);
    }

    @PutMapping("/{id}/")
    public DetalleAsistenciaDTO update(@PathVariable Long id, @RequestBody DetalleAsistenciaDTO entity){
        return detalleAsistencia.update(id, entity);
    }

    @PatchMapping("/{id}/")
    public DetalleAsistenciaDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields){

        DetalleAsistenciaDTO DetalleAsistenciaDTO = detalleAsistencia.findById(id);

        for (Map.Entry<String, Object> field : fields.entrySet()){
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();

            try{
                Field campoEntidad = DetalleAsistenciaDTO.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(DetalleAsistenciaDTO, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex){

            }
        } 
        return detalleAsistencia.update(id, DetalleAsistenciaDTO);
    }

}
