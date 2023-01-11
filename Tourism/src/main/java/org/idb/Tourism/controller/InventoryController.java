package org.idb.Tourism.controller;


import org.idb.Tourism.entity.Inventory;
import org.idb.Tourism.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InventoryController {

    @Autowired
    InventoryService service;

    //this is for index/home page
    @RequestMapping("/inventory")
    public String home(){
        return "inventory";
    }



    @RequestMapping("/all_inventory")
    public String allinventory(Model m){
        m.addAttribute("invList",service.getAllinventory());

        return "all_inventory";


    }

    @RequestMapping("/in_reg_form")
    public String inventoryAddForm(Model m){
        m.addAttribute("inventory", new Inventory());
        m.addAttribute("title", "inventory Registration");
        return "inventory_reg_form";
    }

    @RequestMapping(value = "/add_inventory", method = RequestMethod.POST)
    public String addNewinventory(@ModelAttribute("inventory") Inventory i, Model m ){
        service.saveinventory(i);
        return "redirect:/inventorylist";
    }

    @RequestMapping("/delete_inventory/{id}")
    public String deleteinventory(@PathVariable("id") Integer id){
        service.deleteinventoryById(id);
        return "redirect:/all_inventory";
    }

    @RequestMapping("/update_inventory/{id}")
    public String inventoryUpdateForm(@PathVariable("id") Integer id, Model m){
        Inventory i = service.findHotelById(id);
        m.addAttribute("inventory", i);
        return "/inventory_reg_form";
    }


}
