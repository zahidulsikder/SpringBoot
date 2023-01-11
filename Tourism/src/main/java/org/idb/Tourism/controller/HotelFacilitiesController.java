package org.idb.Tourism.controller;

import org.idb.Tourism.entity.HotelFacilities;
import org.idb.Tourism.service.HotelFacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HotelFacilitiesController {

    @Autowired
    HotelFacilitiesService hotelFacilitiesService;

    @RequestMapping("/h_fac_list")
    public String hFacLsit(Model m) {
        m.addAttribute("hfList",hotelFacilitiesService.getALlHFacilities());
        m.addAttribute("hfacilities", new HotelFacilities());
        return "hotelfacilitieslist";
    }

    @RequestMapping(value = "/add_h_facilities", method = RequestMethod.POST)
    public String hFacAdd(@ModelAttribute("hfacilities") HotelFacilities hf, Model m) {

        hotelFacilitiesService.saveHFacilities(hf);
        return "redirect:/h_fac_list";
    }



    @RequestMapping("/delete_hfacilities/{hfacid}")
    public  String deleteHFac(@ModelAttribute("hfacid") Integer hfacid ){
        hotelFacilitiesService.deleteHFacById(hfacid);
        return "redirect:/h_fac_list";
    }


    @RequestMapping("/edit_hfacilities/{hfacid}")
    public String editHFac(@ModelAttribute("hfacid") Integer hfacid, Model m){

        HotelFacilities r= hotelFacilitiesService.findHFacById(hfacid);
        m.addAttribute("hfacilities", r);

        return "hotelfacilitieslist";
    }

}
