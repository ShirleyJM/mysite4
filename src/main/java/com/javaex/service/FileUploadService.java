package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.FileUploadDao;
import com.javaex.vo.FileVo;

@Service
public class FileUploadService {

	@Autowired
	private FileUploadDao fileUploadDao;
	
	public FileVo restore(MultipartFile file){
		String saveDir ="D:\\javaStudy\\upload";
		
		//original file name
		String orgName= file.getOriginalFilename();
		System.out.println("orgName :"+orgName);
		//확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName :"+exName);
		//저장파일 이름
		String saveName =  System.currentTimeMillis() + UUID.randomUUID().toString()+ exName;
		//파일 path
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath: "+ filePath);
		
		//파일 size
		long fileSize = file.getSize();
		System.out.println("fileSize: "+fileSize);
		
		FileVo fileVo = new FileVo(filePath,orgName,saveName,fileSize);
		System.out.println(fileVo.toString());
		//다오 연결 -> db에 저장
		fileUploadDao.insert(fileVo);
		
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(saveDir + "/"+saveName);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			if(bout != null){
				bout.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileVo;
	}
	public List<FileVo> list(){
		return fileUploadDao.list();
	}
}
