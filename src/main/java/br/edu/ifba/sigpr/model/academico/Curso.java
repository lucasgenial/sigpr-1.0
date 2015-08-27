package br.edu.ifba.sigpr.model.academico;

import br.edu.ifba.sigpr.model.rh.Servidor;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "TBL_CURSO")
public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_FUNCAO", nullable = false, unique = true)
    private int idCurso;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="COORDENADOR", nullable = false)
    @NotNull(message = "O Coodernador é obrigatório")
    private Servidor coordenador;
    
    @Column(name = "NOME_CURSO", nullable = false, unique = true)
    @NotNull(message = "O nome do curso é obrigatório")
    @NotEmpty(message = "O campo Nome Curso não deve ficar em branco.")
    private String nomeCurso;
    
    @Column(name = "CARGA_HORARIA", nullable = false, unique = true)
    @NotNull(message = "A carga horaria é obrigatória")
    @Min(value = 0, groups = {Integer.class},message = "Fora do Padrão")
    private int cargaHoraria;
    
    @Column(name = "STATUS", nullable = false)
    private boolean status; //(ativo, inativo)
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="NIVEL_ENSINO", nullable = false)
    @NotNull(message = "O nivel de ensino é obrigatório")
    private NivelEnsino nivelDeEnsino; //(fundamental, médio, superior)
    
    @Column(name = "NUMERO_PERIODOS", nullable = false, unique = true)
    @NotNull(message = "O nº de periodos é obrigatório")
    private int numeroPeriodos;
    
    @Column(name = "PERIODICIDADE", nullable = false, unique = true)
    @NotNull(message = "A periodicidade é obrigratória")
    private String Periodicidade; //(diário, semanal, semestral, Anual)
    
    //Construtor
    public Curso() {
    }
    
    //Construtor Completo
    /**
     * @param coordenador
     * @param nomeCurso
     * @param cargaHoraria
     * @param status
     * @param nivelDeEnsino
     * @param numeroPeriodos
     * @param Periodicidade
     */
        public Curso(Servidor coordenador, String nomeCurso, int cargaHoraria, boolean status,
            NivelEnsino nivelDeEnsino, int numeroPeriodos, String Periodicidade) {
        this.coordenador = coordenador;
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
        this.nivelDeEnsino = nivelDeEnsino;
        this.numeroPeriodos = numeroPeriodos;
        this.Periodicidade = Periodicidade;
    }
    
    //Setters
    public void setCoordenador(Servidor coordenador) {
        this.coordenador = coordenador;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setNivelDeEnsino(NivelEnsino nivelDeEnsino) {
        this.nivelDeEnsino = nivelDeEnsino;
    }

    public void setNumeroPeriodos(int numeroPeriodos) {
        this.numeroPeriodos = numeroPeriodos;
    }

    public void setPeriodicidade(String Periodicidade) {
        this.Periodicidade = Periodicidade;
    }
    
    //Getters
    public int getIdCurso() {
        return idCurso;
    }

    public Servidor getCoordenador() {
        return coordenador;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public boolean isStatus() {
        return status;
    }

    public NivelEnsino getNivelDeEnsino() {
        return nivelDeEnsino;
    }

    public int getNumeroPeriodos() {
        return numeroPeriodos;
    }

    public String getPeriodicidade() {
        return Periodicidade;
    }
    
    //Cria o Equals e HashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idCurso;
        hash = 53 * hash + Objects.hashCode(this.coordenador);
        hash = 53 * hash + Objects.hashCode(this.nomeCurso);
        hash = 53 * hash + this.cargaHoraria;
        hash = 53 * hash + (this.status ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.nivelDeEnsino);
        hash = 53 * hash + this.numeroPeriodos;
        hash = 53 * hash + Objects.hashCode(this.Periodicidade);
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
        final Curso other = (Curso) obj;
        if (this.idCurso != other.idCurso) {
            return false;
        }
        if (!Objects.equals(this.coordenador, other.coordenador)) {
            return false;
        }
        if (!Objects.equals(this.nomeCurso, other.nomeCurso)) {
            return false;
        }
        if (this.cargaHoraria != other.cargaHoraria) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.nivelDeEnsino, other.nivelDeEnsino)) {
            return false;
        }
        if (this.numeroPeriodos != other.numeroPeriodos) {
            return false;
        }
        return Objects.equals(this.Periodicidade, other.Periodicidade);
    }
    
    //ToString
    @Override
    public String toString() {
        return "Curso{\n"
                + "idCurso=" + idCurso + ",\n"
                + "coordenador=" + coordenador + ",\n"
                + "nomeCurso=" + nomeCurso + ",\n"
                + "cargaHoraria=" + cargaHoraria + ",\n"
                + "status=" + status + ",\n"
                + "nivelDeEnsino=" + nivelDeEnsino + ",\n"
                + "numeroPeriodos=" + numeroPeriodos + ",\n"
                + "Periodicidade=" + Periodicidade + '\n'
                +'}';
    } 
}