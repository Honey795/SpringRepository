package org.example.transfer.service;

import java.util.List;
import org.example.transfer.database.CarrierRepository;
import org.example.transfer.model.Carrier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("carrierService")
@Transactional
public class CarrierService {
    @Autowired
    private CarrierRepository repository;    
    
    public Carrier findById(Long id){
        return repository.findById(id);
    }
    
    public void save(Carrier model){
        repository.save(model);
    }
    
    public void update(Carrier model){
        repository.update(model);
    }
    
    public void delete(Long id){
        repository.delete(id);
    }
    public List<Carrier> findAll(){
        return repository.findAll();
    }
    
    public List<Carrier> findAll(String param){
        return repository.findAll(param);
    }
}
