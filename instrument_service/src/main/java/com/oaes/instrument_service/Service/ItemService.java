package com.oaes.instrument_service.Service;

import com.oaes.instrument_service.Entity.Item;
import com.oaes.instrument_service.Repository.ItemRepository;
import com.oaes.instrument_service.Repository.MCQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

}
