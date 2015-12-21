package mjuan.actions;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class MenuAction implements Action{
	private static final Logger log = LogManager.getLogger(BrazoAction.class);

	public String execute() throws Exception {
		log.info("execute");
		return SUCCESS;
	}
	
	public String Brazo()
	{
		log.info("BRAZO");
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("forward","brazo");
		return SUCCESS;
	}
	public String Pieza()
	{
		log.info("PIEZA");
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("forward","pieza");
		return SUCCESS;
	}
	

}
