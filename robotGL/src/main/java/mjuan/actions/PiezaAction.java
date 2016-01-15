package mjuan.actions;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class PiezaAction implements Action 
{
	private static final Logger log = LogManager.getLogger(BrazoAction.class);
	private String Data;
	
	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String execute() throws Exception 
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		session.setAttribute("forward","sPieza");
		Data=Data.split("\"")[1];
		System.out.println(Data);
		
		
		String[] lista = Data.split(":");
		session.setAttribute("id_base", lista[1]);
		session.setAttribute("id_antebrazo", lista[2]);
		session.setAttribute("id_mano", lista[3]);

		return SUCCESS;
	}



}
