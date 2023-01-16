package org.idb.Tourism.repository;

import org.idb.Tourism.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHotelRepo extends JpaRepository<Hotel, Integer>, JpaSpecificationExecutor<Hotel> {

    @Query("select h from Hotel h inner JOIN h.location l where  l.lid =?1 ")
    public List<Hotel> findBylocationId(int lid);



}
