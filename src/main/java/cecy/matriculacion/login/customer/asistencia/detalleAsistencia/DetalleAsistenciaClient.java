package cecy.matriculacion.login.customer.asistencia.detalleAsistencia;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.detalleAsistencia", url = "http://localhost:8085/api/detalleAsistencia")
public interface DetalleAsistenciaClient {

    @GetMapping("/{id}/")
    DetalleAsistenciaDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<DetalleAsistenciaDTO> findAll();

    @PostMapping("/")
    DetalleAsistenciaDTO save(DetalleAsistenciaDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    DetalleAsistenciaDTO update(@PathVariable("id") Long id, DetalleAsistenciaDTO entity);
}
