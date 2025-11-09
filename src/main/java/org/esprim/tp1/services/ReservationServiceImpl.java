package org.esprim.tp1.services;

import org.esprim.tp1.entity.Reservation;
import org.esprim.tp1.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public void removeReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }
}