package com.ptit.rms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.rms.model.Items;
import com.ptit.rms.model.api.ItemsAPI;
import com.ptit.rms.repository.ItemRepository;
import com.ptit.rms.service.ItemService;

@Service("ItemRepositoryImpl")
@Transactional
public class ItemServiceImpl implements ItemService {

  @Autowired
  private ItemRepository itemRepository;

  @Override
  public List<Items> getListItemByDate(Date dateUpdateAt) {
    return this.itemRepository.getListItemByDate(dateUpdateAt);
  }

  @Override
  public List<ItemsAPI> convertItemToJson(List<Items> list) {
    List<ItemsAPI> itemsAPIs = new ArrayList<>();
    for (Items items : list) {
      ItemsAPI itemsAPI = new ItemsAPI(items.getItemId(), items.getLocations().getLocationId(), items.getItemName(), items.getType(),
          items.getDescription(), items.getUnit(), items.getMin(), items.getMax(), items.getMapUrl(), items.getIsDeleted(), items.getCreatedBy(),
          items.getUpdatedBy(), items.getItemOrder());
      itemsAPI.setDeletedTime(items.getDeletedTime());
      itemsAPI.setCreatedAt(items.getCreatedAt());
      itemsAPI.setUpdatedAt(items.getUpdatedAt());
      itemsAPIs.add(itemsAPI);
    }
    return itemsAPIs;
  }
}
