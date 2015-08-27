package br.edu.ifba.sigpr.test.academico;

import br.edu.ifba.sigpr.model.academico.Disciplina;
import br.edu.ifba.sigpr.model.academico.NivelEnsino;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidaNivelEnsino {

    public static void main(String[] args) {

        //Cria o objeto que deseja-se validar
        NivelEnsino ser = new NivelEnsino();

        //Faz uma frabrica de validações
        ValidatorFactory fabrica = Validation.buildDefaultValidatorFactory();

        //Cria a validação
        Validator valida = fabrica.getValidator();

        //Pega a coleção de erros elencados
        Set<ConstraintViolation<NivelEnsino>> constraintViolationsCliente = valida.validate(ser);

        for (ConstraintViolation<NivelEnsino> erro : constraintViolationsCliente) {
            //Imprime os erros
            System.err.println(erro.getMessage());
        }
    }
}
