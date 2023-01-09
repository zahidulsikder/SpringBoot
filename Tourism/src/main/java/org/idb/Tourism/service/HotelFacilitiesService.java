package org.idb.Tourism.service;


import org.idb.Tourism.entity.HotelFacilities;
import org.idb.Tourism.repository.IHotelFacilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelFacilitiesService {

    @Autowired
    IHotelFacilities hotelFacilities;

    public void saveHFacilities(HotelFacilities hf){
        hotelFacilities.save(hf);
    }

    public  void deleteHFacById(int hfacid){
        hotelFacilities.deleteById(hfacid);
    }

    public List<HotelFacilities> getALlHFacilities(){
        return  hotelFacilities.findAll();
    }

    public HotelFacilities findHFacById(int hfacid){
        return hotelFacilities.findById(hfacid).get();
    }



}
