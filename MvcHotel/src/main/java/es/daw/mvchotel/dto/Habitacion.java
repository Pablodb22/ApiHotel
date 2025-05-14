package es.daw.mvchotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {
    private Integer id;
    private String nombreHotel;
    private Integer tamano;
    private Integer capacidad;
    private BigDecimal precioNoche;
    private Boolean incluyeDesayuno;
    private Boolean ocupada;

}
