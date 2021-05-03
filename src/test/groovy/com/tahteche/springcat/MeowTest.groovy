package com.tahteche.springcat

import com.tahteche.springcat.controllers.Meow
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

import static org.junit.jupiter.api.Assertions.assertNotNull
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class MeowTest {
    @Autowired
    private Meow meow

    @Autowired
    private MockMvc mockMvc

    @Test
    void loadsMeow() {
        assertNotNull(meow)
    }

    @Test
    void getMeow() {
        mockMvc.perform(MockMvcRequestBuilders.get("/meow"))
                .andExpect(status().isOk())
                .andExpect(content().string("meow"))
    }
}
