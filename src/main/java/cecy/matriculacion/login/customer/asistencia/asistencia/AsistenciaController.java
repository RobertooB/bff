package cecy.matriculacion.login.customer.asistencia.asistencia;

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

@RestController
@RequestMapping("api/asistencia")
@CrossOrigin({"*"})
public class AsistenciaController {
    @Autowired AsistenciaClient asistencia;

    @GetMapping("/")
    public List<AsistenciaDTO> findAll(){
        return asistencia.findAll();
    }

    @GetMapping("/{id}/")
    public AsistenciaDTO finById(@PathVariable Long id){
        return asistencia.findById(id);
    }

    @PostMapping("/")
    public AsistenciaDTO save(@RequestBody AsistenciaDTO entity){
        return asistencia.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        asistencia.deleteById(id);
    }

    @PutMapping("/{id}/")
    public AsistenciaDTO update(@PathVariable Long id, @RequestBody AsistenciaDTO entity){
        return asistencia.update(id, entity);
    }

    @PatchMapping("/{id}/")
    public AsistenciaDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields){

        AsistenciaDTO AsistenciaDTO = asistencia.findById(id);

        for (Map.Entry<String, Object> field : fields.entrySet()){
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();

            try{
                Field campoEntidad = AsistenciaDTO.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(AsistenciaDTO, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex){

            }
        } 
        return asistencia.update(id, AsistenciaDTO);
    }

}