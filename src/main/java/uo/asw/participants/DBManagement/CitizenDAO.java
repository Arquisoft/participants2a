package uo.asw.participants.DBManagement;

import uo.asw.participants.model.Citizen;

/**
 * @since 0.0.1
 */
public interface CitizenDAO {
    Citizen getParticipant(String login, String password);
    Citizen updateInfo(Citizen toUpdate);
}
