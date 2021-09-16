package service.pds;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandHandler;

public class PdsDownHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String filename =  request.getParameter("filename"); //파일 이름을 받는다. 
		//System.out.print(filename);
		
		//String path = request.getRealPath("/") + "Pds/upload/";
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/Pds/upload/");// 파일 저장 경로

		File file = new File(path+"/"+filename); // 절대경로입니다.

		String Agent=request.getHeader("USER-AGENT");
		response.setContentType("application/unknown");  //화일형태

		//response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes()));
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename));
		
		try{
			byte b[] = new byte[5 * 1024 * 1024];  //5M byte까지 업로드가 가능하므로 크기를 이렇게 잡아주었음.
			if (file.isFile()){
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));  
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());  
				try { 
					int read = 0;
					while ((read = bis.read(b)) != -1){
						bos.write(b,0,read);
					}
					bos.flush();
					bos.close();  
					bis.close();         
				}catch(Exception e){}       
			}
		}catch(Exception se){
			//IllegalStateException
		}
		return null;
	}

}
