package com.exam;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.exam.prime.common.PrimeNumAlgoExecutor;
import com.exam.prime.service.SelectAlgorithmService;

@ContextConfiguration(classes = SelectAlgorithmService.class)
@RunWith(SpringRunner.class)
@WebMvcTest
public class PrimeNumberUnitTest2 {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	PrimeNumAlgoExecutor primeNumAlgoExecutor;
	@MockBean
	SelectAlgorithmService selectAlgorithmService;
	
	@Test
	public void contextLoads() throws Exception{
		
		List<Integer> data = new ArrayList<>();
		data.add(2);
		data.add(3);
		
		
//		when(primeNumAlgoExecutor.genPrimeNumsNaiveAlgo(5)).thenReturn((List<Integer>) Stream
//		.of(new Integer(2), new Integer(3),new Integer(5)).collect(Collectors.toList()));
//
//		assertEquals(3, primeNumAlgoExecutor.genPrimeNumsNaiveAlgo(5).size());
	 
		
		
		when(selectAlgorithmService.selectAlgo("NA", 3)).thenReturn(data);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/primeNumGen/").accept(MediaType.APPLICATION_JSON)
				).andReturn();
		System.out.println(mvcResult.getResponse());
		verify(selectAlgorithmService).selectAlgo("NA", 3);
	}

}
