package com.IncidentReport.IncidentReport.service;

import com.IncidentReport.IncidentReport.entity.Incident;
import com.IncidentReport.IncidentReport.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    // Create a new incident
    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    // Retrieve all incidents
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    // Retrieve a single incident by ID
    public Optional<Incident> getIncidentById(Long id) {
        return incidentRepository.findById(id);
    }

    // Update an existing incident
    public Incident updateIncident(Long id, Incident incidentDetails) {
        return incidentRepository.findById(id)
                .map(incident -> {
                    incident.setName(incidentDetails.getName());
                    incident.setTime(incidentDetails.getTime());
                    incident.setContactInfo(incidentDetails.getContactInfo());
                    incident.setIncidentNature(incidentDetails.getIncidentNature());
                    incident.setEquipmentOrPersonsInvolved(incidentDetails.getEquipmentOrPersonsInvolved());
                    incident.setLocationInvolved(incidentDetails.getLocationInvolved());
                    incident.setIncidentDetection(incidentDetails.getIncidentDetection());
                    return incidentRepository.save(incident);
                })
                .orElseGet(() -> {
                    incidentDetails.setId(id);
                    return incidentRepository.save(incidentDetails);
                });
    }

    // Delete an incident by ID
    public void deleteIncident(Long id) {
        incidentRepository.deleteById(id);
    }
}
