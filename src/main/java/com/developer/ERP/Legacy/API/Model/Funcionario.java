package com.developer.ERP.Legacy.API.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import static com.developer.ERP.Legacy.API.Messages.FuncionarioMessage.MSG_INFORMATION;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = MSG_INFORMATION)
    private String tipo;
    @NotNull(message = MSG_INFORMATION)
    private String nome;
    private int login;
    @NotNull(message = MSG_INFORMATION)
    private String senha;
    @NotNull(message = MSG_INFORMATION)
    private String email;
    @NotNull(message = MSG_INFORMATION)
    private String cpf;
    @NotNull(message = MSG_INFORMATION)
    private String rg;
    @NotNull(message = MSG_INFORMATION)
    private String carteiraTrabalho;
    @JsonFormat(pattern="dd-MM-yyyy")
    @NotNull(message = MSG_INFORMATION)
    private Date dataContratacao;
    private String telefoneFixo;
    private String celular;
    @NotNull(message = MSG_INFORMATION)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dataNascimento;
    private String observacoes;
    private BigDecimal saldoCaixa;


}
