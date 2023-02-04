package cecy.matriculacion.login.customer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.prerequisite", url = "http://localhost:8001/api/prerequisite")
public interface PrerequisiteClient {

    @GetMapping("/{id}/")
    PrerequisiteDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<PrerequisiteDTO> findAll();

    @PostMapping("/")
    PrerequisiteDTO save(PrerequisiteDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}/")
    PrerequisiteDTO update(@PathVariable("id") Long id, PrerequisiteDTO entity);
}
