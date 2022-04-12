package com.uai.workshop.ejerciciopuerto;

import com.uai.workshop.ejerciciopuerto.exceptions.SameDayRentException;
import com.uai.workshop.ejerciciopuerto.operaciones.Alquiler;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Puerto {

    private List<Alquiler> alquileres;

    public void generarAlquiler(String feO, String feD) throws SameDayRentException {

        if (feO.equals(feD)){
            throw new SameDayRentException();
        }
    }
}
