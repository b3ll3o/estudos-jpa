package br.com.leo.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.leo.jpa.modelo.Conta;
import br.com.leo.jpa.modelo.Movimentacao;

public class TesteJpql {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(34L);
		
		TypedQuery<Movimentacao> query = em.createQuery(
				"SELECT m FROM Movimentacao m WHERE m.conta = :pConta ORDER BY m.valor desc", 
				Movimentacao.class);
		query.setParameter("pConta", conta);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.err.println(movimentacao.getDescricao());
			System.err.println(movimentacao.getTipo());
		}
	}
}
