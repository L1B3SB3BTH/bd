package usuario.usuario.repository;

import usuario.usuario.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByRut(String rut);
    Optional<UsuarioModel> findByCorreo(String correo);
    List<UsuarioModel> findByRolId(Integer idRol);
    List<UsuarioModel> findByIdEmpresa(Integer idEmpresa);
    List<UsuarioModel> findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrRutContainingIgnoreCase(
            String nombres, String apellidos, String rut);
}