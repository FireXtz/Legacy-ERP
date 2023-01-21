package com.developer.ERP.Legacy.API.domain.Model;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany
    @JoinColumn(name = "departamentos_id")
    private Set<Departamentos> departamentos;

    public Setor(Long id, String nome, Set<Departamentos> departamentos) {
        this.id = id;
        this.nome = nome;
        this.departamentos = departamentos;
    }

    public Setor() {
        super();

    }
    public boolean desassociar(Departamentos departamentos){
        return informationDepartamentos().remove(departamentos);
    }
    public boolean associar(Departamentos departamentos){
        return informationDepartamentos().add(departamentos);
    }
    public Set<Departamentos> informationDepartamentos() {
        return departamentos;
    }


}
