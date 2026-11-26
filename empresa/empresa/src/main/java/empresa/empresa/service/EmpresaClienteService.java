package empresa.empresa.service;

import empresa.empresa.dto.EmpresaClienteRequestDto;
import empresa.empresa.dto.EmpresaClienteResponseDto;
import empresa.empresa.model.EmpresaClienteModel;
import empresa.empresa.repository.EmpresaClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmpresaClienteService {

    private final EmpresaClienteRepository empresaClienteRepository;

    public List<EmpresaClienteResponseDto> listar(String buscar) {
        List<EmpresaClienteModel> empresas = (buscar != null && !buscar.isBlank())
                ? empresaClienteRepository
                        .findByRazonSocialContainingIgnoreCaseOrNombreFantasiaContainingIgnoreCaseOrRutContainingIgnoreCase(
                                buscar, buscar, buscar)
                : empresaClienteRepository.findAll();

        return empresas.stream()
                .map(this::toResponse)
                .toList();
    }

    public EmpresaClienteResponseDto obtener(Long id) {
        EmpresaClienteModel empresa = empresaClienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa no encontrada"));
        return toResponse(empresa);
    }

    public EmpresaClienteResponseDto obtenerPorRut(String rut) {
        EmpresaClienteModel empresa = empresaClienteRepository.findByRut(rut)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa no encontrada con RUT: " + rut));
        return toResponse(empresa);
    }

    public EmpresaClienteResponseDto registrar(EmpresaClienteRequestDto datos) {
        EmpresaClienteModel empresa = toEntity(datos);
        return toResponse(empresaClienteRepository.save(empresa));
    }

    public List<EmpresaClienteResponseDto> migrarLote(List<EmpresaClienteRequestDto> listaDatos) {
        List<EmpresaClienteModel> entidades = listaDatos.stream()
                .map(this::toEntity)
                .toList();
        return empresaClienteRepository.saveAll(entidades).stream()
                .map(this::toResponse)
                .toList();
    }

    public EmpresaClienteResponseDto actualizar(Long id, EmpresaClienteRequestDto datos) {
        EmpresaClienteModel empresa = empresaClienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa no encontrada"));

        empresa.setCodigo(datos.getCodigo());
        empresa.setRazonSocial(datos.getRazonSocial());
        empresa.setNombreFantasia(datos.getNombreFantasia());
        empresa.setRut(datos.getRut());
        empresa.setIdRubro(datos.getIdRubro());
        empresa.setCorreoAtencion(datos.getCorreoAtencion());
        empresa.setTelefonoAtencion(datos.getTelefonoAtencion());
        empresa.setRecargoAtraso(datos.getRecargoAtraso());
        if (datos.getActiva() != null) {
            empresa.setActiva(datos.getActiva());
        }

        return toResponse(empresaClienteRepository.save(empresa));
    }

    public void eliminar(Long id) {
        if (!empresaClienteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa no encontrada");
        }
        empresaClienteRepository.deleteById(id);
    }

    private EmpresaClienteModel toEntity(EmpresaClienteRequestDto datos) {
        return EmpresaClienteModel.builder()
                .codigo(datos.getCodigo())
                .razonSocial(datos.getRazonSocial())
                .nombreFantasia(datos.getNombreFantasia())
                .rut(datos.getRut())
                .idRubro(datos.getIdRubro())
                .correoAtencion(datos.getCorreoAtencion())
                .telefonoAtencion(datos.getTelefonoAtencion())
                .recargoAtraso(datos.getRecargoAtraso() != null ? datos.getRecargoAtraso() : 0)
                .activa(datos.getActiva() != null ? datos.getActiva() : true)
                .build();
    }

    private EmpresaClienteResponseDto toResponse(EmpresaClienteModel empresa) {
        return EmpresaClienteResponseDto.builder()
                .id(empresa.getId())
                .codigo(empresa.getCodigo())
                .razonSocial(empresa.getRazonSocial())
                .nombreFantasia(empresa.getNombreFantasia())
                .rut(empresa.getRut())
                .idRubro(empresa.getIdRubro())
                .correoAtencion(empresa.getCorreoAtencion())
                .telefonoAtencion(empresa.getTelefonoAtencion())
                .recargoAtraso(empresa.getRecargoAtraso())
                .activa(empresa.getActiva())
                .build();
    }
}