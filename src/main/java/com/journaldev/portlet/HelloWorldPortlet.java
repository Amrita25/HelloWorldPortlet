package com.journaldev.portlet;
 
import java.io.IOException;
 
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.BaseURL;
import javax.portlet.GenericPortlet;
import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
 
public class HelloWorldPortlet extends GenericPortlet{
	@RenderMode(name="VIEW")
	public void inspectRenderMode(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		/*response.getWriter().print(
				"Hello World Portlet Using Annotations !");*/
		
		if ("success".equalsIgnoreCase((String) request.getAttribute("actionStatus"))) {
			System.out.println("success");
			PortletURL homeUrl = response.createRenderURL();
			request.setAttribute("homeUrl", homeUrl);
			getPortletContext().getRequestDispatcher("/WEB-INF/jsp/success.jsp").include(request, response);
			return;
		}
		System.out.println("actionStatus :"+(String)request.getAttribute("actionStatus"));
		System.out.println("user :"+(String)request.getAttribute("user"));
		System.out.println("render");
		
		PortletURL registerUserAction =response.createActionURL();
		registerUserAction.setParameter(ActionRequest.ACTION_NAME, "registerUserAction");
		
		PortletURL resetRenderUrl=response.createRenderURL();
		
		request.setAttribute("registerUserAction", registerUserAction);
		request.setAttribute("resetRenderUrl", resetRenderUrl);
		
		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/registrationForm.jsp").include(request, response);
				
	}
	
	@RenderMode(name="EDIT")
	public void inspectEditMode(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		//(response).getWriter().println("Edit Mode On Portlet Name :"+this.getPortletName());
		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/preferences.jsp").include(request,response);
		
	}
	
	@RenderMode(name="HELP")
	public void inspectHelpMode(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		//(response).getWriter().println("Help Mode On Portlet Name :"+this.getPortletName());
		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/help.jsp").include(request,response);
		
	}
	
	@ProcessAction(name="registerUserAction")
	public void registerUser(ActionRequest request,
			ActionResponse response)
					throws PortletException, IOException {
		System.out.println("inside registerUser");
		request.setAttribute("user",
				new User(request.getParameter("name")));		
		request.setAttribute("actionStatus","success");
		System.out.println((String)request.getAttribute("actionStatus"));
		
	}
}