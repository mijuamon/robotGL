package mjuan.actions;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class RedirectAction implements Action 
{
	private static final Logger log = LogManager.getLogger(BrazoAction.class);

	public String execute() throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		String forward = (String) session.getAttribute("forward");
		log.info("going to: " + forward);
		return forward;
	}
	public String back() throws Exception
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("forward", "index");		
		return SUCCESS;
		
	}

}
