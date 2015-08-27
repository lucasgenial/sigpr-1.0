package br.edu.ifba.sigpr.model.rh.classe;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Embeddable
@Entity
@Table(name = "TBL_ENDERECO")
public class Endereco implements Serializable {
    /**
     * Chave estrangeira da tabela Servidor
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ENDERECO", nullable = false, unique = true)
    private int id_endereco;
    
    @Column(name = "CIDADE", nullable = false, unique = true)
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Nome cidade inválido")
    private String cidade;
    
    @Column(name = "BAIRRO", nullable = false, unique = true)
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Nome bairro inválido")
    private String bairro;
    
    @Column(name = "TIPO_LOGRADOURO", nullable = false, unique = true)
    @Size(min = 2, max = 10)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Tipo logradouro inválido")
    private String tipo_logradouro;
    
    @Column(name = "NOME_LOGRADOURO", nullable = false, unique = true)
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9\\./\\s/]+$", message = "Nome logradouro inválido")
    private String nome_logradouro;
    
    @Column(name = "NUMERO", nullable = false, unique = true)
    @Min(value = 0, groups = {Integer.class},message = "Nº inválido")
    private int numero;
    
    @Column(name = "CEP", nullable = false, unique = true)
    @Pattern(regexp = "^\\d{5}\\-?\\d{3}$", message = "CEP inválido!")
    private String CEP;
    
    //Construtor
    public Endereco(){
    }
    
    //Cria os Sets
    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setTipo_logradouro(String tipo_logradouro) {
        this.tipo_logradouro = tipo_logradouro;
    }

    public void setNome_logradouro(String nome_logradouro) {
        this.nome_logradouro = nome_logradouro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    
    //Construtor Padrão
    public Endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public Endereco(int id_endereco, String cidade, String bairro, String tipo_logradouro, String nome_logradouro, int numero, String CEP) {
        this.id_endereco = id_endereco;
        this.cidade = cidade;
        this.bairro = bairro;
        this.tipo_logradouro = tipo_logradouro;
        this.nome_logradouro = nome_logradouro;
        this.numero = numero;
        this.CEP = CEP;
    }
    
    //Cria os Getters
    public int getId_endereco() {
        return id_endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getTipo_logradouro() {
        return tipo_logradouro;
    }

    public String getNome_logradouro() {
        return nome_logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getCEP() {
        return CEP;
    }
    
    //Cria o Equals e HashSet
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id_endereco;
        hash = 89 * hash + Objects.hashCode(this.cidade);
        hash = 89 * hash + Objects.hashCode(this.bairro);
        hash = 89 * hash + Objects.hashCode(this.tipo_logradouro);
        hash = 89 * hash + Objects.hashCode(this.nome_logradouro);
        hash = 89 * hash + this.numero;
        hash = 89 * hash + Objects.hashCode(this.CEP);
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
        final Endereco other = (Endereco) obj;
        if (this.id_endereco != other.id_endereco) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.tipo_logradouro, other.tipo_logradouro)) {
            return false;
        }
        if (!Objects.equals(this.nome_logradouro, other.nome_logradouro)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return Objects.equals(this.CEP, other.CEP);
    }
    
    //ToString
    @Override
    public String toString() {
        return "Endereco{" + "id_endereco=" + id_endereco + ",\n"
                + "Cidade=" + cidade + ",\n"
                + "Bairro=" + bairro + ",\n"
                + "Tipo Logradouro=" + tipo_logradouro + ",\n"
                + "Nome Logradouro=" + nome_logradouro + ",\n"
                + "Numero=" + numero + ",\n"
                + "CEP=" + CEP + '\n'
               +'}';
    }
    
}
