package br.edu.ifba.sigpr.model.academico;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "TBL_DISCIPLINA")
public class Disciplina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DISCIPLINA", nullable = false, unique = true)
    private int idDisciplina;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="CURSO", nullable = false)
    @NotNull(message = "O Curso é obrigatório")
    private Curso curso;
    
    @Column(name = "SIGLA_DISCIPLINA", nullable = false, unique = true)
    @NotNull(message = "A sigla da disciplina é obrigatório")
    @Size(min = 6, max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Fora do Padrão")
    private String siglaDisciplina;
    
    @Column(name = "NOME_DISCIPLINA", nullable = false, unique = true)
    @NotNull(message = "O nome da disciplina  é obrigatório")
    @Size(min = 6, max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Fora do Padrão")
    private String nomeDisciplina;
    
    @Column(name = "CARGA_HORARIA", nullable = false, unique = true)
    @NotNull(message = "A carga horária é obrigatório")
    @Min(value = 0, groups = {Integer.class},message = "Fora do Padrão")
    private int cargaHoraria;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="MODALIDADE", nullable = false)
    @NotNull(message = "A modalidade da Disciplina é obrigatória")
    private ModalidadeDisciplina modalidade; //(Estágio, Optativas,Obrigatórias)
    
    @Column(name = "STATUS", nullable = false)
    private boolean status;
    
    //Construtor
    public Disciplina(){
    }
    
    //Construtor Padrão
    public Disciplina(Curso curso, String siglaDisciplina, String nomeDisciplina, int cargaHoraria, ModalidadeDisciplina modalidade, boolean status) {
        this.curso = curso;
        this.siglaDisciplina = siglaDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.modalidade = modalidade;
        this.status = status;
    }
    
    //Setters
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setSiglaDisciplina(String siglaDisciplina) {
        this.siglaDisciplina = siglaDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setModalidade(ModalidadeDisciplina modalidade) {
        this.modalidade = modalidade;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    //Getters
    public int getIdDisciplina() {
        return idDisciplina;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getSiglaDisciplina() {
        return siglaDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public ModalidadeDisciplina getModalidade() {
        return modalidade;
    }

    public boolean isStatus() {
        return status;
    }
    
    //Cria o Equals e HashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idDisciplina;
        hash = 53 * hash + Objects.hashCode(this.curso);
        hash = 53 * hash + Objects.hashCode(this.siglaDisciplina);
        hash = 53 * hash + Objects.hashCode(this.nomeDisciplina);
        hash = 53 * hash + this.cargaHoraria;
        hash = 53 * hash + Objects.hashCode(this.modalidade);
        hash = 53 * hash + (this.status ? 1 : 0);
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
        final Disciplina other = (Disciplina) obj;
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        if (!Objects.equals(this.siglaDisciplina, other.siglaDisciplina)) {
            return false;
        }
        if (!Objects.equals(this.nomeDisciplina, other.nomeDisciplina)) {
            return false;
        }
        if (this.cargaHoraria != other.cargaHoraria) {
            return false;
        }
        if (!Objects.equals(this.modalidade, other.modalidade)) {
            return false;
        }
        return this.status == other.status;
    }
    
    //ToString
    @Override
    public String toString() {
        return "Disciplina{\n"
                + "idDisciplina=" + idDisciplina + ",\n"
                + "curso=" + curso + ",\n"
                + "siglaDisciplina=" + siglaDisciplina + ",\n"
                + "nomeDisciplina=" + nomeDisciplina + ",\n"
                + "cargaHoraria=" + cargaHoraria + ",\n"
                + "modalidade=" + modalidade + ",\n"
                + "status=" + status + '\n'
                +'}';
    }
}
