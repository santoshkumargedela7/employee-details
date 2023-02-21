package com.siva.EmployeeDetails;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class EmployeeDetailsApplication {


    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetailsApplication.class, args);
		/*
		 * DefaultHttpClient client = new DefaultHttpClient(); try { HttpGet getRequest
		 * = new HttpGet("http://localhost:8181/emp/all");
		 * getRequest.addHeader("accept","application/xml");
		 * org.apache.http.HttpResponse response = client.execute(getRequest);
		 * 
		 * int statusCode = response.getStatusLine().getStatusCode();
		 * if(statusCode!=200) { throw new
		 * RuntimeException("Failed With Http Error Code:"+statusCode); }
		 * 
		 * HttpEntity httpEntity = response.getEntity(); String apiOutput =
		 * EntityUtils.toString(httpEntity);
		 * 
		 * System.out.println(apiOutput); JAXBContext jaxbContext =
		 * JAXBContext.newInstance(Employee.class); Unmarshaller jaxbUnmarshaller =
		 * jaxbContext.createUnmarshaller(); Employee employee = (Employee)
		 * jaxbUnmarshaller.unmarshal(new StringReader(apiOutput));
		 * System.out.println(employee.getId());
		 * System.out.println(employee.getFirstName());
		 * System.out.println(employee.getLastName());
		 * System.out.println(employee.getAddress());
		 * System.out.println(employee.getAge());
		 * System.out.println(employee.getIsActive());
		 * System.out.println(employee.getEmployeeData());
		 * 
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * finally { client.getConnectionManager().shutdown(); }
		 */
	}
	
	

}
