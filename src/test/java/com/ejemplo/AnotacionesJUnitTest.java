package com.ejemplo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AnotacionesJUnitTest {

    private String datoDePruebaPorTest;
    private int contadorCompartidoModulo;


    @BeforeAll
    @DisplayName("Configuración Inicial de Pruebas")
    void configurarTodasLasPruebas() {
        System.out.println("--------------------------------------");
        System.out.println(">>> @BeforeAll: Iniciando la configuración global de Tests");
        this.contadorCompartidoModulo = 10;
        System.out.println("    Contador compartido inicializado en: " + this.contadorCompartidoModulo);       
    }


    @BeforeEach
    @DisplayName("Preparación Antes de Cada Test")
    void configurarCadaPrueba() {
        this.datoDePruebaPorTest = "Valor_Inicial_Por_Test";
        System.out.println("  >>> @BeforeEach: Preparando el ambiente para un nuevo test:" + datoDePruebaPorTest);
        this.contadorCompartidoModulo++;
        System.out.println("      Contador compartido incrementando a: " + this.contadorCompartidoModulo);
    }

    @Test
    @DisplayName("Test 1: Suma")
    void testSumaBasica() {
        System.out.println("    >>> @Test: Ejecutando Test de Suma");
        int resultado = 5 + 3;
        assertEquals(8, resultado, "La suma de 5 + 3 debe ser 8");
        this.datoDePruebaPorTest = "Valor_Modificado_En_Test1";
        System.out.println("      Dato de Prueba Modificado: " + datoDePruebaPorTest);
    }

    @Test
    @DisplayName("Test 2: Comparación de Dato de Prueba")
    void testDatoComparado() {
        System.out.println("    >>> @Test: Ejecutando Test de Comparación");
        assertEquals("Valor_Inicial_Por_Test", datoDePruebaPorTest, "El dato debe ser el mismo que viene de @BeforeEach");
        assertTrue(this.contadorCompartidoModulo > 10, "El contador ya debería ser mayor a 10");
        System.out.println("      Contador compartido actual:" + contadorCompartidoModulo);
    }

    @Test
    @Disabled
    @DisplayName("Test 3: Deshabilitado")
    void testDeshabilitado() {
        System.out.println("¡¡¡ERROR!!!");
    }

    @AfterEach
    @DisplayName("Ejecución luego de cada Test")
    void desmontarCadaPrueba() {
        System.out.println("  >>> @AfterEach: Limpiando el test: " + this.datoDePruebaPorTest);
        this.datoDePruebaPorTest = null;
    }

    @AfterAll
    @DisplayName("Limpieza Final de los Test")
    void desmontarTodasLasPruebas() {
        System.out.println(">>> @AfterAll: Finalizando todos los Tests");
        System.out.println("  Contador:" + this.contadorCompartidoModulo);
        System.out.println("--------------------------------------");
    }
    
}
