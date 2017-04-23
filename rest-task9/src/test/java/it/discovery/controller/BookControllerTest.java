package it.discovery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.discovery.bootstrap.RestApplication;
import it.discovery.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes=RestApplication.class)
public class BookControllerTest {
	@Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mockMvc;
    
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(
        		applicationContext).build();
    }

    @Test
    public void saveBook() throws Exception {
        Book book = new Book();
        book.setAuthor("author");
        mockMvc.perform(post("/book").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(MAPPER.writeValueAsString(book))).andExpect(status().isOk());
    }

    @Test
    public void getBook() throws Exception{
        mockMvc.perform(get("/book/1")).andExpect(status().isOk());
    }

}

