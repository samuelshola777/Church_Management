package com.example.churchmanagement.data.model;

import com.sun.jdi.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Events {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Address eventLocation;
    private LocalDate eventDate;
    private EventType eventType;
//   private Object eventHost;



}
