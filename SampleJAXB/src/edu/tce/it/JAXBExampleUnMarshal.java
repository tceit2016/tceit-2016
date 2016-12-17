package edu.tce.it;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBExampleUnMarshal {
	public static void main(String[] args) {

	 try {

		File file = new File("D:\\jaxbFile.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
		System.out.println("Id:" +customer.getId());
		System.out.println("Name: " +customer.getName());
		System.out.println("Age: "+customer.getAge());

	  } catch (JAXBException e) {
		e.printStackTrace();
	  }

	}
}