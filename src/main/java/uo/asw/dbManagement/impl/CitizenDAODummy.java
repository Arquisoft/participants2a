package uo.asw.dbManagement.impl;

import org.springframework.stereotype.Repository;

import uo.asw.dbManagement.CitizenDAO;
import uo.asw.dbManagement.model.Citizen;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @since 0.0.1
 */
@Repository
@Transactional
public class CitizenDAODummy implements CitizenDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Citizen getParticipant(String login, String password) {
    	Citizen citizen = getParticipant(login);
    	if(citizen == null || !citizen.checkPassword(password)) {
            return null;
        }else {
            return citizen;
        }
    }

    @Override
    public Citizen getParticipant(String login) {
        List<Citizen> citizen = entityManager.createQuery("select c from Citizen c where c.nombreUsuario = ?1")
                .setParameter(1, login)
                .getResultList();
        if(citizen.isEmpty()){
            return null;
        }else{
            return citizen.get(0);
        }
    }

    @Override
    public Citizen getParticipantById(Long id) {
        List<Citizen> citizen = entityManager.createQuery("select c from Citizen c where c.id = ?1")
                .setParameter(1, id)
                .getResultList();
        if(citizen.isEmpty()){
            return null;
        }else{
            return citizen.get(0);
        }
    }

    @Override
    public Citizen updateInfo(Citizen toUpdate) {
    	entityManager.merge(toUpdate);
        return toUpdate;
    }
}
