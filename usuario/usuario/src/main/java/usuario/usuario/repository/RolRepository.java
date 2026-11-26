package usuario.usuario.repository;

import usuario.usuario.model.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<RolModel, Integer> {
    Optional<RolModel> findByCodigo(String codigo);
}