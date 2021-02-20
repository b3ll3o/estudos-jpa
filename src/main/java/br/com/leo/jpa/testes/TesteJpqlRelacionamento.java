package br.com.leo.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.leo.jpa.modelo.Categoria;
import br.com.leo.jpa.modelo.Movimentacao;

public class TesteJpqlRelacionamento {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager em = entityManagerFactory.createEntityManager();

		Categoria categoria = new Categoria();
		categoria.setId(3L);

		TypedQuery<Movimentacao> query = em.createQuery(
				"SELECT m FROM Movimentacao m JOIN m.categorias c WHERE c = :pCategoria", Movimentacao.class);
		query.setParameter("pCategoria", categoria);

		List<Movimentacao> movimentacoes = query.getResultList();

		for (Movimentacao movimentacao : movimentacoes) {
			System.err.println(movimentacao.getDescricao());
			System.err.println(movimentacao.getTipo());
			System.err.println(movimentacao.getCategorias());
		}
	}
}
