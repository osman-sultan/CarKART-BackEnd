package com.example.CarMarketplace;

import com.example.CarMarketplace.controller.dto.CompanyDto;
import com.example.CarMarketplace.controller.exceptions.CompanyNotFoundException;
import com.example.CarMarketplace.model.entity.Car;
import com.example.CarMarketplace.model.entity.Company;
import com.example.CarMarketplace.model.repository.CompanyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CompanyTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired ObjectMapper objectMapper;

	@Autowired
	private CompanyRepository companyRepository;

	@Test
	void getCompany() throws Exception {

		// Perform the GET request
		MockHttpServletResponse response = mockMvc.perform(get("/company/BMW"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());

		// Convert the response to a JSON object
		ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
		// Make sure all attributes are correct using .get()
		assertEquals("BMW", receivedJson.get("make").textValue());
		assertEquals("Germany", receivedJson.get("country").textValue());
		assertEquals(1916, receivedJson.get("yearFounded").intValue());
		assertEquals("BMW", receivedJson.get("make").textValue());
		assertEquals("Munich", receivedJson.get("hq").textValue());
	}

	@Test
	void addCompany() throws Exception{

		// Create new JSON object containing necessary details
		ObjectNode companyJson = objectMapper.createObjectNode();
		companyJson.put("make", "JacobCars");
		companyJson.put("country", "Canada");
		companyJson.put("yearFounded", 2002);
		companyJson.put("hq", "Toronto");
		companyJson.put("logoURL", "www.test.com");

		// Send a POST request and retrieve the response
		MockHttpServletResponse response = mockMvc.perform(
						post("/company").
								contentType("application/json").
								content(companyJson.toString()))
				.andReturn().getResponse();

		// assert HTTP code of response is 200 OK
		assertEquals(200, response.getStatus());

		assertTrue(companyRepository.findById("JacobCars").isPresent());
		Company addedCompany = companyRepository.findById("JacobCars").get();

		assertEquals("JacobCars", addedCompany.getMake());
		assertEquals("Canada", addedCompany.getCountry());
		assertEquals(2002, addedCompany.getYearFounded());
		assertEquals("Toronto", addedCompany.getHq());
		assertEquals("www.test.com", addedCompany.getLogoURL());
	}

	@Test
	void updateCompany() throws Exception{

		// Create new JSON object containing details you would like to update
		ObjectNode companyJson = objectMapper.createObjectNode();
		companyJson.put("make", "SEAT");
		companyJson.put("country", "Canada");
		companyJson.put("yearFounded", 2009);
		companyJson.put("hq", "Toronto");
		companyJson.put("logoURL", "www.test.com");

		// Send a PUT request to update and retrieve the response
		MockHttpServletResponse response = mockMvc.perform(
						put("/company/SEAT").
								contentType("application/json").
								content(companyJson.toString()))
				.andReturn().getResponse();

		// assert HTTP code of response is 200 OK
		assertEquals(200, response.getStatus());

		assertTrue(companyRepository.findById("SEAT").isPresent());
		Company updatedCompany = companyRepository.findById("SEAT").get();

		assertEquals("SEAT", updatedCompany.getMake());
		assertEquals("Canada", updatedCompany.getCountry());
		assertEquals(2009, updatedCompany.getYearFounded());
		assertEquals("Toronto", updatedCompany.getHq());
		assertEquals("www.test.com", updatedCompany.getLogoURL());
	}

	@Test
	void deleteCompany() throws Exception{

		Company c = new Company();
		c.setMake("Kevin Mobile");
		c.setCountry("South Korea");
		c.setYearFounded(1945);
		c.setHq("Seoul");
		c.setLogoURL("https://www.linkedin.com/in/kevinsunghookim/");
		companyRepository.save(c);


		MockHttpServletResponse response = mockMvc.perform(
						delete("/company/Kevin Mobile").
								contentType("application/json"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());
		assertTrue(companyRepository.findById("Kevin Mobile").isEmpty());
	}

}
