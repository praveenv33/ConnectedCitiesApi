package com.springboot.SpringBootDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	@GetMapping("/connected")
	public String findUser(@RequestParam("origin") String origin,@RequestParam("destination") String destination){
		boolean connected=false;
		try {
			File file = ResourceUtils.getFile("classpath:locationfile.txt");
			String searchStr=origin+", "+destination;
			String searchStr1=destination+", "+origin;
			 Scanner scan = new Scanner(file);
		        while(scan.hasNext()){
		            String line = scan.nextLine().toString();
		            if(line.contains(searchStr)){
		            	System.out.println(searchStr);
		            	connected=true;
		            }else if(line.contains(searchStr1)){
		            	System.out.println(searchStr1);
		            	connected=true;
		            }
		        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String max = (connected == true) ? "yes" : "no";
		return max;
	}
}
