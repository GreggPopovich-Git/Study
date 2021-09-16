package controller;

import service.Action;
import service.pds.PdsDeleteAction;
import service.pds.PdsDeleteProAction;
import service.pds.PdsDownAction;
import service.pds.PdsListAction;
import service.pds.PdsModifyAction;
import service.pds.PdsModifyProAction;
import service.pds.PdsViewAction;
import service.pds.PdsWriteAction;
import service.pds.PdsWriteProAction;

public class PdsActionFactory {
	private static PdsActionFactory instance = new PdsActionFactory();
	private PdsActionFactory() {}
	public static PdsActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		if(cmd.equals("pds_list")) {
			action = new PdsListAction();
		}else if(cmd.equals("pds_write")) {
			action = new PdsWriteAction();
		} else if(cmd.equals("pds_write_pro")) {
			action = new PdsWriteProAction();
		} else if(cmd.equals("pds_modify")) {
			action = new PdsModifyAction();
		} else if(cmd.equals("pds_modify_pro")) {
			action = new PdsModifyProAction();
		} else if(cmd.equals("pds_view")) {
			action = new PdsViewAction();
		} else if(cmd.equals("pds_delete")) {
			action = new PdsDeleteAction();
		} else if(cmd.equals("pds_delete_pro")) {
			action = new PdsDeleteProAction();
		} else if(cmd.equals("pds_down")) {
			action = new PdsDownAction();
		}
		return action;
	}
}
