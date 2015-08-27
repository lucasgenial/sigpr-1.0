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
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "TBL_CONTATOS")
public class Contato implements Serializable {

    /**
     * Chave estrangeira da tabela Servidor
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CONTATO", nullable = false, unique = true)
    private int idContato;

    @Column(name = "TELEFONE_FIXO", nullable = false, unique = true)
    @Pattern(regexp = "^\\(\\d{2}\\)\\d{4,5}\\-\\d{4,5}$", message = "Telefone inválido!")
    private String telefoneFixo;

    @Column(name = "CELULAR", nullable = false, unique = true)
    @Pattern(regexp = "^(\\(\\d{2}\\)\\d{4}\\-\\d{4,5})|(\\(\\d{2}\\)\\d{5}\\-\\d{4,5})+$", message = "Celular inválido!")
    private String celular;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @NotNull(message = "O EMAIL não deve ser nulo.")
    @NotEmpty(message = "O campo EMAIL não deve ficar em branco.")
    @Email(message = "Email fora do padrão.")
    private String email;

    //Construtor
    public Contato() {
    }

    //Construtor Padrão
    public Contato(int idContato, String email) {
        this.idContato = idContato;
        this.email = email;
    }

    //Construtor Completo
    public Contato(int idContato, String telefoneFixo, String celular, String email) {
        this.idContato = idContato;
        this.telefoneFixo = telefoneFixo;
        this.celular = celular;
        this.email = email;
    }

    //Setters
    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Getters
    public int getIdContato() {
        return idContato;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    //Criar o Equals HashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idContato;
        hash = 29 * hash + Objects.hashCode(this.telefoneFixo);
        hash = 29 * hash + Objects.hashCode(this.celular);
        hash = 29 * hash + Objects.hashCode(this.email);
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
        final Contato other = (Contato) obj;
        if (this.idContato != other.idContato) {
            return false;
        }
        if (!Objects.equals(this.telefoneFixo, other.telefoneFixo)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    //ToString
    @Override
    public String toString() {
        return "Contato{\n"
                + "idContato=" + idContato + ",\n"
                + "Telefone Fixo=" + telefoneFixo + ",\n"
                + "Celular=" + celular + ",\n"
                + "Email=" + email + "\n"
                + '}';

    }
}
