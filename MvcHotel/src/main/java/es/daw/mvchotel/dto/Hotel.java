package es.daw.mvchotel.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private String nombre;


    private String descripcion;


    private Integer categoria;



    private String localidad;
}
