package cecy.matriculacion.login.customer.Formulario.catalogueForm;

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
@RequestMapping("api/catalogue")
@CrossOrigin({"*"})
public class CatalogueFormController {
    @Autowired CatalogueFormClient catalogueForm;

    @GetMapping("/")
    public List<CatalogueFormDTO> findAll(){
        return catalogueForm.findAll();
    }

    @GetMapping("/{id}/")
    public CatalogueFormDTO finById(@PathVariable Long id){
        return catalogueForm.findById(id);
    }

    @PostMapping("/")
    public CatalogueFormDTO save(@RequestBody CatalogueFormDTO entity){
        return catalogueForm.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        catalogueForm.deleteById(id);
    }

    @PutMapping("/{id}/")
    public CatalogueFormDTO update(@PathVariable Long id, @RequestBody CatalogueFormDTO entity){
        return catalogueForm.update(id, entity);
    }

    @PatchMapping("/{id}/")
    public CatalogueFormDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields){

        CatalogueFormDTO CatalogueFormDTO = catalogueForm.findById(id);

        for (Map.Entry<String, Object> field : fields.entrySet()){
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();

            try{
                Field campoEntidad = CatalogueFormDTO.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(CatalogueFormDTO, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex){

            }
        } 
        return catalogueForm.update(id, CatalogueFormDTO);
    }

}
