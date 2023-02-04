package cecy.matriculacion.login.customer.catalogue;

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
@RequestMapping("api/catalogo")
@CrossOrigin({"*"})
public class CatalogueController {
    @Autowired CatalogueClient catalogo;

    @GetMapping("/")
    public List<CatalogueDTO> findAll(){
        return catalogo.findAll();
    }

    @GetMapping("/{id}/")
    public CatalogueDTO finById(@PathVariable Long id){
        return catalogo.findById(id);
    }

    @PostMapping("/")
    public CatalogueDTO save(@RequestBody CatalogueDTO entity){
        return catalogo.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        catalogo.deleteById(id);
    }

    @PutMapping("/{id}/")
    public CatalogueDTO update(@PathVariable Long id, @RequestBody CatalogueDTO entity){
        return catalogo.update(id, entity);
    }

    @PatchMapping("/{id}/")
    public CatalogueDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields){

        CatalogueDTO CatalogueDTO = catalogo.findById(id);

        for (Map.Entry<String, Object> field : fields.entrySet()){
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();

            try{
                Field campoEntidad = CatalogueDTO.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(CatalogueDTO, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex){

            }
        } 
        return catalogo.update(id, CatalogueDTO);
    }

}
