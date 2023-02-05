package org.example.transfer.database;

import java.util.List;
import org.example.transfer.model.Carrier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarrierRepository {

    @Autowired
    private SessionFactory sessionFactory;
    
    public Carrier findById(Long id){
        return sessionFactory.getCurrentSession().get(Carrier.class, id);
    }
    
    public void save(Carrier model){
        sessionFactory.getCurrentSession().saveOrUpdate(model);
    }
    
    public void update(Carrier model){
        sessionFactory.getCurrentSession().update(model);
    }
    
    public void delete(Long id){
        Session session = sessionFactory.getCurrentSession();
        Carrier model = session.byId(Carrier.class).load(id);
        session.delete(model);
    }
    
    public List<Carrier> findAll(){
      return sessionFactory.getCurrentSession().createQuery("From Carrier").getResultList();      
    }
    
    public List<Carrier> findAll(String param){
      return sessionFactory.getCurrentSession().createQuery("From Carrier c Where c.name like '%'|| :param || '%' or c.inn = :param or c.address like '%'|| :param || '%' order by id")
                    .setParameter("param", param)
                    .getResultList();      
    }
}
