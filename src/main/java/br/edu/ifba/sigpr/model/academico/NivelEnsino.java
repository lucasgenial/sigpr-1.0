package br.edu.ifba.sigpr.model.academico;

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
@Table(name = "TBL_NIVEL_ENSINO")
public class NivelEnsino implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_NIVEL_ENSINO", nullable = false, unique = true)
    private int idNivelEnsino;
    
    @Column(name = "NOME_NIVEL_ENSINO", nullable = false, unique = true)
    @NotNull(message = "O nome da Nivel de Ensino é obrigatório")
    @Size(min = 6, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Fora do Padrão")
    private String nomeNivelEnsino;
    
    @Column(name = "STATUS", nullable = false)
    private boolean status;
    
    //Construtor
    public NivelEnsino(){
    }
    
    //Construtor
    public NivelEnsino(String nomeNivelEnsino, boolean status) {
        this.nomeNivelEnsino = nomeNivelEnsino;
        this.status = status;
    }
    
    //Setters
    public void setNomeNivelEnsino(String nomeNivelEnsino) {
        this.nomeNivelEnsino = nomeNivelEnsino;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    //Getters
    public int getIdNivelEnsino() {
        return idNivelEnsino;
    }

    public String getNomeNivelEnsino() {
        return nomeNivelEnsino;
    }

    public boolean isStatus() {
        return status;
    }
    
    //Cria o HashCode e Equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.idNivelEnsino;
        hash = 43 * hash + Objects.hashCode(this.nomeNivelEnsino);
        hash = 43 * hash + (this.status ? 1 : 0);
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
        final NivelEnsino other = (NivelEnsino) obj;
        if (this.idNivelEnsino != other.idNivelEnsino) {
            return false;
        }
        if (!Objects.equals(this.nomeNivelEnsino, other.nomeNivelEnsino)) {
            return false;
        }
        return this.status == other.status;
    }
    
    //ToString
    @Override
    public String toString() {
        return "NivelEnsino{\n"
                + "idNivelEnsino=" + idNivelEnsino + ",\n"
                + "nomeNivelEnsino=" + nomeNivelEnsino + ",\n"
                + "status=" + status + '\n'
                +'}';
    }
}
