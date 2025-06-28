package com.dev.ms_java_mysql.v1.fregues.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "registers")
public class RegisterModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegister;

    @Column(name = "data_register", insertable = false, updatable = false)
    private LocalDate dataRegister;

    @Column(name = "hour_register", insertable = false, updatable = false)
    private LocalTime hourRegister;

    @Column(name = "data_time", insertable = false, updatable = false)
    private LocalDateTime dataTime; // <-- TIMESTAMP no MySQL

    @Column(name = "time_zone", insertable = false, updatable = false)
    private ZonedDateTime timeZone; // <-- também pode ser TIMESTAMP com fuso

}
