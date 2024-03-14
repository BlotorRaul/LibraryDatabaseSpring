package app.repository.implemetation;

import app.configuration.HibernateConfiguration;
import app.model.Autor;
import app.model.Carte;
import app.repository.CarteRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarteRepositoryImpl implements CarteRepository {
    //private final EntityManager entityManager;
    @Override
    public Carte save(Carte entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer idCarte = (Integer) session.save(entity);

        transaction.commit();
        session.close();

        return findById(idCarte);
    }

    @Override
    public Carte update(Carte entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = entity.getIdCarte();
        session.saveOrUpdate(entity);

        transaction.commit();
        session.close();

        return findById(id);
    }

    @Override
    public Carte findById(Integer id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Carte where idCarte=:id");
        query.setParameter("id", id);


        Carte carte;
        try {
            carte =(Carte) query.getSingleResult();
        } catch (NoResultException e) {
            carte = null;
        }
        transaction.commit();
        session.close();
        return carte;
    }

    @Override
    public List<Carte> findAll() {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        TypedQuery<Carte> query= session.getNamedQuery("findAllBooks");
        List<Carte> carti = query.getResultList();

        transaction.commit();
        session.close();

        return carti;
    }

    @Override
    public boolean delete(Carte entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = entity.getIdCarte();
        session.delete(entity);

        transaction.commit();
        session.close();

        return findById(id) == null;
    }
//    public List<Carte> findByAutor(Autor autor) {
//        TypedQuery<Carte> query = entityManager.createQuery(
//                "SELECT c FROM Carte c WHERE c.autor = :autor", Carte.class);
//        query.setParameter("autor", autor);
//        return query.getResultList();
//    }
}
