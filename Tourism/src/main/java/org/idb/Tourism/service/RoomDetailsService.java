package org.idb.Tourism.service;


import org.idb.Tourism.entity.RoomDetails;
import org.idb.Tourism.repository.IRoomDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomDetailsService {

    @Autowired
    IRoomDetails roomDetails;


    public  void  saveRoomDetails(RoomDetails r){
        roomDetails.save(r);
    }

    public void deleteRoomDetailsById(int rid){
        roomDetails.deleteById(rid);

    }

    public List<RoomDetails> getAllroomDetails(){

        return roomDetails.findAll();
    }


    public  RoomDetails findroomDetailsById(int rid){

        return roomDetails.findById(rid).get();
    }




}
