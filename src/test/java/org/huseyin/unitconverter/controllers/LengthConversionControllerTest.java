package org.huseyin.unitconverter.controllers;

import org.huseyin.unitconverter.services.LengthConversionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * MVC Controller Unit test example. As part of this test, we ignore how the service works
 * (we don't need to know the conversion details, calculation, etc), instead we focus on
 * the behaviour and the responsibility of the controller.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LengthConversionController.class)
public class LengthConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LengthConversionService lengthConversionService;

    /**
     * Verifies centimetreToInch() method in LengthConversionService is called when a GET request to "/centimetre/1"
     * is sent. Response should be in JSON format with a status code of 200.
     * @throws Exception
     */
    @Test
    public void convertToInch() throws Exception {
        Mockito.when(lengthConversionService.centimetreToInch(anyDouble())).thenReturn(anyDouble());

        mockMvc.perform(get("/api/centimetre/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful());

        Mockito.verify(lengthConversionService).centimetreToInch(anyDouble());
    }

    @Test
    public void convertToCentimetre() throws Exception {
    }

}