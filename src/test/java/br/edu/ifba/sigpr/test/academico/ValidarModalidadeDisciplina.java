package br.edu.ifba.sigpr.test.academico;

import br.edu.ifba.sigpr.model.academico.ModalidadeDisciplina;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidarModalidadeDisciplina {

    public static void main(String[] args) {

        //Cria o objeto que deseja-se validar
        ModalidadeDisciplina ser = new ModalidadeDisciplina();

        //Faz uma frabrica de validações
        ValidatorFactory fabrica = Validation.buildDefaultValidatorFactory();

        //Cria a validação
        Validator valida = fabrica.getValidator();

        //Pega a coleção de erros elencados
        Set<ConstraintViolation<ModalidadeDisciplina>> constraintViolationsCliente = valida.validate(ser);

        for (ConstraintViolation<ModalidadeDisciplina> erro : constraintViolationsCliente) {
            //Imprime os erros
            System.err.println(erro.getMessage());
        }
    }
}
