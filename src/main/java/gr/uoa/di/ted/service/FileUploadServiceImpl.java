package gr.uoa.di.ted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.uoa.di.ted.dao.FileUploadDao;
import gr.uoa.di.ted.model.FileUpload;

@Service("fileUploadService")
@Transactional
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	FileUploadDao dao;

	public FileUpload findById(int id){
		return dao.findById(id);
	}
	
	public List<FileUpload> findByEntityId(int id){
		return dao.findByEntityId(id);
	}
	
	public void deleteById(int id){
		dao.deleteById(id);
	}

	public void saveFileUpload(FileUpload fileUpload){
		dao.save(fileUpload);
	}
}
