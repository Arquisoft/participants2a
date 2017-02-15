package uo.asw.participants.DBManagement.impl;

import org.springframework.stereotype.Repository;
import uo.asw.participants.DBManagement.CitizenDAO;
import uo.asw.participants.model.Citizen;

import java.util.Date;

/**
 * @since 0.0.1
 */
@Repository
public class CitizenDAODummy implements CitizenDAO {
    private static Citizen dummyCitizen;

    static {
        dummyCitizen = new Citizen("pass", "dummy", "123456", "Clara", "Oswald", new Date(), "clara@tardis.co.uk", "The Hyperspace", "Inglesa");
    }

    @Override
    public Citizen getParticipant(String login, String password) {
        return dummyCitizen;
    }

    @Override
    public Citizen updateInfo(Citizen toUpdate) {
        dummyCitizen = toUpdate;
        return dummyCitizen;
    }
}
