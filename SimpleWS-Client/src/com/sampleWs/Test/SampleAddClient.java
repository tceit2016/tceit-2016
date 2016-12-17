package com.sampleWs.Test;

import javax.xml.ws.WebServiceRef;

import com.mindfire.service.MathService;
import com.mindfire.service.MathServiceService;

public class SampleAddClient {

	public static void main(String...arg){
		//Instantiate the MathService Class
		MathServiceService mathService = new MathServiceService();
		//create a math stub
		MathService math = mathService.getMathService();
		
		System.out.println(math.add(20, 10));
		
		System.out.println(math.substract(20, 10));
	}
}
