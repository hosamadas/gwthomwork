package sy.hosam.gwt.client;

import sy.hosam.gwt.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SolveGwt implements EntryPoint {

	
	Double a ,b, c;
	
	TextBox txt_a , txt_b ,txt_c;
	
	Label  lbl_Result;
	
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
	    txt_a = new TextBox();
		txt_b = new TextBox();
		txt_c = new TextBox();
		
		lbl_Result = new Label();
	
		RootPanel.get("txta").add(txt_a);	
		RootPanel.get("txtb").add(txt_b);
		RootPanel.get("txtc").add(txt_c);
		
		RootPanel.get("txtResult").add(lbl_Result);
		
		
		Button btn_Solve = new Button("Solve");
		
		btn_Solve.addClickHandler(new ClickHandler() {
			@Override
			
			public void onClick(ClickEvent event) {
				
				a = Double.parseDouble(txt_a.getText());
				b = Double.parseDouble(txt_b.getText());
				c = Double.parseDouble(txt_c.getText());
				
				greetingService.greetServer(a,b,c,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								lbl_Result.setText("Remote Procedure Call - Failure");
							}

							public void onSuccess(String result) {
								lbl_Result.setText(result);
							}
						});

				
			}
		});
		
		RootPanel.get("btnSolve").add(btn_Solve);
		
	}

}