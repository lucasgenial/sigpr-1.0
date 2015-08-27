package br.edu.ifba.sigpr.test.academico;

import br.edu.ifba.sigpr.model.academico.Curso;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidaCurso {
    public static void main(String[] args) {
        
        //Cria o objeto que deseja-se validar
        Curso ser = new Curso();
        
        //Faz uma frabrica de validações
        ValidatorFactory fabrica = Validation.buildDefaultValidatorFactory();
        
        //Cria a validação
        Validator valida = fabrica.getValidator();
        
        //Pega a coleção de erros elencados
        Set<ConstraintViolation<Curso>> constraintViolationsCliente = valida.validate(ser);
        
        for (ConstraintViolation<Curso> erro : constraintViolationsCliente) {
            //Imprime os erros
            System.err.println(erro.getMessage());

        }
    }
}
