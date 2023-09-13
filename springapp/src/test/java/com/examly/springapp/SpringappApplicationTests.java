package com.examly.springapp;

import com.examly.springapp.model.Laptop;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.File;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddLaptopApi() throws Exception {
        Laptop laptopToAdd = new Laptop(1, "Brand", 1000);

        mockMvc.perform(MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(laptopToAdd)))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testGetLaptopByIdApi() throws Exception {
        int laptopId = 1;

        mockMvc.perform(MockMvcRequestBuilders.get("/{laptopId}", laptopId))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetAllLaptopsApi() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk());

    }

    @Test
    public void testcontrollerfolder() {
        String directoryPath = "src/main/java/com/examly/springapp/controller"; // Replace with the path to your
                                                                                // directory
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());
    }

    @Test
    public void testcontrollerfile() {
        String filePath = "src/main/java/com/examly/springapp/controller/LaptopController.java";
        // Replace with the path to your file
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    @Test
    public void testModelFolder() {
        String directoryPath = "src/main/java/com/examly/springapp/model"; // Replace with the path to your directory
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());
    }

    @Test
    public void testModelFile() {
        String filePath = "src/main/java/com/examly/springapp/model/Laptop.java";
        // Replace with the path to your file
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    @Test
    public void testServiceFolder() {
        String directoryPath = "src/main/java/com/examly/springapp/service"; // Replace with the path to your directory
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());
    }

    @Test
    public void testServieFile() {
        String filePath = "src/main/java/com/examly/springapp/service/ApiService.java";
        // Replace with the path to your file
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }
}
