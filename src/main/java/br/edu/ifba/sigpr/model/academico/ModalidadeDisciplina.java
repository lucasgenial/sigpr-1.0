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
@Table(name = "TBL_MODALIDADE_DISCIPLINA")
public class ModalidadeDisciplina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_MODALIDADE_DISCIPLINA", nullable = false, unique = true)
    private int idModalidadeDisciplina;
    
    @Column(name = "SIGLA_DISCIPLINA", nullable = false, unique = true)
    @NotNull(message = "O nome da Modalidade é obrigatório")
    @Size(min = 6, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Fora do Padrão")
    private String nomeMadalidadeDisciplina; //(Estágio, Optativas,Obrigatórias)
    
    @Column(name = "STATUS", nullable = false)
    private boolean status;
    
    //Construtor
    public ModalidadeDisciplina(){
    }
    
    //Construtor
    public ModalidadeDisciplina(String nomeMadalidadeDisciplina, boolean status) {
        this.nomeMadalidadeDisciplina = nomeMadalidadeDisciplina;
        this.status = status;
    }
    
    //Setters
    public void setNomeMadalidadeDisciplina(String nomeMadalidadeDisciplina) {
        this.nomeMadalidadeDisciplina = nomeMadalidadeDisciplina;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    //Getters
    public int getIdModalidadeDisciplina() {
        return idModalidadeDisciplina;
    }

    public String getNomeMadalidadeDisciplina() {
        return nomeMadalidadeDisciplina;
    }

    public boolean isStatus() {
        return status;
    }
    
    //Cria o Equals e HashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idModalidadeDisciplina;
        hash = 89 * hash + Objects.hashCode(this.nomeMadalidadeDisciplina);
        hash = 89 * hash + (this.status ? 1 : 0);
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
        final ModalidadeDisciplina other = (ModalidadeDisciplina) obj;
        if (this.idModalidadeDisciplina != other.idModalidadeDisciplina) {
            return false;
        }
        if (!Objects.equals(this.nomeMadalidadeDisciplina, other.nomeMadalidadeDisciplina)) {
            return false;
        }
        return this.status == other.status;
    }
    
    //ToString
    @Override
    public String toString() {
        return "ModalidadeDisciplina{\n"
                + "idModalidadeDisciplina=" + idModalidadeDisciplina + ",\n"
                + "nomeMadalidadeDisciplina=" + nomeMadalidadeDisciplina + ",\n"
                + "status=" + status + '\n'
                +'}';
    }   
}
