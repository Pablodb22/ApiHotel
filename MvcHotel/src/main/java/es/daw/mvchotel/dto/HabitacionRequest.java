package es.daw.mvchotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitacionRequest {

    private Integer tamano;
    private Integer capacidad;
    private BigDecimal precio;
    private boolean incluyeDesayuno;
    private boolean ocupado;


}
