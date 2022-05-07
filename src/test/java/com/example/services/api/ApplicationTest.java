package com.example.services.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.services.api.test.controller.TestController;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
    }

	@Test
	public void testTestController() throws Exception {
		// 测试TestController
		RequestBuilder request;

		// 1、get查一下user列表，应该为空
		request = post("/test/echo").contentType(MediaType.APPLICATION_JSON)
				.content("{\"msg\":\"hello\"}");
		mvc.perform(request).andExpect(status().isOk());
	}
}
