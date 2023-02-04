package cecy.matriculacion.login.customer.asistencia.catalogoAsistencia;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.catalogoAsistencia", url = "http://localhost:8085/api/catalogoAsistencia")
public interface CatalogoAsistenciaClient {

    @GetMapping("/{id}/")
    CatalogoAsistenciaDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<CatalogoAsistenciaDTO> findAll();

    @PostMapping("/")
    CatalogoAsistenciaDTO save(CatalogoAsistenciaDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    CatalogoAsistenciaDTO update(@PathVariable("id") Long id, CatalogoAsistenciaDTO entity);
}
