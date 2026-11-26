package usuario.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponseDto {
    private Long id;
    private Integer idRol;
    private String nombreRol;
    private String rut;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private Boolean activo;
    private LocalDateTime fechaCreacion;

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