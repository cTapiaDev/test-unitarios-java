package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ejemplo.principal.Clase;
import com.ejemplo.servicio.Servicio;

@ExtendWith(MockitoExtension.class)
public class MiTest {
    
    @Mock private Servicio servicio;
    @InjectMocks private Clase clase;

    @Test
    public void testConMock() {
        when(servicio.getDato()).thenReturn("Mockeado");
        String resultado = clase.metodo();
        assertEquals("Mockeado", resultado);
    }

}
