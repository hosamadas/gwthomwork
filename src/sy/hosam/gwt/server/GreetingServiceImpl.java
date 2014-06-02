package sy.hosam.gwt.server;

import sy.hosam.gwt.client.GreetingService;
import sy.hosam.gwt.shared.FieldVerifier;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	@Override
	public String greetServer(Double a , Double b , Double c) {
		
		Double D = b*b - 4*a*c;
		String txt_result = "";
		if(D >= 0){
			Double x1 = (-b + Math.sqrt(D) ) / 2 * a ;
			Double x2 = (-b - Math.sqrt(D) ) / 2 * a ;
			
			txt_result = "X1 = " + x1 + " , X2 = " + x2;
			
		}else if(D <  0){
			txt_result = "Can't be Solved ...";
		}
		

		return txt_result;
	}


}
