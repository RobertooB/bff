package cecy.matriculacion.login.customer.asistencia.catalogoAsistencia;

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
@RequestMapping("api/catalogoAsistencia")
@CrossOrigin({"*"})
public class CatalogoAsistenciaController {
    @Autowired CatalogoAsistenciaClient catalogoAsistencia;

    @GetMapping("/")
    public List<CatalogoAsistenciaDTO> findAll(){
        return catalogoAsistencia.findAll();
    }

    @GetMapping("/{id}/")
    public CatalogoAsistenciaDTO finById(@PathVariable Long id){
        return catalogoAsistencia.findById(id);
    }

    @PostMapping("/")
    public CatalogoAsistenciaDTO save(@RequestBody CatalogoAsistenciaDTO entity){
        return catalogoAsistencia.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        catalogoAsistencia.deleteById(id);
    }

    @PutMapping("/{id}/")
    public CatalogoAsistenciaDTO update(@PathVariable Long id, @RequestBody CatalogoAsistenciaDTO entity){
        return catalogoAsistencia.update(id, entity);
    }

    @PatchMapping("/{id}/")
    public CatalogoAsistenciaDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields){

        CatalogoAsistenciaDTO CatalogoAsistenciaDTO = catalogoAsistencia.findById(id);

        for (Map.Entry<String, Object> field : fields.entrySet()){
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();

            try{
                Field campoEntidad = CatalogoAsistenciaDTO.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(CatalogoAsistenciaDTO, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex){

            }
        } 
        return catalogoAsistencia.update(id, CatalogoAsistenciaDTO);
    }

}
