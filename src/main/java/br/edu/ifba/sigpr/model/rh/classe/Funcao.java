package br.edu.ifba.sigpr.model.rh.classe;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBL_FUNCAO")
public class Funcao implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_FUNCAO", nullable = false, unique = true)
    private int idFuncao;
    
    @Column(name = "NOME_NIVEL_ACESSO", nullable = false, unique = true)
    @NotNull(message = "O nome da Nivel de Ensino é obrigatório")
    @Size(min = 6, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Nome da Função Inválida")
    private String nomeFuncao;
    
    @Column(name = "STATUS", nullable = false)
    private boolean status;

    //Construtor
    public Funcao() {
    }
    
    //Construtor Padrão
    public Funcao(String nomeFuncao, boolean status) {
        this.nomeFuncao = nomeFuncao;
        this.status = status;
    }
    
    //Setters
    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    //Getters
    public int getIdFuncao() {
        return idFuncao;
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public boolean isStatus() {
        return status;
    }
    
    //Cria o Hashcode e Equals
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.idFuncao;
        hash = 59 * hash + Objects.hashCode(this.nomeFuncao);
        hash = 59 * hash + (this.status ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcao other = (Funcao) obj;
        if (this.idFuncao != other.idFuncao) {
            return false;
        }
        if (!Objects.equals(this.nomeFuncao, other.nomeFuncao)) {
            return false;
        }
        return this.status == other.status;
    }
    
    //ToString
    @Override
    public String toString() {
        return "Funcao{\n"
                + "idFuncao=" + idFuncao + ",\n"
                + "nomeFuncao=" + nomeFuncao + ",\n"
                + "Status=" + status + '\n'
                +'}';
    }
}