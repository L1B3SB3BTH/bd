package empresa.empresa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class EmpresaClienteRequestDto {

    private String codigo;
    private String razonSocial;
    private String nombreFantasia;
    private String rut;
    private Integer idRubro;
    private String correoAtencion;
    private String telefonoAtencion;
    private Integer recargoAtraso;
    private Boolean activa;

    public EmpresaClienteRequestDto() {
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public String getNombreFantasia() { return nombreFantasia; }
    public void setNombreFantasia(String nombreFantasia) { this.nombreFantasia = nombreFantasia; }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public Integer getIdRubro() { return idRubro; }
    public void setIdRubro(Integer idRubro) { this.idRubro = idRubro; }

    public String getCorreoAtencion() { return correoAtencion; }
    public void setCorreoAtencion(String correoAtencion) { this.correoAtencion = correoAtencion; }

    public String getTelefonoAtencion() { return telefonoAtencion; }
    public void setTelefonoAtencion(String telefonoAtencion) { this.telefonoAtencion = telefonoAtencion; }

    public Integer getRecargoAtraso() { return recargoAtraso; }
    public void setRecargoAtraso(Integer recargoAtraso) { this.recargoAtraso = recargoAtraso; }

    public Boolean getActiva() { return activa; }
    public void setActiva(Boolean activa) { this.activa = activa; }
}

