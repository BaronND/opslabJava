package struts1.action;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import struts1.entires.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class hibernateUserAction extends DispatchAction {

    public ActionForward AddUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("UTF-8");
        UserVO vo = new UserVO();
        vo.setUserId(String.valueOf(System.currentTimeMillis()));
        vo.setUserName(request.getParameter("username"));
        hbm_save(vo);
        return mapping.findForward("success");
    }

    public ActionForward ListUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return super.cancelled(mapping, form, request, response);
    }


    public void hbm_save(UserVO vo) {
        System.out.println("保存到数据库中->"+vo);
    }
}
