package web.service;

import java.util.List;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import web.dao.UserDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDAO.index();
    }

    @Transactional
    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    public User show(long id) {
        return userDAO.findById(id);
    }
}
