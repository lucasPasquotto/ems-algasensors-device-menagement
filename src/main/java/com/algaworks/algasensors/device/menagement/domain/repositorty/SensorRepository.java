package com.algaworks.algasensors.device.menagement.domain.repositorty;

import com.algaworks.algasensors.device.menagement.domain.model.Sensor;
import com.algaworks.algasensors.device.menagement.domain.model.SensorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, SensorId> {
}
