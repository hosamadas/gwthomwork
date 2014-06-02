package sy.hosam.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(Double a , Double b , Double c, AsyncCallback<String> callback);
}
