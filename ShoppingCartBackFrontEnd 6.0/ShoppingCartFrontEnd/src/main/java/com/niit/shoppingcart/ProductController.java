package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;





@Controller
public class ProductController {
	@Autowired(required=true)
	 private ProductDAO productDAO;
	@Autowired(required=true)
	private CategoryDAO categoryDAO;
	@Autowired(required=true)
	private SupplierDAO supplierDAO;
	//private String Path="D:\\ \\img";
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String listProducts(Model model){
		model.addAttribute("product", new Product());
		model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("productList",this.productDAO.list());
		model.addAttribute("categoryList",this.categoryDAO.list());
		model.addAttribute("supplierList",this.supplierDAO.list());
		return "Product";

	}
	@RequestMapping(value="/product/add",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product/*@RequestParam("image")MultipartFile file*/){
                  Category category=categoryDAO.getByName(product.getCategory().getCat_name());
               Supplier supplier=supplierDAO.getByName(product.getSupplier().getSup_name());
                  product.setCategory(category);
               product.setSupplier(supplier);
               product.setCategory_id(category.getCat_id());
               product.setSupplier_id(supplier.getSup_id());
                  productDAO.update(product);
          //        FileUtil.upload(Path, file, product.getId()+".jpg");           
                  return"product";
	}
	 	
	@RequestMapping("product/remove/{pro_id}")
	public String removeProduct(@PathVariable("pro_id") Product id, ModelMap model)throws Exception
	{
		
		try{
			productDAO.delete(id);
			model.addAttribute("message","Successfully Added");
		}
		catch(Exception e){
			model.addAttribute("message",e.getMessage());
			e.printStackTrace();
		}
		
		return "redirect:/Product";
		
	}
	@RequestMapping("product/edit/{pro_id}")
	public String removeProduct(@PathVariable("pro_id") String id,Model model){
		System.out.println("editProduct");
		model.addAttribute("product",this.productDAO.get(id));
		model.addAttribute("listproducts",this.productDAO.list());
		model.addAttribute("categoryList",this.categoryDAO.list());
		model.addAttribute("supplierList",this.supplierDAO.list());
		return "Product";

	}
	@RequestMapping("product/get/{pro_id}")
	public String getSelectedProduct(@PathVariable("pro_id") String id,Model model,
		  RedirectAttributes redirectAttributes){
		   redirectAttributes.addFlashAttribute("selectedProduct", productDAO.get(id));
			return "Product";
	}
	
/*	@RequestMapping(value="/backtoHome",method=RequestMethod.GET)
	  Public String backtoHome(@ModelAttribute("selectedProduct")
	      final Object selectedProduct,final Model model)
	  {
		model.addAttribute("selectedProduct", selectedProduct)
		return "/home";
	  }
	*/

}