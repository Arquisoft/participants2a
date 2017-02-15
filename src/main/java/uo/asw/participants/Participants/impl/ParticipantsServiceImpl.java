package uo.asw.participants.Participants.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uo.asw.participants.DBManagement.CitizenDAO;
import uo.asw.participants.Participants.ParticipantsService;
import uo.asw.participants.model.Citizen;

/**
 * Created by Irazusta on 15/02/2017.
 */
@Service
public class ParticipantsServiceImpl implements ParticipantsService {
    @Autowired
    private CitizenDAO citizenDAO;

    @Override
    public Citizen getParticipantsInfo(String login, String password) {
        return citizenDAO.getParticipant(login, password);
    }

    @Override
    public Citizen changeInfo(Citizen updatedData) {
        return citizenDAO.updateInfo(updatedData);
    }
}
