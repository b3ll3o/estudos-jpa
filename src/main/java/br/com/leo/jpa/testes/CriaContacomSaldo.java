package br.com.leo.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.leo.jpa.modelo.Conta;

public class CriaContacomSaldo {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager em = entityManagerFactory.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Juliano");
		conta.setNumero(12345);
		conta.setAgencia(45678);
		conta.setSaldo(500.00);

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
	}
}
