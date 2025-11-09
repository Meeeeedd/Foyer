package org.esprim.tp1.services;

import org.esprim.tp1.entity.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(String idReservation);
    Reservation addReservation(Reservation r);
    Reservation updateReservation(Reservation r);
    void removeReservation(String idReservation);
}
