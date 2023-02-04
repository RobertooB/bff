package cecy.matriculacion.login.customer.Formulario.formInscription;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.formInscripcion", url = "http://localhost:8082/api/formInscription")
public interface FormInscriptionClient {

    @GetMapping("/{id}/")
    FormInscriptionDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<FormInscriptionDTO> findAll();

    @PostMapping("/")
    FormInscriptionDTO save(FormInscriptionDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    FormInscriptionDTO update(@PathVariable("id") Long id, FormInscriptionDTO entity);
}
