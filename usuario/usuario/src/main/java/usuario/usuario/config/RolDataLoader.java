package usuario.usuario.config;

import usuario.usuario.model.RolModel;
import usuario.usuario.repository.RolRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RolDataLoader implements CommandLineRunner {

    private final RolRepository rolRepository;

    @Override
    public void run(String... args) {
        if (rolRepository.count() == 0) {
            List<RolModel> rolesIniciales = List.of(
                    RolModel.builder()
                            .codigo("USUARIO_FINAL")
                            .nombre("Usuario Final")
                            .descripcion("Cliente o usuario estándar de la aplicación")
                            .build(),
                    RolModel.builder()
                            .codigo("AGENTE")
                            .nombre("Agente")
                            .descripcion("Agente encargado de gestionar atenciones y solicitudes")
                            .build(),
                    RolModel.builder()
                            .codigo("EJECUTIVO")
                            .nombre("Ejecutivo")
                            .descripcion("Ejecutivo con permisos de supervisión y administración")
                            .build()
            );
            rolRepository.saveAll(rolesIniciales);
        }
    }
}