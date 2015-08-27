package br.edu.ifba.sigpr.test.rh;

import br.edu.ifba.sigpr.model.rh.Servidor;
import java.util.Set;
import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class ValidaServidores {

    public static void main(String[] args) {
        
        //Cria o objeto que deseja-se validar
        Servidor ser = new Servidor();
        
        //Faz uma frabrica de validações
        ValidatorFactory fabrica = Validation.buildDefaultValidatorFactory();
        
        //Cria a validação
        Validator valida = fabrica.getValidator();
        
        //Pega a coleção de erros elencados
        Set<ConstraintViolation<Servidor>> constraintViolationsCliente = valida.validate(ser);
        
        for (ConstraintViolation<Servidor> erro : constraintViolationsCliente) {
            //Imprime os erros
            System.err.println(erro.getMessage());

        }
    }
}
