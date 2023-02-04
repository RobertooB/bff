package cecy.matriculacion.login.customer.Formulario.formInscription;

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
@RequestMapping("api/formInscription")
@CrossOrigin({"*"})
public class FormInscriptionController {
    @Autowired FormInscriptionClient formInscription;

    @GetMapping("/")
    public List<FormInscriptionDTO> findAll(){
        return formInscription.findAll();
    }

    @GetMapping("/{id}/")
    public FormInscriptionDTO finById(@PathVariable Long id){
        return formInscription.findById(id);
    }

    @PostMapping("/")
    public FormInscriptionDTO save(@RequestBody FormInscriptionDTO entity){
        return formInscription.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        formInscription.deleteById(id);
    }

    @PutMapping("/{id}/")
    public FormInscriptionDTO update(@PathVariable Long id, @RequestBody FormInscriptionDTO entity){
        return formInscription.update(id, entity);
    }

    @PatchMapping("/{id}/")
    public FormInscriptionDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields){

        FormInscriptionDTO FormInscriptionDTO = formInscription.findById(id);

        for (Map.Entry<String, Object> field : fields.entrySet()){
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();

            try{
                Field campoEntidad = FormInscriptionDTO.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(FormInscriptionDTO, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex){

            }
        } 
        return formInscription.update(id, FormInscriptionDTO);
    }

}
