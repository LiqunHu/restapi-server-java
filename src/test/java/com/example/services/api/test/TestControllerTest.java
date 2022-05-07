package com.example.services.api.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.services.api.test.controller.TestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class TestControllerTest {
	
//	private MockMvc mvc;

//    @Before
//    public void setUp() {
//        mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
//    }

	@Test
	public void testTestController() throws Exception {
		// 测试TestController
		RequestBuilder request;

		MockMvc mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
		
		// 1、get查一下user列表，应该为空
		request = post("/test/echo").contentType(MediaType.APPLICATION_JSON)
				.content("{\"msg\":\"hello\"}");
		mvc.perform(request).andExpect(status().isOk());
	}

}
