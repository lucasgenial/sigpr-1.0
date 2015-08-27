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
@Table(name = "TBL_NIVEL_PROFISSIONAL")
public class NivelProfissional implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_NIVEL_PROFISSIONAL", nullable = false, unique = true)
    private int idNivelProfissional;
    
    @Column(name = "NOME_NIVEL", nullable = false, unique = true)
    @NotNull(message = "O nome da Nivel de Ensino é obrigatório")
    @Size(min = 6, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Fora do Padrão")
    private String nomeNivelProfissional;
    
    @Column(name = "STATUS", nullable = false)
    private boolean status;
    
    
    //Construtor Default
    public NivelProfissional() {
    }
    
    //Construtor Padrão
    public NivelProfissional(String nomeNivelProfissional, boolean status) {
        this.nomeNivelProfissional = nomeNivelProfissional;
        this.status = status;
    }
    
    //Setters
    public void setNomeNivelProfissional(String nomeNivelProfissional) {
        this.nomeNivelProfissional = nomeNivelProfissional;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void setIdNivelProfissional(int numero) {
        this.idNivelProfissional = numero;
    }
    
    //Getters
    public int getIdNivelProfissional() {
        return idNivelProfissional;
    }

    public String getNomeNivelProfissional() {
        return nomeNivelProfissional;
    }

    public boolean isStatus() {
        return status;
    }
    
    //Cria O HashCode e Equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idNivelProfissional;
        hash = 67 * hash + Objects.hashCode(this.nomeNivelProfissional);
        hash = 67 * hash + (this.status ? 1 : 0);
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
        final NivelProfissional other = (NivelProfissional) obj;
        if (this.idNivelProfissional != other.idNivelProfissional) {
            return false;
        }
        if (!Objects.equals(this.nomeNivelProfissional, other.nomeNivelProfissional)) {
            return false;
        }
        return this.status == other.status;
    }
    
    //ToString
    @Override
    public String toString() {
        return "NivelProfissional{\n"
                + "idNivelProfissional=" + idNivelProfissional + ",\n"
                + "nomeNivelProfissional=" + nomeNivelProfissional + ",\n"
                + "status=" + status + '\n'
                +'}';
    }
}
