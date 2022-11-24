package com.example.CarMarketplace;

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

}
