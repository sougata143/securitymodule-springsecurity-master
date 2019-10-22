package com.sls.security.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.security.entity.GateStoreEntryRegDtl;
import com.sls.security.repository.GateStoreEntryDtlRepository;

@Component
public class GateStoreEntryDtlComponent {
	
	@Autowired
	GateStoreEntryDtlRepository storeentrydtlRepository;
	
	public long getSeq() {
		return storeentrydtlRepository.getNextSeriesId();
	}
	
	@Transactional
	public List<GateStoreEntryRegDtl> getAllGateStoreEntryRegDtl(){
		return storeentrydtlRepository.findAll();
	}
	
	@Transactional
	public GateStoreEntryRegDtl getGateStoreEntryRegDtlById(long id) {
		return storeentrydtlRepository.findOne(id);
	}
	
	@Transactional
	public GateStoreEntryRegDtl saveGateStoreEntryRegDtl(GateStoreEntryRegDtl storeentrydtlEntity) {
		return storeentrydtlRepository.save(storeentrydtlEntity);
	}
	
	@Transactional
	public void deleteGateStoreEntryRegDtl(long id) {
		storeentrydtlRepository.delete(id);
	}

}
