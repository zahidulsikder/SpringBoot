package org.idb.Tourism.controller;


import org.idb.Tourism.entity.Location;
import org.idb.Tourism.entity.RoomFacilities;
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
public class LocationController {
    @Autowired
    LocationService ls;


    @RequestMapping("/location_list")
    public String allLocation(Model m){
        m.addAttribute("rfaciList",ls.getAllLocation());
        m.addAttribute("lList", new Location());
        return "locationlist";
    }

    @RequestMapping(value = "/location_save", method = RequestMethod.POST)
    public  String locationSave(@ModelAttribute("lList") Location l, Model m){
        ls.saveLocation(l);
        m.addAttribute("title", "Add Location");
        return "redirect:/location_list";
    }

    @RequestMapping("/delete_location/{lid}")
    public String deleteLocation(@PathVariable("lid") Integer lid){
        ls.deleteLocationById(lid);
        return "redirect:/location_list";
    }

    @RequestMapping("/update_location/{lid}")
    public String updateLocation(@PathVariable("lid") Integer lid, Model m){
        Location l = ls.findLocationById(lid);
        m.addAttribute("lList", l);
        return "locationlist";
    }
}
