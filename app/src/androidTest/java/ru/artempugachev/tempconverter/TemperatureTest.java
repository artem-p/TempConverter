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

    public void testTrue() {
        assertTrue(true);
    }
}
