package cecy.matriculacion.login.customer.Formulario.catalogueForm;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.catalogueForm", url = "http://localhost:8082/api/catalogue")
public interface CatalogueFormClient {

    @GetMapping("/{id}/")
    CatalogueFormDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<CatalogueFormDTO> findAll();

    @PostMapping("/")
    CatalogueFormDTO save(CatalogueFormDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    CatalogueFormDTO update(@PathVariable("id") Long id, CatalogueFormDTO entity);
}
