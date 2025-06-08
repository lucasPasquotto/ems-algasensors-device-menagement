package com.algaworks.algasensors.device.menagement.api.controller;

import com.algaworks.algasensors.device.menagement.api.model.SensorInput;
import com.algaworks.algasensors.device.menagement.api.model.SensorOutput;
import com.algaworks.algasensors.device.menagement.common.IdGenerator;
import com.algaworks.algasensors.device.menagement.domain.model.Sensor;
import com.algaworks.algasensors.device.menagement.domain.model.SensorId;
import com.algaworks.algasensors.device.menagement.domain.repositorty.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorRepository sensorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SensorOutput create(@RequestBody SensorInput input) {
        Sensor sensor = Sensor.builder()
                .id(new SensorId(IdGenerator.generateTSID()))
                .ip(input.getIp())
                .name(input.getName())
                .location(input.getLocation())
                .protocol(input.getProtocol())
                .model(input.getModel())
                .enabled(false)
                .build();

        sensor = sensorRepository.saveAndFlush(sensor);

        return SensorOutput.builder()
                .id(sensor.getId().getValue())
                .ip(sensor.getIp())
                .name(sensor.getName())
                .location(sensor.getLocation())
                .protocol(sensor.getProtocol())
                .model(sensor.getModel())
                .enabled(sensor.getEnabled())
                .build();
    }
}
