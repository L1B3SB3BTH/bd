package empresa.empresa.controller;

import empresa.empresa.dto.EmpresaClienteRequestDto;
import empresa.empresa.dto.EmpresaClienteResponseDto;
import empresa.empresa.service.EmpresaClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
public class EmpresaClienteController {

    private final EmpresaClienteService empresaClienteService;

    @GetMapping
    public List<EmpresaClienteResponseDto> listar(@RequestParam(required = false) String buscar) {
        return empresaClienteService.listar(buscar);
    }

    @GetMapping("/{id}")
    public EmpresaClienteResponseDto obtener(@PathVariable Long id) {
        return empresaClienteService.obtener(id);
    }

    @GetMapping("/rut/{rut}")
    public EmpresaClienteResponseDto obtenerPorRut(@PathVariable String rut) {
        return empresaClienteService.obtenerPorRut(rut);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaClienteResponseDto registrar(@RequestBody EmpresaClienteRequestDto datos) {
        return empresaClienteService.registrar(datos);
    }

    @PostMapping("/migrar")
    @ResponseStatus(HttpStatus.CREATED)
    public List<EmpresaClienteResponseDto> migrarLote(@RequestBody List<EmpresaClienteRequestDto> listaDatos) {
        return empresaClienteService.migrarLote(listaDatos);
    }

    @PutMapping("/{id}")
    public EmpresaClienteResponseDto actualizar(@PathVariable Long id, @RequestBody EmpresaClienteRequestDto datos) {
        return empresaClienteService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        empresaClienteService.eliminar(id);
    }
}