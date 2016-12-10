package com.niit.shoppingcart;

import java.io.IOException;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.util.FileUtil;

@Controller
public class ProductController {
	
	 Logger log=LoggerFactory.getLogger(ProductController.class);
	@Autowired(required=true)
	 private ProductDAO productDAO;
	
	@Autowired
	Category category;
	@Autowired
	Supplier supplier;
	@Autowired
	Product product;
	@Autowired(required=true)
	private CategoryDAO categoryDAO;
	@Autowired(required=true)
	private SupplierDAO supplierDAO;
private String Path="E:\\workspace\\ShoppingCartFrontEnd\\src\\main\\resources\\images\\";
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String listProducts(Model model){
		model.addAttribute("product", product);
		model.addAttribute("category", category);
		model.addAttribute("supplier", supplier);
		model.addAttribute("productList",this.productDAO.list());
		model.addAttribute("categoryList",this.categoryDAO.list());
		model.addAttribute("supplierList",this.supplierDAO.list());
		return "Product";

	}
	@RequestMapping(value="product/add",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile file){

              if (productDAO.get(product.getPro_id()) == null) {
       			productDAO.save(product);
       		} else {
       			
       				productDAO.update(product);
       		}
                 FileUtil.upload(Path, file, product.getPro_id()+".jpg");       
                  return "redirect:/manageProducts";
	}
	 	
	
	
	@RequestMapping("product/remove/{pro_id}")
	public String removeProduct(@PathVariable("pro_id") String id)
	{
		Product product=productDAO.get(id);
		ModelAndView mv = new ModelAndView("product");
	boolean flag=	productDAO.delete(product);
		if(flag==true){
			System.out.println("i am in delete operation");
		}
		else{
			mv.addObject("ErrorMessage", "could not delete the record");
		}
		return "redirect:/manageProducts";	
	}
	
	
	@RequestMapping("product/edit/{pro_id}")
	public String  EditProduct(@PathVariable("pro_id") String id,Model model){
	
			product= productDAO.get(id);
		
			//log.debug("Ending  of the method update");
		
		return  "redirect:/product";

	}
	
	
    @RequestMapping("/{pro_id}")
    private String viewProduct(@PathVariable("pro_id") String pro_id, Model model,HttpSession session) throws IOException {
		log.info("///////////////in view method//////////////");
		session.setAttribute("product",product);
		session.setAttribute("productList",productDAO.list());
		session.setAttribute("category",category);
		session.setAttribute("categoryList",categoryDAO.list());
    	Product product=productDAO.get(pro_id);
        model.addAttribute("clickedIndividualProduct", true);
        model.addAttribute("product", product);
        return "Home";
    }

}