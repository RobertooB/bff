package cecy.matriculacion.login.customer.Formulario.formInscription;

import cecy.matriculacion.login.customer.Formulario.catalogueForm.CatalogueFormDTO;
import lombok.Data;

@Data
public class FormInscriptionDTO {
    private Long id;
    private boolean sponsoredCourse;
    private String institutionContact;

    // foreign key api_person
    private Long userId;

    // foreign key courses
    private Long courseId;

    private Long otherCourses;

    private String state;

    // foreign key catalogue
    private CatalogueFormDTO publicity;
}
