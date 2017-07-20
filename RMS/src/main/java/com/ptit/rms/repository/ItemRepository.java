package com.ptit.rms.repository;

import java.util.Date;
import java.util.List;

import com.ptit.rms.model.Items;

public interface ItemRepository {

  List<Items> getListItemByDate(Date dateUpdateAt);

}
