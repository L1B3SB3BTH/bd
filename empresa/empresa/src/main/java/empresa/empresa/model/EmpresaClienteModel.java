package empresa.empresa.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empresas_clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresaClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long id;

    @Column(name = "codigo", nullable = false, unique = true, length = 10)
    private String codigo;

    @Column(name = "razon_social", nullable = false, length = 120)
    private String razonSocial;

    @Column(name = "nombre_fantasia", length = 80)
    private String nombreFantasia;

    @Column(name = "rut", nullable = false, unique = true, length = 12)
    private String rut;

    @Column(name = "id_rubro", nullable = false)
    private Integer idRubro;

    @Column(name = "correo_atencion", length = 120)
    private String correoAtencion;

    @Column(name = "telefono_atencion", length = 20)
    private String telefonoAtencion;

    @Column(name = "recargo_atraso")
    private Integer recargoAtraso;

    @Column(name = "activa", nullable = false)
    private Boolean activa;
}