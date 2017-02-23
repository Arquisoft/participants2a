package uo.asw.dbManagement;

import uo.asw.dbManagement.model.Citizen;

/**
 * @since 0.0.1
 */
public interface CitizenDAO {
    Citizen getParticipant(String login, String password);
    Citizen getParticipant(String login);
    Citizen updateInfo(Citizen toUpdate);
    Citizen getParticipantById(Long id);
}
