package br.edu.ifba.sigpr.model.rh.classe;

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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBL_DADOS_PROFISSIONAL")
public class DadosProfissional implements Serializable {

    //Chave estrangeira da tabela Servidor

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DADOS_PROFISSIONAL", nullable = false, unique = true)
    private int idDadosProfissional;

    @Column(name = "MATRICULA", nullable = false, unique = true)
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Nome cidade inválido")
    private String matricula;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASSE", nullable = false)
    private ClasseProfissional classe;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NIVEL", nullable = false)
    private NivelProfissional nivel;

    @Column(name = "REGIME_TRABALHO", nullable = false, unique = true)
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Regime de Trabalho inválido")
    private String regimeTrabalho;

    @Column(name = "CARGA_HORARIA", nullable = false, unique = true)
    @Min(value = 0, groups = {Integer.class},message = "Nº inválido")
    private int cargaHoraria;

    public DadosProfissional() {
    }

    //Construtor Padrao
    public DadosProfissional(int idDadosProfissional) {
        this.idDadosProfissional = idDadosProfissional;
    }

    //Construtor Completo
    public DadosProfissional(int idDadosProfissional, String matricula, ClasseProfissional classe, NivelProfissional nivel, String regimeTrabalho, int cargaHoraria) {
        this.idDadosProfissional = idDadosProfissional;
        this.matricula = matricula;
        this.classe = classe;
        this.nivel = nivel;
        this.regimeTrabalho = regimeTrabalho;
        this.cargaHoraria = cargaHoraria;
    }

    //Setters
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setIdDadosProfissional(int idDadosProfissional) {
        this.idDadosProfissional = idDadosProfissional;
    }

    public void setClasse(ClasseProfissional classe) {
        this.classe = classe;
    }

    public void setNivel(NivelProfissional nivel) {
        this.nivel = nivel;
    }

    public void setRegimeTrabalho(String regimeTrabalho) {
        this.regimeTrabalho = regimeTrabalho;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    //Getters
    public String getMatricula() {
        return matricula;
    }

    public int getIdDadosProfissional() {
        return idDadosProfissional;
    }

    public ClasseProfissional getClasse() {
        return classe;
    }

    public NivelProfissional getNivel() {
        return nivel;
    }

    public String getRegimeTrabalho() {
        return regimeTrabalho;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    //Cria o HashCode e Equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idDadosProfissional;
        hash = 67 * hash + Objects.hashCode(this.matricula);
        hash = 67 * hash + Objects.hashCode(this.classe);
        hash = 67 * hash + Objects.hashCode(this.nivel);
        hash = 67 * hash + Objects.hashCode(this.regimeTrabalho);
        hash = 67 * hash + this.cargaHoraria;
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
        final DadosProfissional other = (DadosProfissional) obj;
        if (this.idDadosProfissional != other.idDadosProfissional) {
            return false;
        }
        if (!Objects.equals(this.classe, other.classe)) {
            return false;
        }
        if (!Objects.equals(this.nivel, other.nivel)) {
            return false;
        }
        if (!Objects.equals(this.regimeTrabalho, other.regimeTrabalho)) {
            return false;
        }
        return this.cargaHoraria == other.cargaHoraria;
    }

    //ToString
    @Override
    public String toString() {
        return "DadosProfissional{\n"
                + "idDadosProfissional=" + idDadosProfissional + ",\n"
                + "matricula=" + matricula + ",\n"
                + "classe=" + classe + ",\n"
                + "nivel=" + nivel + ",\n"
                + "regimeTrabalho=" + regimeTrabalho + ",\n"
                + "cargaHoraria=" + cargaHoraria + '\n'
                + '}';
    }
}
