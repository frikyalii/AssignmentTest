package com.capgemini.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.model.Branch;
import com.capgemini.services.branchService;
import com.fasterxml.jackson.databind.ObjectMapper;


//error in this page



@ExtendWith(MockitoExtension.class)
class branchControllerTest {


	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private branchService bs;
	private Branch b;
	private List<Branch> branchList;
	
	
	@InjectMocks
	private branchController bc;
	
	
	@BeforeEach
	public void init()
	{
		b= new Branch(12001,"12133","Gujarat");
		mockMvc = MockMvcBuilders.standaloneSetup(bc).build();
	}
	
	
	@Test
	public void testGetAllPopulationDataControllerTest() throws Exception{
		when(bs.getAllBranch()).thenReturn(branchList); 
		mockMvc.perform(MockMvcRequestBuilders.get("/Branch/getBranch") 
				.contentType(MediaType.APPLICATION_JSON) 
				.content (asJSONString(b))) 
				.andDo(MockMvcResultHandlers.print()); 
		verify(bs, times (1)).getAllBranch();
	}

	
	
	@Test
	public void testCreateBranchDataControllerTest() throws Exception
	{
		 when(bs.addBranch(any())).thenReturn(b);
		 mockMvc.perform(post("/Branch/postBranch")
				 .contentType(MediaType.APPLICATION_JSON) 
				 .content (asJSONString(b))) 
				 .andExpect(status().isCreated());
		 verify(bs, times (1)).addBranch(b);
	}
	

	public static String asJSONString(final Branch b)
	{
		try 
		{
			return new ObjectMapper().writeValueAsString(b);
		}
		catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
	}

	
	

}

