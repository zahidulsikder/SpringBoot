package org.idb.Tourism.controller;

import org.idb.Tourism.entity.HotelFacilities;
import org.idb.Tourism.service.HotelFacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelFacilitiesController {

    @Autowired
    HotelFacilitiesService hotelFacilitiesService;

    @RequestMapping("/add_h_fac_form")
    public String hFacAddForm(Model m) {
        m.addAttribute("hfacilities", new HotelFacilities());
        return "hfacrform";
    }

    @RequestMapping("/add_h_facilities")
    public String hFacAdd(@ModelAttribute("hfacilities") HotelFacilities hf, Model m) {
        hotelFacilitiesService.saveHFacilities(hf);
        m.addAttribute("title", "hfacilities");
        return "redirect:/hfaclist";

    }

    @RequestMapping("/all_h_fac_list")
    public  String hFacView(Model m){
        m.addAttribute("hfacview",hotelFacilitiesService.getALlHFacilities());
        return "hfaclist";
    }

    @RequestMapping("/delete_hfacilities/{hfacid}")
    public  String deleteHFac(@ModelAttribute("hfacid") Integer hfacid ){
        hotelFacilitiesService.deleteHFacById(hfacid);
        return "redirect:/hfaclist";
    }


    @RequestMapping("/edit__hfacilities/{hfacid}")
    public String editHFac(@ModelAttribute("hfacid") Integer hfacid, Model m){

        hotelFacilitiesService.findHFacById(hfacid);
        m.addAttribute("hflist", new HotelFacilities());

        return "hfacrform";
    }

}
