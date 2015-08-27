package br.edu.ifba.sigpr.model.rh;

import br.edu.ifba.sigpr.model.rh.classe.NivelAcesso;
import br.edu.ifba.sigpr.model.rh.classe.Funcao;

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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import org.joda.time.LocalDate;


@Entity
@Table(name = "TBL_SERVIDOR")
public class Servidor implements Serializable {
    /**
     * Chave gerada automatico
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_SERVIDOR", nullable = false, unique = true)
    private int idServidor;
    
    @Column(name = "CPF", nullable = false, unique = true)
    @NotNull(message = "Campo CPF é Obrigatório")
    @NotEmpty(message = "O campo CPF não deve ficar em branco.")
    @CPF(message = "CPF inválido!")
    @Pattern(regexp = "/^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2,3}+$",message = "CPF fora do padrão(000.000.000-00)")
    private String cpf;
    
    @Column(name = "NOME_SERVIDOR", nullable = false)
    @NotNull(message = "Campo nome obrigatório")
    @NotEmpty(message = "O campo nome não deve ficar em branco.")
    @Length(min = 6, max=50, message = "O nome poderá ter de 6 a 50 caracteres!")
    @Pattern(regexp = "([a-zA-Z]+)+((\\s[a-zA-Z]+)|(\\s[a-zA-Z]+)\\.)+$", message = "Nome fora do padrão")
    private String nome;
    
    @Column(name = "SEXO")
    @Length(max = 1)
    @Pattern(regexp = "F|M", message = "Sexo Inválido.")
    private String sexo;
   
    @Column(name = "DATA_NASCIMENTO")
    @Past(message = "A data deve ser anterior a hoje.")
    @Type (type = "org.hibernate.type.LocalDateType")
    private LocalDate dataNascimento;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NIVEL_ACESSO")
    private NivelAcesso nivelDeAcesso;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUNCAO")
    private Funcao funcao;
    
    @Column(name = "STATUS", nullable = false)
    private boolean status = true;
    
    @Column(name = "LOGIN", nullable = false, unique = true)
    @Length(min = 8)
    @NotEmpty(message = "O campo login não deve ficar em branco.")
    @NotNull(message = "Campo Login Obrigatório")
    private String login;
    
    @Column(name = "SENHA", nullable = false)
    @Length(min = 8)
    @NotEmpty(message = "O campo senha não deve ficar em branco.")
    @NotNull(message = "Campo Senha Obrigatório")
    private String senha;
    
    //Construtor
    public Servidor() {
    }
    
    //Construtor Padrão
    public Servidor(String cpf, String nome, String login, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    //Construtor Completo

    public Servidor(String cpf, String nome, String sexo, LocalDate dataNascimento, 
            NivelAcesso nivelDeAcesso, Funcao funcao, String login, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.nivelDeAcesso = nivelDeAcesso;
        this.funcao = funcao;
        this.login = login;
        this.senha = senha;
    }
        
    //Metodos Getters
    public int getIdServidor() {
        return idServidor;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public NivelAcesso getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public String getLogin() {
        return login;
    }
    
    //Metodos Setters
    public void setIdServidor(int idServidor) {
        this.idServidor = idServidor;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNivelDeAcesso(NivelAcesso nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }
    
    //Metodos das Classes
    public boolean isAtivo(){
        return this.status;
    }
    
    public void alteraSenha(String senha){
        this.senha = senha;
    }
    
    public void alteraLogin(String login){
        this.login = login;
    }
    
    public void desativarServidor(){
        this.status = false;
    }
    
    //Metodos Hashcode Equals e ToString

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idServidor;
        hash = 97 * hash + Objects.hashCode(this.cpf);
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
        final Servidor other = (Servidor) obj;
        if (this.idServidor != other.idServidor) {
            return false;
        }
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        return "Servidor{\n"
                    + "idServidor=" + idServidor + ",\n"
                    + "cpf=" + cpf + ",\n"
                    + "nome=" + nome + ",\n"
                    + "sexo=" + sexo + ",\n"
                    + "dataNascimento=" + dataNascimento + ",\n"
                    + "nivelDeAcesso=" + nivelDeAcesso + ",\n"
                    + "funcao=" + funcao + ",\n"
                    + "status=" + status + ",\n"
                    + "login=" + login + ",\n"
                    + "senha=" + senha + '\n'
                +'}';
    }
}