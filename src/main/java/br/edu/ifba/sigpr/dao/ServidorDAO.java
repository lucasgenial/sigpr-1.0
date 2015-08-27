package br.edu.ifba.sigpr.dao;

import java.util.Collection;

public class ServidorDAO implements FabricaDAO {

    @Override
    public boolean Salvar(Object obj) {
        return false;
    }

    @Override
    public Object BuscaPorCodigo(Long codigoBuscado) {
        return null;
    }

    @Override
    public Collection<Object> Listar() {
        return null;
    }

    @Override
    public boolean ExcluirLogico(Object obj, boolean status) {
        return false;
    }

    @Override
    public boolean Deletar(Object obj) {
        return false;
    }
}