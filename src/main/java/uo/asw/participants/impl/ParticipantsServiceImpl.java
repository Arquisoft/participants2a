package uo.asw.participants.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.dbManagement.CitizenDAO;
import uo.asw.dbManagement.model.Citizen;
import uo.asw.participants.ParticipantsService;
import uo.asw.participants.util.CitizenMin;

/**
 * Created by Irazusta on 15/02/2017.
 */
@Service
public class ParticipantsServiceImpl implements ParticipantsService {
    @Autowired
    private CitizenDAO citizenDAO;

    @Override
    public CitizenMin getParticipantsInfo(String login, String password) {
       Citizen c = citizenDAO.getParticipant(login, password);
       if(c != null){
    	   return new CitizenMin(c);
       }
       return null;
    }

    @Override
    public Citizen getCitizen(Long id) {
        return citizenDAO.getParticipantById(id);

    }

    @Override
    public Citizen changeInfo(Citizen updatedData) {
        return citizenDAO.updateInfo(updatedData);
    }
}
