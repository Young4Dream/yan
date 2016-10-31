package com.springMVC.spittr.web;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.springMVC.spittr.Spittle;
import com.springMVC.spittr.data.SpittleRepository;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class SpringMVCTest {

	/**
	 * Test HomeController
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		HomeController homeController=new HomeController();
		MockMvc mockMvc=standaloneSetup(homeController).build();
		mockMvc.perform(get("/"))//对"/"执行get请求
				.andExpect(view().name("home"));//断言视图名为home
	}
	@Test
	public void spittleControllerTest(){
		List<Spittle> expectedSpittles=createSpittleList(20);
		SpittleRepository mockSpittleRepository=mock(SpittleRepository.class);//mockito提供的静态方法
		when(mockSpittleRepository.findSpittle(Long.MAX_VALUE, 20)).
			thenReturn(expectedSpittles);//mockito提供的静态方法
		SpittleController spittleController=new SpittleController(mockSpittleRepository);
		MockMvc mockMvc=standaloneSetup(spittleController)
				.setSingleView(new InternalResourceView("/WebContent/WEB-INF/views/spittles.jsp"))
				.build();
		try {
			mockMvc.perform(get("/spittles"))
				.andExpect(view().name("spittles"));
				mockMvc.perform(get("/spittles")).andExpect(model().attributeExists("spittleList"))
				.andExpect(model()
				.attribute("list", hasItem(expectedSpittles.toArray())));//hamcrest提供hasItem静态方法
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 创建一个新的spittle列表，每一项的命名都是spittle+数字，时间戳记为系统时间
	 * @param i
	 * @return
	 */
	private List<Spittle> createSpittleList(int i) {
		List<Spittle> spittleList=new ArrayList();
		for(int k=0;k<i;k++){
			spittleList.add(new Spittle("spittle"+i,new Date()));
		}
		return null;
	}

}
