package ru.artempugachev.tempconverter;

import junit.framework.TestCase;

/**
 * Created by artem on 07.04.15.
 */
public class TemperatureTest extends TestCase {
    protected Temperature temperature;

    protected void setUp() {
        temperature = new Temperature();
    }

    public void testEmptyTemperature() {
        assertEquals(Temperature.DEFAULT_TEMP, temperature.getCelsius());
        assertEquals(Temperature.DEFAULT_TEMP, temperature.getFahrenheit());
    }

    public void testCtoF() {
        //  42 °C = 107.6 °F
        temperature.setCelsius(42);
        temperature.celsiusToFahrenheit();
        float fahrTemp = temperature.getFahrenheit();
        float expectedFahr = (float) 107.6;
        assertEquals(expectedFahr, fahrTemp);

        // -50 = -58
        temperature.setCelsius(-50);
        temperature.celsiusToFahrenheit();
        fahrTemp = temperature.getFahrenheit();
        expectedFahr = (float) -58;
        assertEquals(expectedFahr, fahrTemp);

        // 0 = 32
        temperature.setCelsius(0);
        temperature.celsiusToFahrenheit();
        fahrTemp = temperature.getFahrenheit();
        expectedFahr = (float) 32;
        assertEquals(expectedFahr, fahrTemp);
    }

    public void testFtoC() {
        //32 0
        temperature.setFahrenheit(32);
        temperature.fahrrenheitToCelsius();
        float celsiusTemp = temperature.getCelsius();
        float expectedCelsius = (float) 0;
        assertEquals(expectedCelsius, celsiusTemp);

        // -58 = -50
        temperature.setFahrenheit(-58);
        temperature.fahrrenheitToCelsius();;
        celsiusTemp = temperature.getCelsius();
        expectedCelsius = (float) -50;
        assertEquals(expectedCelsius, celsiusTemp);

    }
}
