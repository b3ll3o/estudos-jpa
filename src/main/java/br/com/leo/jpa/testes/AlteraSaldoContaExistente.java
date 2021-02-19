package br.com.leo.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.leo.jpa.modelo.Conta;

public class AlteraSaldoContaExistente {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Conta conta = em.find(Conta.class, 1L);
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().begin();
		
		conta.setSaldo(20.0);
		
		em.getTransaction().commit();
	}
}
