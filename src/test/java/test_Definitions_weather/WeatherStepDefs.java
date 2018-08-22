package test_Definitions_weather;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import thirdHometaskWeather.Response;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class WeatherStepDefs {
    private WeatherRequester weatherRequester = new WeatherRequester();
    private Response response;

    @When("we getting weather from server")
    public void get_weather() {
        response = weatherRequester.getWeather();
    }

    @Then("lon is (.*)")
    public void check_lon(BigDecimal lon) {
        assertEquals("Wrong LON", lon, response.getCoord().getLon());
    }

    @Then("lat is (.*)")
    public void check_lat(BigDecimal lat) {
        assertEquals("Wrong LAT", lat, response.getCoord().getLat());
    }

    @Then("weather id is (.*)")
    public void check_weather_id(Integer id) {
        Assert.assertEquals("Wrong id", id, response.getWeather().get(0).getId());
    }

    @Then("weather main is (.*)")
    public void check_weather_main(String main) {
        Assert.assertEquals("Wrong main", main, response.getWeather().get(0).getMain());
    }

    @Then("weather description is (.*)")
    public void check_weather_description(String description) {
        Assert.assertEquals("Wrong description", description, response.getWeather().get(0).getDescription());
    }

    @Then("weather icon is (.*)")
    public void check_weather_icon(String icon) {
        Assert.assertEquals("Wrong icon", icon, response.getWeather().get(0).getIcon());
    }

    @Then("base is (.*)")
    public void check_base(String base) {
        Assert.assertEquals("wrong base", base, response.getBase());
    }

    @Then("temp is (.*)")
    public void check_temp(BigDecimal temp) {
        assertEquals("Wrong temp", temp, response.getMain().getTemp());
    }

    @Then("pressure is (.*)")
    public void check_pressure(Integer pressure) {
        assertEquals("Wrong pressure", pressure, response.getMain().getPressure());
    }

    @Then("humidity is (.*)")
    public void check_humidity(Integer humidity) {
        assertEquals("Wrong humidity", humidity, response.getMain().getHumidity());
    }

    @Then("temp_min is (.*)")
    public void check_temp_min(BigDecimal temp_min) {
        assertEquals("Wrong temp_min", temp_min, response.getMain().getTemp_min());
    }

    @Then("temp_max is (.*)")
    public void check_temp_max(BigDecimal temp_max) {
        assertEquals("Wrong temp_max", temp_max, response.getMain().getTemp_max());
    }

    @Then("visibility is (.*)")
    public void check_visibility(Integer visibility) {
        Assert.assertEquals("wrong base", visibility, response.getVisibility());
    }

    @Then("wind speed is (.*)")
    public void check_wind_speed(BigDecimal speed) {
        Assert.assertEquals("wrong speed", speed, response.getWind().getSpeed());
    }

    @Then("wind deg is (.*)")
    public void check_deg_speed(Integer deg) {
        Assert.assertEquals("wrong deg", deg, response.getWind().getDeg());
    }

    @Then("Clouds are (.*)")
    public void check_clouds(Integer all) {
        Assert.assertEquals("wrong all", all, response.getClouds().getAll());
    }

    @Then("dt is (.*)")
    public void check_dt(Integer dt) {
        Assert.assertEquals("wrong dt", dt, response.getDt());
    }

    @Then("Sys type is (.*)")
    public void check_sys_type(Integer type) {
        Assert.assertEquals("wrong type", type, response.getSys().getType());
    }

    @Then("Sys id is (.*)")
    public void check_sys_id(Integer id) {
        Assert.assertEquals("wrong id", id, response.getSys().getId());
    }

    @Then("message is (.*)")
    public void check_sys_message(BigDecimal message) {
        Assert.assertEquals("wrong message", message, response.getSys().getMessage());
    }

    @Then("country is (.*)")
    public void check_sys_country(String country) {
        Assert.assertEquals("wrong country", country, response.getSys().getCountry());
    }

    @Then("sunrise is (.*)")
    public void check_sys_sunrise(Integer sunrise) {
        Assert.assertEquals("wrong sunrise", sunrise, response.getSys().getSunrise());
    }

    @Then("sunset is (.*)")
    public void check_sys_sunset(Integer sunset) {
        Assert.assertEquals("wrong sunset", sunset, response.getSys().getSunset());
    }

    @Then("id is (.*)")
    public void check_id(Integer id) {
        Assert.assertEquals("wrong id", id, response.getId());
    }

    @Then("name is (.*)")
    public void check_name(String name) {
        Assert.assertEquals("wrong name", name, response.getName());
    }

    @Then("cod is (.*)")
    public void check_cod(Integer cod) {
        Assert.assertEquals("wrong cod", cod, response.getCod());
    }
}
