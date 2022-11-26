package com.example.CarMarketplace;

import com.example.CarMarketplace.controller.exceptions.CompanyNotFoundException;
import com.example.CarMarketplace.controller.exceptions.UserNotFoundException;
import com.example.CarMarketplace.model.entity.Car;
import com.example.CarMarketplace.model.entity.Company;
import com.example.CarMarketplace.model.entity.User;
import com.example.CarMarketplace.model.repository.CarRepository;
import com.example.CarMarketplace.model.repository.CompanyRepository;
import com.example.CarMarketplace.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CarTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired ObjectMapper objectMapper;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	void getCar() throws Exception {

		// Perform the GET request
		MockHttpServletResponse response = mockMvc.perform(get("/cars/1"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());

		// Convert the response to a JSON object
		ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
		// Make sure all attributes are correct using .get()
		assertEquals(1L, receivedJson.get("id").longValue());
		assertEquals("BMW", receivedJson.get("company").get("make").textValue());
		assertEquals(1L, receivedJson.get("seller").get("id").longValue() );
		assertEquals("316", receivedJson.get("model").textValue());
		assertEquals(2011, receivedJson.get("releaseYear").intValue());
		assertEquals("Diesel", receivedJson.get("fuelType").textValue());
		assertEquals(6800, receivedJson.get("price").doubleValue());
		assertEquals("Sedan", receivedJson.get("vehicleType").textValue());
		assertEquals(116, receivedJson.get("hp").doubleValue());
		assertEquals(235000, receivedJson.get("mileage").doubleValue());
		assertEquals("Pearl", receivedJson.get("colour").textValue());
		assertEquals("Manual", receivedJson.get("transmission").textValue());

	}

	@Test
	void addCar() throws Exception{

		// Create new JSON object containing necessary details
		ObjectNode carJson = objectMapper.createObjectNode();
		carJson.put("id", 100L);
		carJson.put("make", "BMW");
		carJson.put("sellerId", 2L);
		carJson.put("model", "E36");
		carJson.put("releaseYear", 1996);
		carJson.put("fuelType", "Gasoline");
		carJson.put("price", 45000);
		carJson.put("vehicleType", "Drag");
		carJson.put("hp", 250);
		carJson.put("mileage", 100000);
		carJson.put("colour", "Blue");
		carJson.put("transmission", "Manual");
		carJson.put("carURL", "www.test.com");

		// Send a POST request and retrieve the response
		MockHttpServletResponse response = mockMvc.perform(
						post("/cars").
								contentType("application/json").
								content(carJson.toString()))
				.andReturn().getResponse();

		// assert HTTP code of response is 200 OK
		assertEquals(200, response.getStatus());

		assertTrue(carRepository.findById(100L).isPresent());
		Car addedCar = carRepository.findById(100L).get();

		assertEquals(100L, addedCar.getId());
		assertEquals("BMW", addedCar.getCompany().getMake());
		assertEquals(2L, addedCar.getSeller().getId());
		assertEquals("E36", addedCar.getModel());
		assertEquals(1996, addedCar.getReleaseYear());
		assertEquals("Gasoline", addedCar.getFuelType());
		assertEquals(45000, addedCar.getPrice());
		assertEquals("Drag", addedCar.getVehicleType());
		assertEquals(250, addedCar.getHp());
		assertEquals(100000, addedCar.getMileage());
		assertEquals("Blue", addedCar.getColour());
		assertEquals("Manual", addedCar.getTransmission());
		assertEquals("www.test.com", addedCar.getCarURL());
	}

	@Test
	void updateCar() throws Exception{

		// Create new JSON object containing details you would like to update
		ObjectNode carJson = objectMapper.createObjectNode();
		carJson.put("id", 3L);
		carJson.put("make", "SEAT");
		carJson.put("sellerId", 2L);
		carJson.put("model", "E36");
		carJson.put("releaseYear", 2002);
		carJson.put("fuelType", "Gasoline");
		carJson.put("price", 15000);
		carJson.put("vehicleType", "Drag");
		carJson.put("hp", 100);
		carJson.put("mileage", 100000);
		carJson.put("colour", "Blue");
		carJson.put("transmission", "Manual");
		carJson.put("carURL", "www.test.com");

		// Send a PUT request to update and retrieve the response
		MockHttpServletResponse response = mockMvc.perform(
						put("/cars/3").
								contentType("application/json").
								content(carJson.toString()))
				.andReturn().getResponse();

		// assert HTTP code of response is 200 OK
		assertEquals(200, response.getStatus());

		assertTrue(carRepository.findById(3L).isPresent());
		Car updatedCar = carRepository.findById(3L).get();

		assertEquals(3L, updatedCar.getId());
		assertEquals("SEAT", updatedCar.getCompany().getMake());
		assertEquals(2L, updatedCar.getSeller().getId());
		assertEquals("E36", updatedCar.getModel());
		assertEquals(2002, updatedCar.getReleaseYear());
		assertEquals("Gasoline", updatedCar.getFuelType());
		assertEquals(15000, updatedCar.getPrice());
		assertEquals("Drag", updatedCar.getVehicleType());
		assertEquals(100, updatedCar.getHp());
		assertEquals(100000, updatedCar.getMileage());
		assertEquals("Blue", updatedCar.getColour());
		assertEquals("Manual", updatedCar.getTransmission());
		assertEquals("www.test.com", updatedCar.getCarURL());
	}

	@Test
	void deleteCar() throws Exception{

		Car c = new Car();
		c.setId(12345L);
		Company company = companyRepository.findById("BMW").orElseThrow(
				() -> new CompanyNotFoundException("BMW"));
		c.setCompany(company);
		User seller = userRepository.findById(1L).orElseThrow(
				() -> new UserNotFoundException(1L));
		c.setSeller(seller);
		c.setModel("M3");
		c.setReleaseYear(2009);
		c.setFuelType("Gasoline");
		c.setPrice(20000);
		c.setVehicleType("sedan");
		c.setHp(360);
		c.setMileage(20000);
		c.setColour("Black");
		c.setTransmission("Automatic");
		c.setCarURL("www.test.com");
		carRepository.save(c);

		MockHttpServletResponse response = mockMvc.perform(
						delete("/cars/12345").
								contentType("application/json"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());
		assertTrue(carRepository.findById(12345L).isEmpty());
	}
}
