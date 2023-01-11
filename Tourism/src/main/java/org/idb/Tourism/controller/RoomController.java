package org.idb.Tourism.controller;

import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.entity.Room;
import org.idb.Tourism.service.HotelService;
import org.idb.Tourism.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoomController {
    @Autowired
    RoomService roomService;



    @RequestMapping("/roomhome")
    public String home(){
        return "roomhome";
    }
//----------------- save for room from--------------------
    @RequestMapping("/add_room")
    public String addRoomForm(Model m){
        m.addAttribute("room" , new Room());

        return "addRoomform";
    }

    @RequestMapping(value = "/room_save", method = RequestMethod.POST)
    public  String roomSave(@ModelAttribute("room") Room r, Model m){
        roomService.saveRoom(r);
        m.addAttribute("title", "Add Room");
        return "roomlist";
    }
    @RequestMapping("/delete_room/{rId}")
    public String deleteRoom(@PathVariable("rId") Integer rId){
        roomService.deleteRoomById(rId);
        return "redirect:/roomList";
    }

    @RequestMapping("/update_room/{rId}")
    public String updateRoom(@PathVariable("rId") Integer rId, Model m){
        roomService.findRoomById(rId);
        m.addAttribute("room", new Room());

        return "addroomform";
    }



//-------------------------------------------------------------------------------------





}
