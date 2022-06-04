package com.exam;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.exam.prime.bean.PrimeNumReq;
import com.exam.prime.common.PrimeNumAlgoExecutor;
import com.exam.prime.controller.PrimeNumController;
import com.exam.prime.service.SelectAlgorithmService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ContextConfiguration(classes = SelectAlgorithmService.class)
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PrimeNumController.class)
@ActiveProfiles(value = "IntegrationTest")
public class PrimeNumberIntegrationTest {

	/*
	 * @Autowired MockMvc mockMvc;
	 */

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private ObjectMapper mapper;

	/*
	 * @Autowired private TestRestTemplate template;
	 *
	 */
	@MockBean
	PrimeNumAlgoExecutor primeNumAlgoExecutor;
	@MockBean
	SelectAlgorithmService selectAlgorithmService;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@WithMockUser(username = "Shas", password = "Shas")
	@Test
	public void contextLoads() throws Exception {

		PrimeNumReq primeNumReq = new PrimeNumReq(3, "NA");
		String jsonRequest = mapper.writeValueAsString(primeNumReq);

		MvcResult result = mockMvc
				.perform(post("/api/primeNumGen").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
}
