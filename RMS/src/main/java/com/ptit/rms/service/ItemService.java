package com.ptit.rms.service;

import java.util.Date;
import java.util.List;

import com.ptit.rms.model.Items;
import com.ptit.rms.model.api.ItemsAPI;

public interface ItemService {

  List<Items> getListItemByDate(Date dateUpdateAt);

  List<ItemsAPI> convertItemToJson(List<Items> list);

}
