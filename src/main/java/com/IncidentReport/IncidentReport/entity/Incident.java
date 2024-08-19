package com.IncidentReport.IncidentReport.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "incident_reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "incident_nature")
    private String incidentNature;

    @Column(name = "equipment_persons_involved")
    private String equipmentOrPersonsInvolved;

    @Column(name = "location_involved")
    private String locationInvolved;

    @Column(name = "incident_detection")
    private String incidentDetection;
}
