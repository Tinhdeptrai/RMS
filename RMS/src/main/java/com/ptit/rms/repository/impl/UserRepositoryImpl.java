package com.ptit.rms.repository.impl;

import com.ptit.rms.model.User;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.UserRepository;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("user")
public class UserRepositoryImpl extends AbstractRepository<Integer, User> implements UserRepository {

  static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

  public User findById(int id) {
    User user = getByKey(id);
    if (user != null) {
      Hibernate.initialize(user.getRole());
    }
    return user;
  }

  public User findByUsername(String username) {
    logger.info("username : {}", username);
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("username", username));
    crit.add(Restrictions.eq("isDeleted", false));
    User user = (User) crit.uniqueResult();
    if (user != null) {
      Hibernate.initialize(user.getRole());
    }
    return user;
  }

  @SuppressWarnings("unchecked")
  public List<User> findAllUsers() {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("createdAt"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("isDeleted", false));
    List<User> users = (List<User>) criteria.list();

    /*
     * for(User user : users){ Hibernate.initialize(user.getUserProfiles()); }
     */
    return users;
  }

  public void save(User user) {
    persist(user);
  }

  public void deleteByUsername(String username) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("username", username));
    User user = (User) crit.uniqueResult();
    delete(user);
  }

  @Override
  public void updateUser(User user) {
    update(user);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<User> getListUserByDate(Date date) {
    Criteria criteria = createEntityCriteria().addOrder(Order.asc("createdAt"));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    criteria.add(Restrictions.eq("isDeleted", false));
    criteria.add(Restrictions.ge("updatedAt", date));
    List<User> users = (List<User>) criteria.list();
    return users;
  }

}
