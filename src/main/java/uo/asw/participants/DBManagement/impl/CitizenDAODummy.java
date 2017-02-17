package uo.asw.participants.DBManagement.impl;

import org.springframework.stereotype.Repository;




import uo.asw.participants.DBManagement.CitizenDAO;
import uo.asw.participants.model.Citizen;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @since 0.0.1
 */
@Repository
public class CitizenDAODummy implements CitizenDAO {
    private static Citizen dummyCitizen;
    @PersistenceContext
    private EntityManager entityManager;
    
    static {
        dummyCitizen = new Citizen("pass", "dummy", "123456", "Clara", "Oswald", new Date(), "clara@tardis.co.uk", "The Hyperspace", "Inglesa");
    }

    @Override
    public Citizen getParticipant(String login, String password) {
    	@SuppressWarnings("unchecked")
		List<Citizen> citizen =  entityManager.createQuery(
    	        "from Citizen where nombreUsuario = ?1 and contraseña = ?2")
    	        .setParameter(1, login).setParameter(2, password)
    	        .getResultList();
    	if(citizen.isEmpty())
    		return null;
    	return citizen.get(0);
       // return dummyCitizen;
    }

    @Override
    public Citizen updateInfo(Citizen toUpdate) {
    	entityManager.merge(toUpdate);
        dummyCitizen = toUpdate;
        return dummyCitizen;
    }
}
