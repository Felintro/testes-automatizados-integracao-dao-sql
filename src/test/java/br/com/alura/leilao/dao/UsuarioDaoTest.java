package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDaoTest extends Object {

    private UsuarioDao dao;
    private EntityManager em;


    @Test
    void buscarPorUsername() {
        dao = new UsuarioDao(em);
        Usuario usuario = dao.buscarPorUsername("fulano");
        assertNotNull(usuario);
    }
}