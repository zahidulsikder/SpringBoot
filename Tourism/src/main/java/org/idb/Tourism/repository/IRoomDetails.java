package org.idb.Tourism.repository;

import org.idb.Tourism.entity.RoomDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomDetails extends JpaRepository<RoomDetails, Integer> {

}
