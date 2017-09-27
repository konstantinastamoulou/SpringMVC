package gr.uoa.di.ted.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import gr.uoa.di.ted.model.FileUpload;
import gr.uoa.di.ted.model.User;

@Repository("fileUploadDao")
public class FileUploadDaoImpl extends AbstractDao<Integer, FileUpload> implements FileUploadDao  {

	public FileUpload findById(int id){
		FileUpload fu=getByKey(id);
		return fu;
	}
	
	@SuppressWarnings("unchecked")
	public List<FileUpload> findByEntityId(int id){
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("entity_id", id));
		return (List<FileUpload>)crit.list();
	}
	
	public void save(FileUpload fu){
		persist(fu);
	}
	
	public void deleteById(int id){
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		FileUpload fu = (FileUpload)crit.uniqueResult();
		delete(fu);
	}

}
