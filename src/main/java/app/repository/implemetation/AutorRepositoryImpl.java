package app.repository.implemetation;

import app.configuration.HibernateConfiguration;
import app.model.Autor;
import app.model.Carte;
import app.repository.AutorRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class AutorRepositoryImpl implements AutorRepository {
    @Override
    public Autor save(Autor entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer idOnAutorSaved = (Integer) session.save(entity);

        transaction.commit();
        session.close();

        return findById(idOnAutorSaved);
    }

    @Override
    public Autor update(Autor entity) {
        return null;
    }

    @Override
    public Autor findById(Integer id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // HQL - Hibernate Query Language, but use named query instead to reuse them
        Query query = session.createQuery("from Autor where idAutor=:id");
        query.setParameter("id", id);

//        TypedQuery<User> query = session.getNamedQuery("findPersonById");
//        query.setParameter("id", id);

        Autor autor;
        try {
            autor = (Autor) query.getSingleResult();
        } catch (NoResultException e) {
            autor = null;
        }

        transaction.commit();
        session.close();

        return autor;
    }

    @Override
    public List<Autor> findAll() {
        return null;
    }

    @Override
    public boolean delete(Autor entity) {
        return false;
    }

//    @Override
//    public List<Carte> getAllBookByAutorId(Integer id) {
//        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        // HQL - Hibernate Query Language, but use named query instead to reuse them
//        Query query = session.createQuery("from Autor where idAutor=:id");
//        query.setParameter("id", id);
//
////        TypedQuery<User> query = session.getNamedQuery("findPersonById");
////        query.setParameter("id", id);
//
//        Autor autor;
//        try {
//            autor = (Autor) query.getSingleResult();
//        } catch (NoResultException e) {
//            autor = null;
//        }
//
//        transaction.commit();
//        session.close();
//        return null;
//    }
}
