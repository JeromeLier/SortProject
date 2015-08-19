package com.yll.design.proxyDesgin;

public class ServiceImpl implements Service {

	 @Override  
	    public void sayHello() {  
	       // ServiceFactory.before();  
	        System.out.println("Hello world!");  
	       // ServiceFactory.after();  
	    }  
	  
	@Override  
	public void sayBye() {  
	   // ServiceFactory.before();  
	    System.out.println("Bye bye!");  
	     //   ServiceFactory.after();  
	}  
	  
    @Override  
    public void sayHi() {  
        //ServiceFactory.before();  
        System.out.println("Hi");  
    //ServiceFactory.after();  
      
    //ServiceFactory.other();  
    }  

}
