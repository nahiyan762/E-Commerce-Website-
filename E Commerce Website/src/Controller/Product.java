package Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BusinessService.ProductData;
import BusinessService.SubCategoryData;
import Model.dalProduct;
import Model.dalSubCategory;

@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));

		dalProduct dalproduct = new dalProduct();
		String arr[] = dalproduct.SelectById(id);
		
		File index = new File("C:/Users/hp/workspaceJEE/RegistrationForm/WebContent/image/"+arr[5]);
		
		if(dalproduct.DELETE(id))
		{
			index.delete();
			response.sendRedirect("./ViewProduct.jsp");
		}
		else
		{
			out.println("hoynai");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ArrayList<String> arrayList = new ArrayList<String>();
//		if(ServletFileUpload.isMultipartContent(request))
//	    {
//			out.println("upload");
//	    }
//		else
//		{
//			out.println("upload hoy nai");
//		}
		
		  ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		  try
		  {
			  List<FileItem>  items = upload.parseRequest(request);
			  for(FileItem item:items)
			  {
				  if(item.isFormField())
				  {
					  //arrayList.add(item.getFieldName());
					  arrayList.add(item.getString());
				  }
				  else
				  {
					  if(item.getContentType().equals("image/png"))
					  {
						  File uploadDir = new File("C:/Users/hp/workspaceJEE/RegistrationForm/WebContent/image");
						  File file = File.createTempFile("image",".png",uploadDir);
						  item.write(file);
						  if(arrayList.size()>5)
						  {
							  File uploadDir1 = new File(uploadDir+"/"+arrayList.get(5));
							  uploadDir1.delete();
							  arrayList.remove(5);
							  arrayList.add(file.getName());  
						  }
						  else
						  {
							  arrayList.add(file.getName());
						  }
					  }
					  else
					  {
						  out.println("pic pay nai");
					  }
				  }
			  }
		  }
		  catch(FileUploadException e)
		  {  
			  e.printStackTrace();
		  }
		  catch(Exception ex)
		  {  
			  ex.printStackTrace();
		  }
		  if(sendToTheData(arrayList))
		  {
			  response.sendRedirect("./ViewProduct.jsp");
		  }
		  else
		  {
			  out.println("Hoynai");
		  }
	}
	
	public boolean sendToTheData(ArrayList arrayList)
	{
		boolean bool = false;
		
		if(arrayList.get(9).equals("Save"))
		{
			String name = (String) arrayList.get(0);
			String price = (String) arrayList.get(1);
			String vat = (String) arrayList.get(2);
			String discount = (String) arrayList.get(3);
			String picture = (String) arrayList.get(4);
			String details = (String) arrayList.get(5);
			String quantity = (String) arrayList.get(6);
			String subcatagoryid = (String) arrayList.get(7);
			String sizeid = (String) arrayList.get(8);
			int err = 0;
			if(arrayList.get(1).equals(null)&& arrayList.get(2).equals(null))
			{
				err++;
			}
			if(err == 0)
			{
				ProductData data = new ProductData();
				data.setName(name);
				data.setPrice(price);
				data.setDetails(details);
				data.setDiscount(discount);
				data.setPicName(picture);
				data.setQuantity(quantity);
				data.setSubcatagoryId(subcatagoryid);
				data.setSizeId(sizeid);
				data.setVat(vat);
				
				dalProduct dalproduct = new dalProduct();
				if(dalproduct.Insert(data))
				{
					//System.out.println("Hoise");
					//response.sendRedirect("./ViewProduct.jsp");
					bool = true;
				}
				else
				{
					//System.out.println("Hoynai");
					//out.println("Hoynai");
					bool = false;
				}
			}
		}
		else if(arrayList.get(10).equals("Update"))
		{
			String id = (String) arrayList.get(0);
			String name = (String) arrayList.get(1);
			String price = (String) arrayList.get(2);
			String vat = (String) arrayList.get(3);
			String discount = (String) arrayList.get(4);
			String picture = (String) arrayList.get(5);
			String details = (String) arrayList.get(6);
			String quantity = (String) arrayList.get(7);
			String subcatagoryid = (String) arrayList.get(8);
			String sizeid = (String) arrayList.get(9);
			
			ProductData data = new ProductData();			
				data.setId(id);
				data.setName(name);
				data.setPrice(price);
				data.setVat(vat);
				data.setDiscount(discount);
				data.setPicName(picture);
				data.setDetails(details);
				data.setQuantity(quantity);
				data.setSubcatagoryId(subcatagoryid);
				data.setSizeId(sizeid);
			
			dalProduct dalproduct = new dalProduct();
			if(dalproduct.Update(data, id))
			{
				bool = true;
			}
			else
			{
				bool = false;
			}
		}
		return bool;
		
	}
}
