package mjuan.actions;


import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class BrazoAction implements Action 
{
	@SuppressWarnings("unused")
	private static final Logger log = LogManager.getLogger(BrazoAction.class);
	private String NSlider;
	
	public String execute() throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		session.setAttribute("forward","sBrazo");
		
		String nslider = NSlider.split(":")[1];
		session.setAttribute("id_brazo", nslider.substring(0, nslider.length()-1));
		return SUCCESS;
	}
	
	public String getNSlider() {
		return NSlider;
	}

	public void setNSlider(String NSlider) {
		this.NSlider = NSlider;
	}
}
