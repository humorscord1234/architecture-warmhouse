package ru.smarthouse.tempapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static Random random = new Random();

    @GetMapping("/{id}")
    public String getTemperatureById(@PathVariable("id") String sensorId, @RequestParam(value = "location", required = false) String location) throws Exception {
        TemperatureDto response = new TemperatureDto();
        response.setStatus("OK");
        response.setLocation(location);
        response.setSensorId(sensorId);
        response.setValue(random.nextDouble(100) - 50);
        return objectMapper.writeValueAsString(response);
    }

    @GetMapping
    public String getTemperature(@RequestParam(value = "location", required = false) String location) throws Exception {
        TemperatureDto response = new TemperatureDto();
        response.setStatus("OK");
        response.setLocation(location);
        response.setValue(random.nextDouble(100) - 50);
        return objectMapper.writeValueAsString(response);
    }
}
