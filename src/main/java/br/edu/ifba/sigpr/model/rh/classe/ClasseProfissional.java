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
@Table(name = "TBL_CLASSE_PROFISSIONAL")
public class ClasseProfissional implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CLASSE_PROFISSIONAL", nullable = false, unique = true)
    private int idClasseProfissional;
    
    @Column(name = "NOME_CLASSE_PROFISSIONAL", nullable = false, unique = true)
    @NotNull(message = "O nome da Nivel de Ensino é obrigatório")
    @Size(min = 6, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Fora do Padrão")
    private String nomeClasseProfissional;
    
    @Column(name = "STATUS", nullable = false)
    private boolean status;

    //Construtor
    public ClasseProfissional() {
    }
    
    //Construtor Padrão
    public ClasseProfissional(String nomeClasseProfissional, boolean status) {
        this.nomeClasseProfissional = nomeClasseProfissional;
        this.status = status;
    }
    
    //Setters
    public void setNomeClasseProfissional(String nomeClasseProfissional) {
        this.nomeClasseProfissional = nomeClasseProfissional;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
        
    //Getters
    public int getIdClasseProfissional() {
        return idClasseProfissional;
    }

    public String getNomeClasseProfissional() {
        return nomeClasseProfissional;
    }

    public boolean isStatus() {
        return status;
    }
    
    //Cria HashCode e Equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idClasseProfissional;
        hash = 97 * hash + Objects.hashCode(this.nomeClasseProfissional);
        hash = 97 * hash + (this.status ? 1 : 0);
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
        final ClasseProfissional other = (ClasseProfissional) obj;
        if (this.idClasseProfissional != other.idClasseProfissional) {
            return false;
        }
        if (!Objects.equals(this.nomeClasseProfissional, other.nomeClasseProfissional)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }
    
    //ToString
    @Override
    public String toString() {
        return "ClasseProfissional{\n"
                + "idClasseProfissional=" + idClasseProfissional + ",\n"
                + "nomeClasseProfissional=" + nomeClasseProfissional + ",\n"
                + "Status=" + status + '\n'
                +'}';
    }
    
}
