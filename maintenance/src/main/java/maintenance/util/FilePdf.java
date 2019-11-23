package maintenance.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FilePdf {
	private static final String ABS_PDF = "E:/JAVAApp/maintenance-4.0/maintenance/src/main/webapp/assets/pdf/";
	private static String REAL_PDF = null;
	private static final Logger logger = LoggerFactory.getLogger(FilePdf.class);
	public static boolean uploadFilePDF(HttpServletRequest request, MultipartFile file, String pdf) 
	{				
		// get the real server path
		REAL_PDF = request.getSession().getServletContext().getRealPath("/assets/pdf/");
		
		logger.info(REAL_PDF);					
		// create the directories if it does not exist
		System.out.println("1*************************");

		System.out.println(REAL_PDF);
		System.out.println("*************************");

		if(!new File(REAL_PDF).exists()) {
			new File(REAL_PDF).mkdirs();
		}
		System.out.println("2*************************");

		System.out.println(ABS_PDF);
		System.out.println("*************************");
		
		if(!new File(ABS_PDF).exists()) {
			new File(ABS_PDF).mkdirs();
		}
		
		try {
			//transfer the file to both the location
			file.transferTo(new File(REAL_PDF + pdf + ".pdf"));
			file.transferTo(new File(ABS_PDF + pdf + ".pdf"));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("3*************************");

		System.out.println(pdf);
		System.out.println("*************************");
		return true;
	}
	
	public static void uploadNoPDF(HttpServletRequest request, String pdf) {
		// get the real server path
		REAL_PDF = request.getSession().getServletContext().getRealPath("/assets/pdf/");
	
		String PDFurl = "http://placehold.it/640X480?text=No image";
		String destinationServerFile = REAL_PDF + pdf + ".pdf";
		String destinationProjectFile = REAL_PDF + pdf + ".pdf";
				
		try {
			URL url = new URL(PDFurl);				
			try (	
					InputStream is = url.openStream();
					OutputStream osREAL_PATH = new FileOutputStream(destinationServerFile);
					OutputStream osABS_PATH = new FileOutputStream(destinationProjectFile);
				){
			
				byte[] b = new byte[4096];
				int length;
				while((length = is.read(b))!= -1) {
					osREAL_PATH.write(b, 0, length);
					osABS_PATH.write(b, 0, length);
				}
			}			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("5***********");
		System.out.println(pdf);
	}
	
}
