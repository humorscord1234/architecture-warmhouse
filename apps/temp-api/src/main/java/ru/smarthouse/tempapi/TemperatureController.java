package ru.smarthouse.tempapi;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static Random random = new Random();

    @GetMapping("/{id}")
    public String getTemperatureById(@PathVariable("id") String sensorId, @RequestParam("location") String location) throws Exception {
        TemperatureDto response = new TemperatureDto();
        response.setLocation(location);
        response.setSensorId(sensorId);
        response.setValue(random.nextDouble(100) - 50);
        return objectMapper.writeValueAsString(response);
    }

    @GetMapping
    public String getTemperature(@RequestParam("location") String location) throws Exception {
        TemperatureDto response = new TemperatureDto();
        response.setLocation(location);
        response.setValue(random.nextDouble(100) - 50);
        return objectMapper.writeValueAsString(response);
    }
}
