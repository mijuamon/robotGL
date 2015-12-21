package mjuan.actions;



import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class BrazoAction implements Action 
{
	private static final Logger log = LogManager.getLogger(BrazoAction.class);
	private int nSlider;
	
	public int getnSlider() {
		return nSlider;
	}

	public void setnSlider(int nSlider) {
		this.nSlider = nSlider;
	}

	public String execute() throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("forward","sBrazo");
		return SUCCESS;
	}

}
