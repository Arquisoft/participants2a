package uo.asw.participants.Participants;


import uo.asw.participants.Participants.util.CitizenMin;
import uo.asw.participants.model.Citizen;

/**
 * Servicio de participantes
 * @since 0.0.1
 */
public interface ParticipantsService {
    CitizenMin getParticipantsInfo(String login, String password);
    Citizen changeInfo(Citizen updatedData);
}
