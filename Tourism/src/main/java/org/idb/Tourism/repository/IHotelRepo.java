package org.idb.Tourism.repository;

import org.idb.Tourism.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHotelRepo extends JpaRepository<Hotel, Integer> {

}
