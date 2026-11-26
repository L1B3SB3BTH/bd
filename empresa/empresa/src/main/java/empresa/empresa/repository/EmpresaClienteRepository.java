package empresa.empresa.repository;

import empresa.empresa.model.EmpresaClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpresaClienteRepository extends JpaRepository<EmpresaClienteModel, Long> {
    Optional<EmpresaClienteModel> findByRut(String rut);
    Optional<EmpresaClienteModel> findByCodigo(String codigo);
    List<EmpresaClienteModel> findByActivaTrue();
    List<EmpresaClienteModel> findByRazonSocialContainingIgnoreCaseOrNombreFantasiaContainingIgnoreCaseOrRutContainingIgnoreCase(
            String razonSocial, String nombreFantasia, String rut);
}