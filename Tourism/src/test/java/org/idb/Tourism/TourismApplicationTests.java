package org.idb.Tourism;

import org.idb.Tourism.controller.HotelController;
import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.entity.RoomDetails;
import org.idb.Tourism.service.HotelService;
import org.idb.Tourism.service.RoomDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TourismApplicationTests {
	@Autowired
	HotelService hotelService;


	@Autowired
	RoomDetailsService service;



	@Test
	void contextLoads() {
	}

	@Test
	void  saveHotel(){

		Hotel h = new Hotel();

				h.setHcountry("Bangladesh");
				h.setHname("RomanHotel");
				h.setHemail("abc@gmail.com");
				h.setHpassword("1234");
				h.setHphone("01857459018");
				h.setHlocation("Gazipur");

		hotelService.saveHotel(h);

	}

	@Test
	void  roomSave(){
		RoomDetails r = new RoomDetails();
		r.setRdoubletype(50);
		r.setRsingletype(25);
		r.setRdoubleprice(20000.0);
		r.setRsingleprice(1000.00);

		service.saveRoomDetails(r);


	}




}
