package com.oaes.instrument_service.Repository;

import com.oaes.instrument_service.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
