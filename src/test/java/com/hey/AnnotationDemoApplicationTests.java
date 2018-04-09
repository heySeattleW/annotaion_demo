package com.hey;

import com.hey.web.controller.TestController;
import com.hey.web.service.HelloService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationDemoApplicationTests {

	@Autowired
	private HelloService helloService;

	//构造controller的测试
	private MockMvc mockMvc;

	private static final Logger logger = LoggerFactory.getLogger(AnnotationDemoApplicationTests.class);

	//测试controller以外的其他方法，需要注入依赖
	@Test
	public void contextLoads() {
		helloService.hello();
	}

	//测试controller的初始化，传入需要测试的controller的class
	@Before
	public void setUp()throws Exception{
		//初始化
		mockMvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
	}

	//测试controller
	@Test
	public void hello()throws Exception{
		String url = "/hello";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)).andReturn();
		logger.info(result.getResponse().getContentAsString()+"+++++");

	}

}
