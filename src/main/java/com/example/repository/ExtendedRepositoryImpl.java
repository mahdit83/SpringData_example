package com.example.repository;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class ExtendedRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T,ID>
	implements BaseRepository<T, ID>{

	private JpaEntityInformation<T,?> entityInformation;
	private EntityManager entityManger;

	public ExtendedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManger = entityManager;
		this.entityInformation = entityInformation;
	}

	@Override
	public List<T> findByIds(ID... ids) {
		Query query = this.entityManger.createQuery("select e from " + this.entityInformation.getEntityName()
			+ " e where e." + this.entityInformation.getIdAttribute().getName() + " in :ids");
		query.setParameter("ids", Arrays.asList(ids));
		System.out.println(query.getResultList());
        long wait = new Random().nextInt(1000-9)+1;
        System.out.println(wait);

        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Id is "+Arrays.toString(ids));

        return (List<T>) query.getResultList();
	}

    @Override
    public T findMahdiTajik(String name) {
        Query query = this.entityManger.createQuery("select e from " + this.entityInformation.getEntityName()
                + " e where e.title= :name");
        query.setParameter("name", name);
        System.out.println(query.getSingleResult());
        return null;
    }

}
