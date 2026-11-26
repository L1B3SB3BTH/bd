package empresa.empresa.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresaClienteResponseDto {
    private Long id;
    private String codigo;
    private String razonSocial;
    private String nombreFantasia;
    private String rut;
    private Integer idRubro;
    private String correoAtencion;
    private String telefonoAtencion;
    private Integer recargoAtraso;
    private Boolean activa;
}
