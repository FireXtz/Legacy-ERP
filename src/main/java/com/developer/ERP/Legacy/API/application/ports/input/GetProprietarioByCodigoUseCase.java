package com.developer.ERP.Legacy.API.application.ports.input;

import com.developer.ERP.Legacy.API.domain.model.Proprietario;

public interface GetProprietarioByCodigoUseCase {
    Proprietario getProprietarioByCodigo(Long codigo);
}
