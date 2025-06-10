package aplicação;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;


public class Programa {

	public static void main(String[] args) {
		
		//1 - Create no banco com JPA
		
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "anas@gmail.com");
		
		//criar conexão com o banco de dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); 
		EntityManager em = emf.createEntityManager();
		
		//JPA exige transação para alterar dados no banco
		
		em.getTransaction().begin(); //inicia tansação
		em.persist(p1);//salva objeto no banco de dados
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();//confirma e finaliza
		System.out.println("Pronto!");
				
		

	}

}
