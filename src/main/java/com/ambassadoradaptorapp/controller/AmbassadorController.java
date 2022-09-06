package com.ambassadoradaptorapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ambassadoradaptorapp.dto.CannedData;

@RestController
@RequestMapping("/ambassador")
public class AmbassadorController {

	@GetMapping("/data")
	private ResponseEntity<?> getCannedData() {
		List<CannedData> list = new ArrayList<>();

		CannedData cd = new CannedData();
		cd.setId(1L);
		cd.setName("chy-01");
		cd.setMail("chy-01@gmail.com");

		CannedData cd1 = new CannedData();
		cd1.setId(2L);
		cd1.setName("chy-02");
		cd1.setMail("chy-02@gmail.com");

		CannedData cd2 = new CannedData();
		cd2.setId(3L);
		cd2.setName("chy-03");
		cd2.setMail("chy-03@gmail.com");

		CannedData cd3 = new CannedData();
		cd3.setId(4L);
		cd3.setName("chy-04");
		cd3.setMail("chy-04@gmail.com");

		list.add(cd);
		list.add(cd1);
		list.add(cd2);
		list.add(cd3);

		return new ResponseEntity<>(list, HttpStatus.OK);

	}

}
