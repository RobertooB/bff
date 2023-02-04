package cecy.matriculacion.login.customer.Person.catalogue;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.catalogue", url = "http://localhost:8000/api/catalogo")
public interface CatalogueClient {

    @GetMapping("/{id}/")
    CatalogueDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<CatalogueDTO> findAll();

    @PostMapping("/")
    CatalogueDTO save(CatalogueDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    CatalogueDTO update(@PathVariable("id") Long id, CatalogueDTO entity);
    
}