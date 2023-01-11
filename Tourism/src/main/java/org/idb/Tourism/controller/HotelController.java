package org.idb.Tourism.controller;

import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HotelController {
    @Autowired
    HotelService hotelService;


    @RequestMapping("/login")
    public String login(){
        return "auth-login";
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }
//----------------- save for hotel from--------------------
    @RequestMapping("/add_hotel")
    public String addHotelForm(Model m){
        m.addAttribute("hotel" , new Hotel());

        return "addhotelform";
    }

    @RequestMapping(value = "/hotel_save", method = RequestMethod.POST)
    public  String hotelSave(@ModelAttribute("hotel") Hotel h, Model m){
        hotelService.saveHotel(h);
        m.addAttribute("title", "Add Hotel");
        return "hotelList";
    }
    @RequestMapping("/delete_hotel/{lid}")
    public String deleteLocation(@PathVariable("lid") Integer hid){
        hotelService.deleteHotelById(hid);
        return "redirect:/hotelList";
    }

    @RequestMapping("/update_hotel/{lid}")
    public String updateLocation(@PathVariable("lid") Integer lid, Model m){
        hotelService.findHotelById(lid);
        m.addAttribute("hotel", new Hotel());

        return "addhotelform";
    }
//-------------------------------------------------------------------------------------





}
