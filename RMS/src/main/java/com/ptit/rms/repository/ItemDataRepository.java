package com.ptit.rms.repository;

import java.util.Date;
import java.util.List;

import com.ptit.rms.model.ItemData;

public interface ItemDataRepository {

  List<ItemData> getListItemByDate(Date dateUpdateAt);

}
