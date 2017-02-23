package uo.asw.participants.controller;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uo.asw.Application;
import uo.asw.participants.util.Check;
import uo.asw.participants.util.CitizenMin;
import uo.asw.participants.util.DateUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UtilTest {

	
	private CitizenMin citizenMin;
	
	
    @Before
    public void setUp() throws Exception {
    	citizenMin = new CitizenMin("nombre", "apellido", new Date(), (long) 1, "usuario@gmail.com");
    }

	@Test
	public void newCitizenMinTest() {
		
		Long id = (long) 2;
		String nombre = "fernando";
		String apellidos = "sanchez";
		Date fechaNacimiento = new Date();
		int edad = DateUtil.getYears(fechaNacimiento);
		String email = "fernando@gmail.com";

		citizenMin.setId(id);
		citizenMin.setFirstName(nombre);
		citizenMin.setLastName(apellidos);
		citizenMin.setEdad(edad);
		citizenMin.setEmail(email);

	
		assertEquals(id, citizenMin.getId());
		assertEquals(nombre, citizenMin.getFirstName());
		assertEquals(apellidos, citizenMin.getLastName());
		assertEquals(edad, citizenMin.getEdad());
		assertEquals(email, citizenMin.getEmail());
		
	}
	
	
	@Test
	public void dateUtilTest() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		
		//Ya ha cumplido años
		String dateString1 = "10-02-1990";
		Date date1 = sdf.parse(dateString1);
		int edad1 = DateUtil.getYears(date1);
		assertEquals(26, edad1);

		//Aun no ha cumplido años
		String dateString2 = "10-08-1990";
		Date date2 = sdf.parse(dateString2);
		int edad2 = DateUtil.getYears(date2);
		assertEquals(27, edad2);
	}
	
	@Test
	public void checkTest(){
		
		assertTrue(Check.validateEmail("juan@gmail.com"));
		assertTrue(Check.validateEmail("juan@uniovi.es"));
		
		assertFalse(Check.validateEmail("usuario"));
		assertFalse(Check.validateEmail("usuario@gmail"));
		assertFalse(Check.validateEmail("usuario.com"));

	}
}
