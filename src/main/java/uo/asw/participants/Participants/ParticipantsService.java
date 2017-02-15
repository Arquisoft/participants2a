package uo.asw.participants.Participants;

import org.springframework.stereotype.Service;
import uo.asw.participants.model.Citizen;

/**
 * Servicio de participantes
 * @since 0.0.1
 */
public interface ParticipantsService {
    Citizen getParticipantsInfo(String login, String password);
    Citizen changeInfo(Citizen updatedData);
}
