package ru.artempugachev.tempconverter;

/**
 * Created by artem on 07.04.15.
 */
public class Temperature {
    private float celsius;
    private float fahrenheit;
    public final static float DEFAULT_TEMP = 99999;

    public Temperature() {
    }

    public float getCelsius() {
        return celsius;
    }

    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }

    public float getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(float fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public void celsiusToFahrenheit() {
        //  tf = tc*9/5 + 32

        float fahrTemp = this.getCelsius()*9/5 + 32;
        this.setFahrenheit(fahrTemp);
    }

    public void fahrrenheitToCelsius() {
        //  tC = 5/9 (tF - 32)

    }
}
