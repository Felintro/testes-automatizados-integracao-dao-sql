package br.com.felintro.leilao.dao;

import br.com.felintro.leilao.model.Usuario;
import br.com.felintro.leilao.util.JPAUtil;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsuarioDaoTest {

    private UsuarioDao dao;
    private EntityManager em;


    @Test
    void buscarPorUsernameTest() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(entityManager);

        Usuario usuario = new Usuario("fulano", "fulano@gmail.com", "123456");
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();


        Usuario usuarioEncontrado = this.dao.buscarPorUsername(usuario.getNome());
        assertNotNull(usuarioEncontrado);

    }
}