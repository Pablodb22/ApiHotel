package es.daw.apihotel.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import java.io.Serializable;

@Data
@Validated
public class HotelDto implements Serializable {

    @NotBlank(message = "NO PUEDE SER NULO EL NOMBRE")
    private String nombre;

    @NotBlank(message = "NO PUEDE SER NULO LA DESCRIPCION")
    @Size(max = 10, message = "LA DESCRIPCION NO PUEDE TENER MÁS DE 10 CARACTERES")
    private String descripcion;

    @NotNull(message = "NO PUEDE SER NULO LA CATEGORIA")
    @Max(value = 5, message = "LA CATEGORIA NO PUEDE SER MAYOR A 5")
    @Min(value = 1,message = "LA CATEGORIA NO PUEDE SER MENOR QUE 1")
    private Integer categoria;

    @NotNull(message = "NO PUEDE SER NULO LA PISCINA")
    private Boolean piscina;

    @NotBlank(message = "NO PUEDE SER NULO LA LOCALIDAD")
    private String localidad;
}
