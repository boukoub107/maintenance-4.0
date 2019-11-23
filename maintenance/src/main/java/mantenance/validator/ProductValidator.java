package mantenance.validator;

import javax.ws.rs.container.Suspended;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.mant.maintenanceBackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Product product = (Product) target;
		//System.out.println("the extension type:"+product.getFilpdf().getTypeDescription());
		if(product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select a file to upload!");
			return;
		}
		if(! (product.getFile().getContentType().equals("image/jpeg") || 
				product.getFile().getContentType().equals("image/png")) ||
				product.getFile().getContentType().equals("image/gif")
			 )
			{
				errors.rejectValue("file", null, "Please select an image file to upload!");
				return;	
			}
		
		if(product.getFilpdf() == null || product.getFilpdf().getOriginalFilename().equals("")) {
			errors.rejectValue("filpdf", null, "Please select an PDF file to upload!");
			return;
		}
		if(!(product.getFilpdf().getContentType().equals("application/pdf")|| 
				product.getFile().getContentType().equals("application/docx"))) {
				errors.rejectValue("filpdf", null, "Please select an pdf file to upload!");
				return;	
			}
		System.out.println("6*******************3");
		System.out.println(product.getFile().getContentType());

		System.out.println(product.getFilpdf().getContentType());

		}

	}


