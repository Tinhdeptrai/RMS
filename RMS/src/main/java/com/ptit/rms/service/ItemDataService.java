package com.ptit.rms.service;

import java.util.Date;
import java.util.List;

import com.ptit.rms.model.ItemData;
import com.ptit.rms.model.api.ItemDatasAPI;

public interface ItemDataService {

  List<ItemData> getListItemByDate(Date dateUpdateAt);

  List<ItemDatasAPI> convertItemToJson(List<ItemData> list);

}
