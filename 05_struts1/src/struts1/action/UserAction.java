package struts1.action;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import struts1.entires.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserAction extends DispatchAction{
	public ActionForward adduser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		UserVO user = new UserVO();
		//user.setUserId(System.currentTimeMillis());
		//user.setUserName(form.get);

		return mapping.findForward("success");
	}
}
