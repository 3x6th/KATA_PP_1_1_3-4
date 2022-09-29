package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (\n" +
                            "  id INT NOT NULL AUTO_INCREMENT,\n" +
                            "  name VARCHAR(45) NULL,\n" +
                            "  lastName VARCHAR(45) NULL,\n" +
                            "  age INT NULL,\n" +
                            "  PRIMARY KEY (id))")
                    .addEntity(User.class);
            query.executeUpdate();
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
        }
    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
