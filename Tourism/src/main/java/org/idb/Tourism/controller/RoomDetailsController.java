package org.idb.Tourism.controller;

import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.entity.RoomDetails;
import org.idb.Tourism.repository.IRoomDetails;
import org.idb.Tourism.service.RoomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomDetailsController {

    @Autowired
    RoomDetailsService roomDetailsService;

    @RequestMapping("/add_room_form")
    public  String roomAddForm(Model m){
        m.addAttribute("room" , new RoomDetails());
        return "hoteladminpannel";
    }

    @RequestMapping("/add_room")
    public  String roomAdd(@ModelAttribute("room") RoomDetails r, Model m){
        roomDetailsService.saveRoomDetails(r);
        m.addAttribute("title", "Add Room Details");
        return "redirect:/roomlList";
    }

    @RequestMapping("/all_roomdetails")
    public String roomView(Model m){
        m.addAttribute("getRoomList",  roomDetailsService.getAllroomDetails());
       return  "roomlList";
    }

    @RequestMapping("/delete_room/{rid}")
    public String deleteRoom(@PathVariable("rid") Integer rid){
        roomDetailsService.deleteRoomDetailsById(rid);
        return "redirect:/roomlList";
    }

    @RequestMapping("/update_room/{rid}")
    public String updateRoom(@PathVariable("rid") Integer rid, Model m){

        roomDetailsService.findroomDetailsById(rid);
        m.addAttribute("roomList", new RoomDetails());

        return "addroomform";
    }








}
