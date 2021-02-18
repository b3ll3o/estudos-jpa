package br.com.leo.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriacaoTabelas {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");

		EntityManager manager = entityManagerFactory.createEntityManager();

		manager.close();
	}
}
