package app.struts.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import app.entries.Tree;

@Controller("treeAction")
@Scope("prototype")
public class TreeAction extends SupportAction<Tree> {

	private static final long serialVersionUID = -5528361851582333879L;
	
	
}
