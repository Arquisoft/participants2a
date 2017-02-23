package uo.asw.participants.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import uo.asw.Application;
import uo.asw.dbManagement.CitizenDAO;
import uo.asw.dbManagement.model.Citizen;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration

public class DBTest {

	
	@Autowired
    private CitizenDAO citizenDAO;
	
	@Test
    public void getExistingCitizen() throws Exception {
    	Citizen c1 = citizenDAO.getParticipant("juan", "1234");
    	Citizen c2 = citizenDAO.getParticipant("pedro", "1234");
    	Citizen c3 = citizenDAO.getParticipant("raul", "1234");

		assertEquals("juan", c1.getNombreUsuario());
		assertTrue(c1.checkPassword("1234"));
		
		assertEquals("pedro", c2.getNombreUsuario());
		assertTrue(c2.checkPassword("1234"));

		assertEquals("raul", c3.getNombreUsuario());
		assertTrue(c3.checkPassword("1234"));
    }
    
    @Test
    public void getNonExistingCitizen() throws Exception {
    	Citizen c1 = citizenDAO.getParticipant("antonio", "1234");
    	Citizen c2 = citizenDAO.getParticipant("daniel", "1234");
    	Citizen c3 = citizenDAO.getParticipant("rodrigo", "1234");

    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);

     }
    
    @Test
    public void wrongPasswordTest() throws Exception {
    	
    	Citizen c1 = citizenDAO.getParticipant("juan", "password");
    	Citizen c2 = citizenDAO.getParticipant("pedro", "password");
    	Citizen c3 = citizenDAO.getParticipant("raul", "password");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void wrongUserPasswordTest() throws Exception {
    	
    	Citizen c1 = citizenDAO.getParticipant("juan@gmail.com", "password");
    	Citizen c2 = citizenDAO.getParticipant("pedro@gmail.com", "password");
    	Citizen c3 = citizenDAO.getParticipant("raul@gmail.com", "password");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void updateTest() throws Exception {
    	
    	Citizen c1 = citizenDAO.getParticipant("juan", "1234");
    	
    	//Cambio de contraseña
    	c1.setAndHashContraseña("new password");
       	citizenDAO.updateInfo(c1);
       
       	assertTrue(c1.checkPassword("new password"));
       	
       	//Cambio de contraseña por la original
       	c1.setAndHashContraseña("1234");
       	citizenDAO.updateInfo(c1);

		assertTrue(c1.checkPassword("1234"));

        	
    }

}