package com.sls.security.controller;

import static com.sls.security.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sls.security.dto.DeleteDTO;
import com.sls.security.dto.MukamDTO;
import com.sls.security.services.MukamService;
import com.sls.security.services.serviceImpl.MukamServiceImpl;


@RestController
@RequestMapping("/mukam/")
public class MukamController implements MukamService {

    @Autowired
    MukamServiceImpl mukamService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addMukam", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<MukamDTO> persistMukam(@RequestBody MukamDTO mukamDTO) {

    	mukamService.persistMukam(mukamDTO);
    	
	return new ResponseEntity<MukamDTO>(mukamDTO,HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateMukam", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<MukamDTO> updateMukam(@RequestBody MukamDTO mukamDTO) {

    	mukamService.updateMukam(mukamDTO);
    	
	return new ResponseEntity<MukamDTO>(mukamDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllMukam", method = RequestMethod.GET)
    @ResponseBody
    public List<MukamDTO> populateMukamList() {
	
    	return mukamService.populateMukamList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getMukamById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public MukamDTO populateOneMukamDetails(@PathVariable("Id") Long Id) {
    
    	return mukamService.populateOneMukamDetails(Id);
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteMukam/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyMukam(@PathVariable("Id") Long Id) {

    	return mukamService.destroyMukam(Id);
	
    }

   
    

    
}
