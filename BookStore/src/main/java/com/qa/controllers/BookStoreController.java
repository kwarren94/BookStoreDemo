package com.qa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.qa.models.Books;
import com.qa.models.Customer;
import com.qa.models.ShoppingCart;
import com.qa.services.BookStoreService;
import com.qa.services.ShoppingCartService;

@Controller
@SessionAttributes({"booksAddedToCart", "loggedInCustomer"})
public class BookStoreController {
	
	@Autowired
	private BookStoreService bookStoreService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@ModelAttribute("loggedInCustomer")
	public Customer loggedInCustomer() {
		Customer defaultCust = new Customer();
		defaultCust.setFirstName("Not logged in");
		return defaultCust;
	}
	
	@RequestMapping("/")
	public String home() {
		return "homePage";
	}
	
	@RequestMapping("/addBook")
	public String addBook() {
		return "addBook";
	}
	
	@RequestMapping("/getAllBooks")
	public ModelAndView viewBooks() {
		Iterable<Books> books = bookStoreService.getAllBooks();
		ModelAndView mv = new ModelAndView("viewAllBooks", "viewAllBooks", books);
		System.out.println("here" + books);
		return mv;
		
	}
	
	@RequestMapping("/viewCart")
	public ModelAndView viewOrders(@RequestParam("customerId")int customerId) {
		
		
		Iterable<ShoppingCart> orders = shoppingCartService.getOrderByCustomerId(customerId);
		if(orders != null){
			
			ModelAndView mv2 = new ModelAndView("viewCart", "viewCart", orders);
			System.out.println("orders" + orders);
			return mv2;
		}
		else {
			ModelAndView mv = new ModelAndView("emptyCart", "emptyCart", orders);
			return mv;
		}
	}
	
	
	
	@RequestMapping("/bookRegister")
	public String bookRegistration(@ModelAttribute Books b) {
		System.out.println("book" + b);
		
		
		if(!b.getBookName().equals("") && !b.getBookAuthor().equals("") && !b.getBookIsbn().equals("") && !b.getBookContents().equals("") && !b.getBookOverview().equals("")){
			bookStoreService.createBookRecord(b);
			return "book_success";
		}
		else {
			return "book_invalid";
		}
	}
	
	@RequestMapping("/viewAllBooks")
	public String getBooksByName(@RequestParam("bookNameSearch")String bookName, Model model) {
		model.addAttribute("viewAllBooks", bookStoreService.getBooksByName(bookName));
		return "viewAllBooks";
	}
	
	@RequestMapping("/addBookToCart")
	public String addBookToCart(@ModelAttribute ShoppingCart s) {
		System.out.println("Order" + s);
		if(s.getBookQuantity() > 0){
			shoppingCartService.createOrder(s);
			return "addedToCart";
		}
		else {
			return "notAddedToCart";
		}
		
	}
	
	@RequestMapping("/addBookQuantity")
	public ModelAndView addBookToCartByOne( @RequestParam("customerId") int customerId, @RequestParam("id") int id, @RequestParam("bookQuantity") int bookQuantity) {
		 System.out.println("quantity" + bookQuantity);
		int s = shoppingCartService.updateBookQuantityByOneById( customerId, id, bookQuantity+1);
		System.out.println("cart" + s);
		
		
		Iterable<ShoppingCart> orders = shoppingCartService.getOrderByCustomerId(customerId);
		ModelAndView mv3 = new ModelAndView("viewCart", "viewCart", orders);
		System.out.println("orders" + orders);
		
		
		return mv3;
		
	}
	
	@RequestMapping("/removeBookQuantity")
	public String removeBookFromCartByOne(@RequestParam("customerId") int customerId, @RequestParam("id") int id, @RequestParam("bookQuantity") int bookQuantity, Model model) {
		
		int s = shoppingCartService.removeBookFromCartByOneById(customerId, id, bookQuantity-1);
		System.out.println("removed" + s);
//		ModelAndView mv = null;
		String redirectUrl = "viewCart?customerId=" + customerId;
		
		if(bookQuantity > 1) {
			Iterable<ShoppingCart> orders = shoppingCartService.getOrderByCustomerId(customerId);
//			mv = new ModelAndView("viewCart", "viewCart", orders);
			
			model.addAttribute("viewCart", orders);
			
		}
		
		else { 
			int orders = shoppingCartService.removeEmptyBook(customerId, id);
//			mv = new ModelAndView("viewCart", "viewCart", orders);
//			System.out.println("here" + orders);
			model.addAttribute("viewCart", orders);
			
		}
		return "redirect:" + redirectUrl;
		
	}
	
	
	

}
