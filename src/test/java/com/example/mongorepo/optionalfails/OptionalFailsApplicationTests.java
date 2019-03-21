package com.example.mongorepo.optionalfails;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.hamcrest.Matchers.containsString;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class OptionalFailsApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	protected MockMvc mvc;

	@LocalServerPort
	int randomServerPort;

	final String baseUrl = "http://localhost:"+randomServerPort ;

	@Before
	public void setup() throws Exception {
		this.mvc = webAppContextSetup(this.webApplicationContext)
				.build();
	}

	@Test
	public void testSaveAndGetWithOptional() throws Exception {
		mvc.perform(post("/dataWithOptional/abc")).andExpect(status().isOk());
		mvc.perform(get("/dataWithOptional")).andExpect(status().isOk());
	}
}
