package org.idb.Tourism.controller;

import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.entity.RoomDetails;
import org.idb.Tourism.service.HotelService;
import org.idb.Tourism.service.RoomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelController {
    @Autowired
    HotelService hotelService;

    @Autowired
    RoomDetailsService roomDetailsService;

    @RequestMapping("/hotel")
    public String home(){

        return "index";
    }
//----------------- save for hotel from--------------------
    @RequestMapping("/reg_hotel")
    public String addHotelForm(Model m){
        m.addAttribute("hotel" , new Hotel());
        m.addAttribute("roomdetails" , roomDetailsService.getAllroomDetails());
        return "hotelform";
    }

    @RequestMapping("")
    public  String hotelSave(@ModelAttribute("hotel") Hotel h, Model m){
        hotelService.saveHotel(h);
        m.addAttribute("title", "Add Hotel");
        return "hotelList";
    }
//-------------------------------------------------------------------------------------





}
