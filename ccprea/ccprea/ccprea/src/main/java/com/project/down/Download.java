package com.project.down;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class Download extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub

		
		File file = new File(model.get("path").toString());
		
		System.out.println("DownloadView ---> file.getPath() : " + file.getPath() );
		System.out.println("DownloadView ---> file.getName() : " + file.getName() );
		
		System.out.println("DOWNLOADVIEW ----> " + model.get("fileName").toString());
		
		response.setContentType(getContentType());
		response.setContentLength((int)file.length());
		
		String userAgent = request.getHeader("User-Agent");
		
		boolean ie = userAgent.indexOf("MSIE") > -1;
		
		String fileName = null;
		
		if(ie){
			fileName = URLEncoder.encode(model.get("fileName").toString(),"utf-8");
		}else{
			//fileName = new String(model.get("fileName").toString().getBytes("utf-8"));
			fileName = URLEncoder.encode(model.get("fileName").toString(),"utf-8");
		}
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		
		FileInputStream fis = null;
		
		try{
			
			fis = new FileInputStream(file);
			
			FileCopyUtils.copy(fis,out);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if(fis !=null){
				try{
					fis.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		out.flush();
	}
	
}
