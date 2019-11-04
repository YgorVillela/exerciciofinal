package br.com.fiap.exerciciofinal.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name="prioridade",sequenceName = "sq_prioridade",allocationSize=1)
public class Prioridade {

    @Id
    @GeneratedValue(generator="prioridade",strategy=GenerationType.SEQUENCE)
    private int codigo;

    @NotBlank
    private String nome;

    @NotNull
    private int nivel;

    @NotBlank
    private String descricao;

    @OneToMany(mappedBy="prioridade", cascade = CascadeType.ALL)
    private List<Chamado> chamados;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
