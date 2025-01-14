package com.developer.ERP.Legacy.API.infrastructure.adapters.input.rest.adapt;

import com.developer.ERP.Legacy.API.application.ports.input.*;
import com.developer.ERP.Legacy.API.domain.model.Proprietario;
import com.developer.ERP.Legacy.API.infrastructure.adapters.input.rest.request.ProprietarioRequest;
import com.developer.ERP.Legacy.API.infrastructure.adapters.input.rest.response.ProprietarioResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProprietarioRestAdapter {

    private final CreateProprietarioUseCase createProprietarioUseCase;

    private final GetProprietarioByCodigoUseCase getProprietarioUseCase;

    private final GetProprietariosUseCase getProprietariosUseCase;

    private final GetProprietariosPorProfissaoUseCase getProprietariosPorProfissaoUseCase;

    private final GetProprietarioPorNomeUseCase getProprietarioPorNomeUseCase;

    private final GetProprietariosPorCpfUseCase getProprietariosPorCpfUseCase;

    private final UpdateProprietarioUseCase updateProprietarioUseCase;

    private final ModelMapper mapper;

    @PostMapping(value = "/proprietarios/cadastrar",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProprietarioResponse> createProprietario(@RequestBody ProprietarioRequest proprietarioRequest) {
        Proprietario proprietario = mapper.map(proprietarioRequest, Proprietario.class);
        proprietario = createProprietarioUseCase.createProprietario(proprietario);

        return new ResponseEntity<>(mapper.map(proprietario,ProprietarioResponse.class), HttpStatus.CREATED);
    }

    @PutMapping(value = "/proprietarios/editar/{codigo}")
    public ResponseEntity<ProprietarioResponse> updatePropritario(@RequestBody ProprietarioRequest proprietarioRequest, @PathVariable Long codigo){
        Proprietario proprietario = mapper.map(proprietarioRequest , Proprietario.class);
        proprietario.setCodigo(codigo);

        proprietario = updateProprietarioUseCase.updateProprietario(proprietario);
        return new ResponseEntity<>(mapper.map(proprietario, ProprietarioResponse.class), HttpStatus.OK);
    }

    @GetMapping("/proprietarios/consultar-por/cpf")
    public ResponseEntity<ProprietarioResponse> getProprietarioPorCpf(@RequestParam String cpf) {
        Proprietario proprietario = getProprietariosPorCpfUseCase.consultarProprietarioPorCpf(cpf);
        return new ResponseEntity<>(mapper.map(proprietario, ProprietarioResponse.class), HttpStatus.OK);
    }

    @GetMapping(value = "/proprietarios/{codigo}")
    public ResponseEntity<ProprietarioResponse> getProprietarioByCodigo(@PathVariable Long codigo) {
        Proprietario proprietario = getProprietarioUseCase.getProprietarioByCodigo(codigo);

        return new ResponseEntity<>(mapper.map(proprietario, ProprietarioResponse.class),HttpStatus.OK);
    }

    @GetMapping(value = "/proprietarios/listar-proprietarios", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProprietarioResponse>> getProprietarios() {

        List<Proprietario> proprietarios = getProprietariosUseCase.getProprietarios();
        List<ProprietarioResponse> responses = new ArrayList<>();

        for (Proprietario proprietario : proprietarios) {
            responses.add(mapper.map(proprietario, ProprietarioResponse.class));
        }
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }
}
