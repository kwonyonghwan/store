package keyosk;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class StoreController {

	@Autowired
    private StoreService storeService;

    	   	/*----  POST-----*/
	@RequestMapping(value="/storeOrderAccepted", method=RequestMethod.POST)
	public String StoreOrderAccepted(@RequestBody StoreOrderAccepted storeOrderAcceptedObj) throws Exception {

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□ StoreOrderAccepted start □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"); 

    return storeService.StoreOrderAcceptedService(storeOrderAcceptedObj);

	} //StoreOrderAccepted

   	/*----  GET----- */
    @GetMapping("/storeList")
    public Iterable<Store> storeList() throws Exception { 
              
    System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
    System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□ storeList start □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
    System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"); 
                      
    return  storeService.storeListService();       
    }//storeList


    /*----  POST-----주문 거절*/
	@RequestMapping(value="/storeOrderRejected", method=RequestMethod.POST)
	public String StoreOrderRejected(@RequestBody StoreOrderRejected storeOrderRejectedObj) throws Exception {
		
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□ StoreOrderRejected start □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"); 
                          
		return storeService.StoreOrderRejectedService(storeOrderRejectedObj);
	} 

  	/*----  POST-----*/
	@RequestMapping(value="/storeCooked", method=RequestMethod.POST)
	public String StoreCooked(@RequestBody StoreCooked storeCookedObj) throws Exception {
				   
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□ StoreCooked start □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"); 
		   
		return storeService.StoreCookedService(storeCookedObj);
		   
	} //Payed


 }
