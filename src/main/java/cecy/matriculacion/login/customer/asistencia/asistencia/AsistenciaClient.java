package cecy.matriculacion.login.customer.asistencia.asistencia;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.asistencia", url = "http://localhost:8085/api/asistencia")
public interface AsistenciaClient {

    @GetMapping("/{id}/")
    AsistenciaDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<AsistenciaDTO> findAll();

    @PostMapping("/")
    AsistenciaDTO save(AsistenciaDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    AsistenciaDTO update(@PathVariable("id") Long id, AsistenciaDTO entity);
}
