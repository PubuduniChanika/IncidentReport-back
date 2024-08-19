package com.IncidentReport.IncidentReport.repository;

import com.IncidentReport.IncidentReport.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

// Change class to interface and use extends
public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
