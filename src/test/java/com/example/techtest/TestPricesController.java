package com.example.techtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestPricesController {

    @Autowired
    private MockMvc mvc;

    @Test
    /*
     * Test 1: request at 10:00 a.m. on the 14th for product 35455 for brand 1 (XYZ)
     */
    public void test1() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices?product-id=35455&brand-id=1&date=2020-06-14.10:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.5f));
    }

    @Test
    /*
     * Test 2: request at 4:00 p.m. on the 14th for product 35455 for brand 1 (XYZ)
     */
    public void test2() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices?product-id=35455&brand-id=1&date=2020-06-14.16:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45f));
    }

    @Test
    /*
     * Test 3: request at 9:00 p.m. on day 14th for product 35455 for brand 1 (XYZ)
     */
    public void test3() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices?product-id=35455&brand-id=1&date=2020-06-14.21:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.5f));
    }

    @Test
    /*
     * Test 4: request at 10:00 a.m. on the 15th for product 35455 for brand 1 (XYZ))
     */
    public void test4() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices?product-id=35455&brand-id=1&date=2020-06-15.10:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.5f));
    }

    @Test
    /*
     * Test 5: request at 9:00 p.m. on day 16th for product 35455 for brand 1 (XYZ)
     */
    public void test5() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices?product-id=35455&brand-id=1&date=2020-06-16.09:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95f));
    }
}
