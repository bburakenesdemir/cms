package com.burakenesdemir.cms.service;

import com.burakenesdemir.cms.data.entity.Communication;
import com.burakenesdemir.cms.data.repository.CommunicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommunicationService {

    @Autowired
    CommunicationRepository communicationRepository;

    //TODO : Mail Gönderilecek.
    public Communication create(Communication communication) {

        return communicationRepository.save(communication);
    }

    public Communication delete(String id) {
        Communication communication = communicationRepository.getOne(id);

        if (communication == null) {
            log.error("Object could not found by id: {}", id);
            //throw
        } else {
            communicationRepository.delete(communication);
        }

        return communication;
    }

    public Communication update(Communication communication){
        Communication appealToUpdate = communicationRepository.getOne(communication.getIdentifier());
        if (appealToUpdate == null){
            log.error("Object could not found by id: {}", communication.getIdentifier());
        }else{
            appealToUpdate = communication;
            communicationRepository.save(appealToUpdate);
        }

        return appealToUpdate;
    }

    public List<Communication> getAll(){
        List<Communication> communications = communicationRepository.findAll();

        if(communications.isEmpty()){
            //throw
        }

        return communications;
    }
}
