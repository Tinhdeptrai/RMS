package com.ptit.rms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.Roles;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.RolesRepository;


@Repository("RolesRepository")
public class RolesRepositoryImpl extends AbstractRepository<Integer, Roles> implements RolesRepository {

  @Override
  public Roles findRoleByRoleName(String role) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("roleName", role));
    Roles roles = (Roles) crit.uniqueResult();
    return roles;
  }
  
  public List<Roles> getAllRoles() {
    Criteria criteria = createEntityCriteria();
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    @SuppressWarnings("unchecked")
    List<Roles> roles = (List<Roles>) criteria.list();
    return roles;
  }
}
