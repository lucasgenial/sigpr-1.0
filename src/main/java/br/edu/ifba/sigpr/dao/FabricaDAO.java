package br.edu.ifba.sigpr.dao;

import java.util.Collection;

public interface FabricaDAO {

    /**
     * Salva o objeto passado no banco de dados
     *
     * @param obj
     * @return boolean
     */
    public boolean Salvar(Object obj);

    /**
     * Busca um objeto pelo código
     *
     * @param codigoBuscado
     * @return
     */
    public Object BuscaPorCodigo(Long codigoBuscado);

    /**
     * Retorna um Collection com os tipos de dados solicitados que estão
     * cadastrados no banco
     *
     * @return Collection
     */
    public Collection<Object> Listar();

    /**
     * Excluir lógico, mantem os dados no banco de dados
     *
     * @param obj
     * @param status
     * @return boolean
     */
    public boolean ExcluirLogico(Object obj, boolean status);

    /**
     * Deleta definitivo do banco de Dados.
     *
     * @param obj
     * @return boolean
     */
    public boolean Deletar(Object obj);
}
