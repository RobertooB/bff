package cecy.matriculacion.login.customer;

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
@RequestMapping("api/prerequisite")
@CrossOrigin({"*"})
public class PrerequisiteController {
    @Autowired PrerequisiteClient prerequisite;

    @GetMapping("/")
    public List<PrerequisiteDTO> findAll(){
        return prerequisite.findAll();
    }

    @GetMapping("/{id}/")
    public PrerequisiteDTO finById(@PathVariable Long id){
        return prerequisite.findById(id);
    }

    @PostMapping("/")
    public PrerequisiteDTO save(@RequestBody PrerequisiteDTO entity){
        return prerequisite.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        prerequisite.deleteById(id);
    }

    @PutMapping("/{id}/")
    public PrerequisiteDTO update(@PathVariable Long id, @RequestBody PrerequisiteDTO entity){
        return prerequisite.update(id, entity);
    }

    @PatchMapping("/{id}/")
    public PrerequisiteDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields){

        PrerequisiteDTO PrerequisiteDTO = prerequisite.findById(id);

        for (Map.Entry<String, Object> field : fields.entrySet()){
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();

            try{
                Field campoEntidad = PrerequisiteDTO.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(PrerequisiteDTO, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex){

            }
        } 
        return prerequisite.update(id, PrerequisiteDTO);
    }

}
