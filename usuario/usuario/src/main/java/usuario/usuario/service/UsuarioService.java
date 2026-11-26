package usuario.usuario.service;
import usuario.usuario.dto.UsuarioRequestDto;
import usuario.usuario.dto.UsuarioResponseDto;
import usuario.usuario.model.RolModel;
import usuario.usuario.model.UsuarioModel;
import usuario.usuario.repository.RolRepository;
import usuario.usuario.repository.UsuarioRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public List<UsuarioResponseDto> listar(String buscar) {
        List<UsuarioModel> usuarios = (buscar != null && !buscar.isBlank())
                ? usuarioRepository.findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrRutContainingIgnoreCase(
                        buscar, buscar, buscar)
                : usuarioRepository.findAll();

        return usuarios.stream()
                .map(this::toResponse)
                .toList();
    }

    public UsuarioResponseDto obtener(Long id) {
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        return toResponse(usuario);
    }

    public UsuarioResponseDto obtenerPorRut(String rut) {
        UsuarioModel usuario = usuarioRepository.findByRut(rut)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado con RUT: " + rut));
        return toResponse(usuario);
    }

    public UsuarioResponseDto obtenerPorCorreo(String correo) {
        UsuarioModel usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado con correo: " + correo));
        return toResponse(usuario);
    }

    public UsuarioResponseDto registrar(UsuarioRequestDto datos) {
        RolModel rol = rolRepository.findById(datos.getIdRol())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "El rol indicado no existe"));

        UsuarioModel usuario = UsuarioModel.builder()
                .rol(rol)
                .rut(datos.getRut())
                .nombres(datos.getNombres())
                .apellidos(datos.getApellidos())
                .correo(datos.getCorreo())
                .telefono(datos.getTelefono())
                .activo(datos.getActivo() != null ? datos.getActivo() : true)
                .idComuna(datos.getIdComuna())
                .fechaIncorporacion(datos.getFechaIncorporacion())
                .avisosActivos(datos.getAvisosActivos())
                .diasAnticipacion(datos.getDiasAnticipacion())
                .idArea(datos.getIdArea())
                .idEmpresa(datos.getIdEmpresa())
                .cargo(datos.getCargo())
                .build();

        return toResponse(usuarioRepository.save(usuario));
    }

    public UsuarioResponseDto actualizar(Long id, UsuarioRequestDto datos) {
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        if (datos.getIdRol() != null) {
            RolModel rol = rolRepository.findById(datos.getIdRol())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "El rol indicado no existe"));
            usuario.setRol(rol);
        }

        usuario.setRut(datos.getRut());
        usuario.setNombres(datos.getNombres());
        usuario.setApellidos(datos.getApellidos());
        usuario.setCorreo(datos.getCorreo());
        usuario.setTelefono(datos.getTelefono());
        if (datos.getActivo() != null) {
            usuario.setActivo(datos.getActivo());
        }
        usuario.setIdComuna(datos.getIdComuna());
        usuario.setFechaIncorporacion(datos.getFechaIncorporacion());
        usuario.setAvisosActivos(datos.getAvisosActivos());
        usuario.setDiasAnticipacion(datos.getDiasAnticipacion());
        usuario.setIdArea(datos.getIdArea());
        usuario.setIdEmpresa(datos.getIdEmpresa());
        usuario.setCargo(datos.getCargo());

        return toResponse(usuarioRepository.save(usuario));
    }

    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    private UsuarioResponseDto toResponse(UsuarioModel u) {
        return UsuarioResponseDto.builder()
                .id(u.getId())
                .idRol(u.getRol() != null ? u.getRol().getId() : null)
                .nombreRol(u.getRol() != null ? u.getRol().getNombre() : null)
                .rut(u.getRut())
                .nombres(u.getNombres())
                .apellidos(u.getApellidos())
                .correo(u.getCorreo())
                .telefono(u.getTelefono())
                .activo(u.getActivo())
                .fechaCreacion(u.getFechaCreacion())
                .idComuna(u.getIdComuna())
                .fechaIncorporacion(u.getFechaIncorporacion())
                .avisosActivos(u.getAvisosActivos())
                .diasAnticipacion(u.getDiasAnticipacion())
                .idArea(u.getIdArea())
                .idEmpresa(u.getIdEmpresa())
                .cargo(u.getCargo())
                .build();
    }
}