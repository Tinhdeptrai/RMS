package com.ptit.rms.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ptit.rms.model.TheUuDai;
import com.ptit.rms.repository.AbstractRepository;
import com.ptit.rms.repository.TheUuDaiRepository;

@Repository("TheUuDaiRepository")
public class TheUuDaiRepositoryImpl extends AbstractRepository<Integer, TheUuDai> implements TheUuDaiRepository {

  @Override
  public TheUuDai getTheUuDaiByName(String theUuDai) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("tenThe", theUuDai));
    TheUuDai res = (TheUuDai) crit.uniqueResult();
    return res;
  }

}
