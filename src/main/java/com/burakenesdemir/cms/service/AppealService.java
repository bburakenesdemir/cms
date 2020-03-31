package com.burakenesdemir.cms.service;

import com.burakenesdemir.cms.data.entity.Appeal;
import com.burakenesdemir.cms.data.repository.AppealRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AppealService {

    @Autowired
    AppealRepository appealRepository;

    //TODO : Mail Gönderilecek.
    public Appeal create(Appeal appeal) {

        return appealRepository.save(appeal);
    }

    public Appeal delete(String id) {
        Appeal appeal = appealRepository.getOne(id);

        if (appeal == null) {
            log.error("Object could not found by id: {}", id);
            //throw
        } else {
            appealRepository.delete(appeal);
        }

        return appeal;
    }

    public Appeal update(Appeal appeal){
        Appeal appealToUpdate = appealRepository.getOne(appeal.getIdentifier());
        if (appealToUpdate == null){
            log.error("Object could not found by id: {}", appeal.getIdentifier());
        }else{
            appealToUpdate = appeal;
            appealRepository.save(appealToUpdate);
        }

        return appealToUpdate;
    }

    public List<Appeal> getAll(){
        List<Appeal> appeals = appealRepository.findAll();

        if(appeals.isEmpty()){
            //throw
        }

        return appeals;
    }
}
