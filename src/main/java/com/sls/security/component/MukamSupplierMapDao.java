package com.sls.security.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.security.entity.MukamSupplier;
import com.sls.security.repository.MukamSupplierMapRepository;

@Component
public class MukamSupplierMapDao {
	
	@Autowired
	MukamSupplierMapRepository mukamsuppmapRepository;
	
	@Transactional
	public List<MukamSupplier> getAllMukamSupplier(){
		return (List<MukamSupplier>) mukamsuppmapRepository.findAll();
	}
	
	@Transactional
	public void saveMap(List<MukamSupplier> mukamsuppmap) {
		
		mukamsuppmapRepository.save(mukamsuppmap);
		
	}
	
	public long getSeq() {
		return mukamsuppmapRepository.getNextSeriesId();
	}
	
	public long seqVal() {
    	return mukamsuppmapRepository.getPresentSeq();
    }

	@Transactional
	public MukamSupplier save(MukamSupplier mukamsuppEntity) {
		// TODO Auto-generated method stub
		return mukamsuppmapRepository.save(mukamsuppEntity);
	}
	
	/*@Transactional
	public List<MukamSupplier> saveList(List<MukamSupplier> mukamsuppEntity) {
		// TODO Auto-generated method stub
		return mukamsuppmapRepository.save(mukamsuppEntity);
	}*/
	
	
	@Transactional
	public MukamSupplier getById(long id) {
		return mukamsuppmapRepository.findById(id);
	}
	
	@Transactional
	public List<MukamSupplier> getBySuppCode(String suppCode){
		return mukamsuppmapRepository.findBySupplierName(suppCode);
	}
	
	@Transactional
	public MukamSupplier getBySuppCodeAndMukamId(String suppCode, long mukamid){
		return mukamsuppmapRepository.findBySupplierNameAndMukamId(suppCode, mukamid);
	}
	
	@Transactional
	public void delete(long id) {
		mukamsuppmapRepository.delete(id);
	}
	
	@Transactional 
	public List<MukamSupplier> getByMukamId(long mukamid) {
		return mukamsuppmapRepository.findByMukamId(mukamid);
	}

}
