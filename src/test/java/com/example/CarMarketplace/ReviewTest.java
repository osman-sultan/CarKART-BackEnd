package com.example.CarMarketplace;

import com.example.CarMarketplace.controller.exceptions.CarNotFoundException;
import com.example.CarMarketplace.controller.exceptions.CompanyNotFoundException;
import com.example.CarMarketplace.controller.exceptions.UserNotFoundException;
import com.example.CarMarketplace.model.entity.Car;
import com.example.CarMarketplace.model.entity.Company;
import com.example.CarMarketplace.model.entity.Review;
import com.example.CarMarketplace.model.entity.User;
import com.example.CarMarketplace.model.repository.CarRepository;
import com.example.CarMarketplace.model.repository.CompanyRepository;
import com.example.CarMarketplace.model.repository.ReviewRepository;
import com.example.CarMarketplace.model.repository.UserRepository;
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

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CarRepository carRepository;

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
		assertEquals(1L, receivedJson.get("user").get("id").longValue());
		assertEquals(1L, receivedJson.get("car").get("id").longValue());
		assertEquals("09/27/2022", receivedJson.get("dateTimeStamp").textValue());
		assertEquals("Amazing car!", receivedJson.get("reviewText").textValue());
	}

	@Test
	void addReview() throws Exception{

		// Create new JSON object containing necessary details
		ObjectNode reviewJson = objectMapper.createObjectNode();
		reviewJson.put("id", 12345L);
		reviewJson.put("userId", 2L);
		reviewJson.put("carId", 2L);
		reviewJson.put("dateTimeStamp", "11/22/2022");
		reviewJson.put("reviewText", "Nice");

		// Send a POST request and retrieve the response
		MockHttpServletResponse response = mockMvc.perform(
						post("/reviews").
								contentType("application/json").
								content(reviewJson.toString()))
				.andReturn().getResponse();

		// assert HTTP code of response is 200 OK
		assertEquals(200, response.getStatus());

		assertTrue(reviewRepository.findById(12345L).isPresent());
		Review addedReview = reviewRepository.findById(12345L).get();

		assertEquals(12345L, addedReview.getId());
		assertEquals(2L, addedReview.getUser().getId());
		assertEquals(2L, addedReview.getCar().getId());
		assertEquals("11/22/2022", addedReview.getDateTimeStamp());
		assertEquals("Nice", addedReview.getReviewText());
	}

	@Test
	void updateReview() throws Exception{

		// Create new JSON object containing details you would like to update
		ObjectNode reviewJson = objectMapper.createObjectNode();
		reviewJson.put("id",2L);
		reviewJson.put("userId", 3L);
		reviewJson.put("carId", 2L);
		reviewJson.put("dateTimeStamp", "11/26/2010");
		reviewJson.put("reviewText", "L Car");

		// Send a PUT request to update and retrieve the response
		MockHttpServletResponse response = mockMvc.perform(
						put("/reviews/2").
								contentType("application/json").
								content(reviewJson.toString()))
				.andReturn().getResponse();

		// assert HTTP code of response is 200 OK
		assertEquals(200, response.getStatus());

		assertTrue(reviewRepository.findById(2L).isPresent());
		Review updatedReview = reviewRepository.findById(2L).get();

		assertEquals(2L, updatedReview.getId());
		assertEquals(3L, updatedReview.getUser().getId());
		assertEquals(2L, updatedReview.getCar().getId());
		assertEquals("11/26/2010", updatedReview.getDateTimeStamp());
		assertEquals("L Car", updatedReview.getReviewText());
	}

	@Test
	void deleteReview() throws Exception{

		Review r = new Review();
		r.setId(1000L);
		User user = userRepository.findById(1L).orElseThrow(
				() -> new UserNotFoundException(1L));
		r.setUser(user);
		Car car = carRepository.findById(3L).orElseThrow(
				() -> new CarNotFoundException(1L));
		r.setCar(car);
		r.setDateTimeStamp("12/25/2024");
		r.setReviewText("Joe Biden's car");
		reviewRepository.save(r);

		MockHttpServletResponse response = mockMvc.perform(
						delete("/reviews/1000").
								contentType("application/json"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());
		assertTrue(reviewRepository.findById(1000L).isEmpty());
	}
}
