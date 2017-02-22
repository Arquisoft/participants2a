package uo.asw.participants.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import uo.asw.Application;
import uo.asw.dbManagement.CitizenDAO;
import uo.asw.dbManagement.model.Citizen;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class WebControllerTest {

    @Autowired
    private WebApplicationContext wac;
 
    private MockMvc mockMvc;
     
    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    @Test
	 //usuario y contraseña correctos
    public void showInfoTest1() throws Exception {

      mockMvc.perform(post("/info")
		.param("user", "juan")
		.param("password", "1234"))
      	.andExpect(status().isOk())
      	.andExpect(model().attributeExists("resultado"))
      	.andExpect(view().name("view"));
    	
    }

    
    @Test
    //usuario incorrecto
    public void showInfoTest2() throws Exception {
    	
        mockMvc.perform(get("/info")
    	.param("user", "usuario")
		.param("password", "1234"))
        .andExpect(status().is4xxClientError());

    }
    
    @Test
    //contraseña incorrecta
    public void showInfoTest3() throws Exception {

       	mockMvc.perform(get("/info")
    	.param("user", "juan")
		.param("password", "password"))
      	.andExpect(status().is4xxClientError());
   
    }
    
    
   @Test
   public void showViewTest() throws Exception {
       mockMvc.perform(get("/"))
           .andExpect(status().isOk())
           .andExpect(view().name("log"));
   }
    
}
