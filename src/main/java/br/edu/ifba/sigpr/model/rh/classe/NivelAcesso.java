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
@Table(name = "TBL_NIVEL_ACESSO")
public class NivelAcesso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_NIVEL_ACESSO", nullable = false, unique = true)
    private int idNivelAcesso;
    
    @Column(name = "NOME_NIVEL_ACESSO", nullable = false, unique = true)
    @NotNull(message = "O nome da Nivel de Ensino é obrigatório")
    @Size(min = 6, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Fora do Padrão")
    private String nomeNivelAcesso;
    
    @Column(name = "STATUS", nullable = false)
    private boolean status;
    
    //Construtor
    public NivelAcesso() {
    }
    
    //Construtor Padrão
    public NivelAcesso(String nomeNivelAcesso, boolean status) {
        this.nomeNivelAcesso = nomeNivelAcesso;
        this.status = status;
    }
    
    //Setters
    public void setNomeNivelAcesso(String nomeNivelAcesso) {
        this.nomeNivelAcesso = nomeNivelAcesso;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    //Getters
    public int getIdNivelAcesso() {
        return idNivelAcesso;
    }

    public String getNomeNivelAcesso() {
        return nomeNivelAcesso;
    }

    public boolean isStatus() {
        return status;
    }
    
    //Cria HashCode e Equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idNivelAcesso;
        hash = 71 * hash + Objects.hashCode(this.nomeNivelAcesso);
        hash = 71 * hash + (this.status ? 1 : 0);
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
        final NivelAcesso other = (NivelAcesso) obj;
        if (this.idNivelAcesso != other.idNivelAcesso) {
            return false;
        }
        if (!Objects.equals(this.nomeNivelAcesso, other.nomeNivelAcesso)) {
            return false;
        }
        return this.status == other.status;
    }
    
    //ToString
    @Override
    public String toString() {
        return "NivelAcesso{\n"
                + "idNivelAcesso=" + idNivelAcesso + ",\n"
                + "nomeNivelAcesso=" + nomeNivelAcesso + ",\n"
                + "status=" + status + '\n'
                +'}';
    }
}
