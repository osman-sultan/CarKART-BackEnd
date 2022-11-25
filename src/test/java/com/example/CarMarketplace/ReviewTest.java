package com.example.CarMarketplace;

import com.example.CarMarketplace.model.entity.Company;
import com.example.CarMarketplace.model.repository.CompanyRepository;
import com.example.CarMarketplace.model.repository.ReviewRepository;
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
class ReviewTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired ObjectMapper objectMapper;

	@Autowired
	private ReviewRepository reviewRepository;

	@Test
	void getReview() throws Exception {

		// Perform the GET request
		MockHttpServletResponse response = mockMvc.perform(get("/reviews/1"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());

		// Convert the response to a JSON object
		ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
		// Make sure all attributes are correct using .get()
		assertEquals(1L, receivedJson.get("id").longValue());
		assertEquals(1L, receivedJson.get("user").get("id"));
		assertEquals(1L, receivedJson.get("car").get("id"));
		assertEquals("09/27/2022", receivedJson.get("dateTimeStamp"));
		assertEquals("Amazing car!", receivedJson.get("reviewText"));
	}


}
