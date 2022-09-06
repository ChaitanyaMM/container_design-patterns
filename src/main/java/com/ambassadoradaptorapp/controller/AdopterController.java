package com.ambassadoradaptorapp.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ambassadoradaptorapp.dto.LogJson;

@RestController
@RequestMapping("/adopter")
public class AdopterController {

	@Value("${fileNamePath}")
	private String fileName;
	

	@GetMapping("/readlog")
	public ResponseEntity<?> structurePayloadAsJson(@RequestParam String splitorValue) throws IOException {
		System.out.println("fileName {}   " + fileName);
		File file = ResourceUtils.getFile(fileName);
		System.out.println("absolutePath {}   " + file.getAbsolutePath());
		String path = file.getAbsolutePath();
		List<LogJson> list = new ArrayList<>();
		List<LogJson> finalList = null;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] split = line.split(splitorValue);
				finalList = getJson(split[0], split[1], list);

			}
		}

		return new ResponseEntity<>(finalList, HttpStatus.OK);

	}

	private List<LogJson> getJson(String time, String message, List<LogJson> list) {
		LogJson json = new LogJson();
		json.setTime(time);
		json.setMessage(message);

		list.add(json);

		return list;

	}

}
