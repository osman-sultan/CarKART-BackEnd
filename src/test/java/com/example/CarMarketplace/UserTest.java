package com.example.CarMarketplace;

import com.example.CarMarketplace.controller.exceptions.CarNotFoundException;
import com.example.CarMarketplace.controller.exceptions.UserNotFoundException;
import com.example.CarMarketplace.model.entity.Car;
import com.example.CarMarketplace.model.entity.Review;
import com.example.CarMarketplace.model.entity.User;
import com.example.CarMarketplace.model.repository.CarRepository;
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
class UserTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired ObjectMapper objectMapper;

	@Autowired
	private UserRepository userRepository;

	@Test
	void getUser() throws Exception {

		// Perform the GET request
		MockHttpServletResponse response = mockMvc.perform(get("/users/1"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());

		// Convert the response to a JSON object
		ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
		// Make sure all attributes are correct using .get()
		assertEquals(1L, receivedJson.get("id").longValue());
		assertEquals("user1", receivedJson.get("username").textValue());
		assertEquals("Bart", receivedJson.get("firstName").textValue());
		assertEquals("Holomew", receivedJson.get("lastName").textValue());
		assertEquals("b.holomew@email.com", receivedJson.get("email").textValue());
		assertEquals("bholomew", receivedJson.get("password").textValue());
		assertEquals("123 Hello St.", receivedJson.get("address").textValue());
	}

	@Test
	void addUser() throws Exception{

		// Create new JSON object containing necessary details
		ObjectNode userJson = objectMapper.createObjectNode();
		userJson.put("id", 12345L);
		userJson.put("username", "Antone123");
		userJson.put("firstName", "Anton");
		userJson.put("lastName", "Jacob");
		userJson.put("email", "antonm@jacob.com");
		userJson.put("password", "bruh");
		userJson.put("address", "1 Church St.");

		// Send a POST request and retrieve the response
		MockHttpServletResponse response = mockMvc.perform(
						post("/users").
								contentType("application/json").
								content(userJson.toString()))
				.andReturn().getResponse();

		// assert HTTP code of response is 200 OK
		assertEquals(200, response.getStatus());

		assertTrue(userRepository.findById(12345L).isPresent());
		User addedUser = userRepository.findById(12345L).get();

		assertEquals(12345L, addedUser.getId());
		assertEquals("Antone123", addedUser.getUsername());
		assertEquals("Anton", addedUser.getFirstName());
		assertEquals("Jacob", addedUser.getLastName());
		assertEquals("antonm@jacob.com", addedUser.getEmail());
		assertEquals("bruh", addedUser.getPassword());
		assertEquals("1 Church St.", addedUser.getAddress());
	}

	@Test
	void updateUser() throws Exception{

		// Create new JSON object containing details you would like to update
		ObjectNode userJson = objectMapper.createObjectNode();
		userJson.put("id", 2L);
		userJson.put("username", "Ossyman2");
		userJson.put("firstName", "Ossy");
		userJson.put("lastName", "Kim");
		userJson.put("email", "yes@gmail.com");
		userJson.put("password", "OssyMan123#");
		userJson.put("address", "23 Sandford Fleming St.");

		// Send a PUT request to update and retrieve the response
		MockHttpServletResponse response = mockMvc.perform(
						put("/users/2").
								contentType("application/json").
								content(userJson.toString()))
				.andReturn().getResponse();

		// assert HTTP code of response is 200 OK
		assertEquals(200, response.getStatus());

		assertTrue(userRepository.findById(2L).isPresent());
		User updatedUser = userRepository.findById(2L).get();

		assertEquals(2L, updatedUser.getId());
		assertEquals("Ossyman2", updatedUser.getUsername());
		assertEquals("Ossy", updatedUser.getFirstName());
		assertEquals("Kim", updatedUser.getLastName());
		assertEquals("yes@gmail.com", updatedUser.getEmail());
		assertEquals("OssyMan123#", updatedUser.getPassword());
		assertEquals("23 Sandford Fleming St.", updatedUser.getAddress());
	}

	@Test
	void deleteUser() throws Exception{

		User u = new User();
		u.setId(1000L);
		u.setUsername("LetsGoBrandon");
		u.setFirstName("Joe");
		u.setLastName("Brandon");
		u.setEmail("JoeB@POTUS.com");
		u.setPassword("IamPresidentLOL");
		u.setAddress("White House (?)");
		userRepository.save(u);

		MockHttpServletResponse response = mockMvc.perform(
						delete("/users/1000").
								contentType("application/json"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());
		assertTrue(userRepository.findById(1000L).isEmpty());
	}

}
