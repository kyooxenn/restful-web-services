package com.in28minutes.rest.webservices.restfulwebservices;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import com.in28minutes.rest.webservices.restfulwebservices.user.UserDaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RestfulWebServicesApplicationTests {

	@Mock
	private DataService dataServiceMock;

	@InjectMocks
	private SomeBusinessImpl businessImpl;

	@Test
	void findTheGreatestFromAllData_basicScenario() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25,15,5});
		//System.out.println(Arrays.toString(dataServiceMock.retrieveAllData()));
		assertEquals(25,businessImpl.findTheGreatestFromAllData());
	}


/*	@Test
	void findTheGreatestFromAllData_OneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
		assertEquals(35,businessImpl.findTheGreatestFromAllData());
	}*/

	@Test
	void findTheGreatestFromAllData_EmptyArray() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
		System.out.println(Arrays.toString(dataServiceMock.retrieveAllData()));
		System.out.println(Integer.MIN_VALUE);
		assertEquals(Integer.MIN_VALUE,businessImpl.findTheGreatestFromAllData());
	}

}
