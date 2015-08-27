package br.edu.ifba.sigpr.model.rh;

import br.edu.ifba.sigpr.model.academico.Curso;
import br.edu.ifba.sigpr.model.rh.classe.Funcao;
import br.edu.ifba.sigpr.model.rh.classe.NivelAcesso;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.joda.time.LocalDate;

@Embeddable
public class Professor extends Servidor{
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name ="CURSOS")
    @NotNull(message = "Campo Cursos é Obrigatório")
    @Size(min = 1, message = "O Professor precisa está ao menos em 1 curso")
    private Collection<Curso> cursos;
    
    //Construtor
    public Professor() {
    }
    
    //Construtor Padrão
    public Professor(Collection<Curso> cursos, String cpf, String nome, String login, String senha) {
        super(cpf, nome, login, senha);
        this.cursos = cursos;
    }
    
    
    //Construtor Completo
    public Professor(Collection<Curso> cursos, String cpf, String nome, String sexo, LocalDate dataNascimento, NivelAcesso nivelDeAcesso, Funcao funcao, String login, String senha) {
        super(cpf, nome, sexo, dataNascimento, nivelDeAcesso, funcao, login, senha);
        this.cursos = cursos;
    }
    
    //Setters
    public void setCursos(Collection<Curso> cursos) {
        this.cursos = cursos;
    }
    
    //Getters
    public Collection<Curso> getCursos() {
        return cursos;
    }
    
}