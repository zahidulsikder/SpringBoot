package org.idb.Tourism.controller;

import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.entity.HotelFacilities;
import org.idb.Tourism.service.HotelFacilitiesService;
import org.idb.Tourism.service.HotelService;
import org.idb.Tourism.service.LocationService;
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

    @Autowired
    LocationService locationService;

    @Autowired
    HotelFacilitiesService hotelFacilitiesService;


//    @RequestMapping("/login")
//    public String login(){
//        return "auth-login";
//    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("/hotel_list")
    public  String hotelList(Model m){
        m.addAttribute("hotelList", hotelService.getAllHotel());
        m.addAttribute("locationList", locationService.getAllLocation());
        m.addAttribute("hFaciList", hotelFacilitiesService.getALlHFacilities());
        m.addAttribute("hotel", new Hotel());
        return "hotellist";
    }

    @RequestMapping(value = "/hotel_save", method = RequestMethod.POST)
    public  String hotelSave(@ModelAttribute("hotel") Hotel h, Model m){
        hotelService.saveHotel(h);
        m.addAttribute("title", "Add Hotel");
        m.addAttribute("message","Hotel add successful");
        return "redirect:/hotel_list";
    }
    @RequestMapping("/delete_hotel/{hid}")
    public String deleteHotel(@PathVariable("hid") Integer hid){
        hotelService.deleteHotelById(hid);
        return "redirect:/hotel_list";
    }

    @RequestMapping("/update_hotel/{hid}")
    public String updateHotel(@PathVariable("hid") Integer hid, Model m){
        Hotel h = hotelService.findHotelById(hid);
        m.addAttribute("hotel", h);
        m.addAttribute("locationList", locationService.getAllLocation());
        m.addAttribute("hFaciList", hotelFacilitiesService.getALlHFacilities());
        return "hotellist";
    }






}
