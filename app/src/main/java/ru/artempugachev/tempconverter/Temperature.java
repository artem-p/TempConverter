package ru.artempugachev.tempconverter;

/**
 * Created by artem on 07.04.15.
 */
public class Temperature {
    float celsius;
    float fahrenheit;

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

    }

    public void fahrrenheitToCelsius() {
        //  tC = 5/9 (tF - 32)

    }
}