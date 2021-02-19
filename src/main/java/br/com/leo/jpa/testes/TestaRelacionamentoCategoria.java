package br.com.leo.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.leo.jpa.modelo.Categoria;
import br.com.leo.jpa.modelo.Conta;
import br.com.leo.jpa.modelo.Movimentacao;
import br.com.leo.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoCategoria {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(2L);
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		
		Movimentacao m1 = new Movimentacao();
		m1.setData(LocalDateTime.now());
		m1.setDescricao("Viagem SP");
		m1.setValor(new BigDecimal(200.0));
		m1.setTipo(TipoMovimentacao.ENTRADA);
		m1.setCategorias(Arrays.asList(categoria, categoria2));
		m1.setConta(conta);
		
		Movimentacao m2 = new Movimentacao();
		m2.setData(LocalDateTime.now());
		m2.setDescricao("Viagem RJ");
		m2.setValor(new BigDecimal(200.0));
		m2.setTipo(TipoMovimentacao.ENTRADA);
		m2.setCategorias(Arrays.asList(categoria, categoria2));
		m2.setConta(conta);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(categoria);
		em.persist(categoria2);
		em.persist(m1);
		em.persist(m2);
		em.getTransaction().commit();
		em.close();
	}
}
