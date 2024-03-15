package com.developer.ERP.Legacy.API.infrastructure.adapters.input.rest.request;

import com.developer.ERP.Legacy.API.domain.enums.Nacionalidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProprietarioRequest {
    @NotBlank(message = "Nome é um campo obrigatório")
    private String nome;

    @NotBlank(message = "CPF é um campo obrigatório")
    private String cpf;

    @NotBlank(message = "gerenciado por é um campo obrigátorio")
    private String gerenciadoPor;

    @NotBlank(message = "RG por é um campo obrigátorio")
    private String rg;

    @NotBlank(message = "data de nascimento é um campo obrigátorio")
    private String dataNascimento;

    @NotBlank(message = "Profissão é um campo obrigátorio")
    private String profissao;

    @NotBlank(message = "Natural é um campo obrigátorio")
    private String natura;

    @NotBlank(message = "Nacionalidade é um campo obrigátorio")
    private Nacionalidade nacionalidade;

    private HonorarioRequest honorario;
}