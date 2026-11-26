package usuario.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioRequestDto {
    private Integer idRol;
    private String rut;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private Boolean activo;

    // Usuario Final
    private Integer idComuna;
    private LocalDate fechaIncorporacion;
    private Boolean avisosActivos;
    private Integer diasAnticipacion;

    // Agente
    private Integer idArea;

    // Ejecutivo
    private Integer idEmpresa;
    private String cargo;
}

