package com.ptit.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.rms.model.ItemData;
import com.ptit.rms.model.api.ItemDatasAPI;
import com.ptit.rms.repository.ItemDataRepository;
import com.ptit.rms.service.ItemDataService;

@Transactional
@Service("ItemDataService")
public class ItemDataServiceImpl implements ItemDataService {

  @Autowired
  private ItemDataRepository itemDataRepository;

  @Override
  public List<ItemData> getListItemByDate(Date dateUpdateAt) {
    return this.itemDataRepository.getListItemByDate(dateUpdateAt);
  }

  @Override
  public List<ItemDatasAPI> convertItemToJson(List<ItemData> list) {
    List<ItemDatasAPI> itemDatasAPIs = new ArrayList<>();
    for (ItemData itemData : list) {
      ItemDatasAPI itemDatasAPI = new ItemDatasAPI(itemData.getItemDataId(), itemData.getAuditDate().getAuditDateId(),
          itemData.getItems().getItemId(), itemData.getValue(), itemData.getImageUrl(), itemData.getCreatedBy(), itemData.getUpdatedBy());
      itemDatasAPI.setCreatedAt(itemData.getCreatedAt());
      itemDatasAPI.setUpdatedAt(itemData.getUpdatedAt());
      itemDatasAPIs.add(itemDatasAPI);
    }
    return itemDatasAPIs;
  }

}
