package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;
import service.board.BoardDeleteAction;
import service.board.BoardDeleteProAction;
import service.board.BoardListAction;
import service.board.BoardModifyAction;
import service.board.BoardModifyProAction;
import service.board.BoardViewAction;
import service.board.BoardWriteAction;
import service.board.BoardWriteProAction;

@WebServlet("/Board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		Action action = null;
		if(cmd.equals("board_list")) {
			action = new BoardListAction();
		} else if(cmd.equals("board_write")) {
			action = new BoardWriteAction();
		} else if(cmd.equals("board_write_pro")) {
			action = new BoardWriteProAction();
		} else if(cmd.equals("board_view")) {
			action = new BoardViewAction();
		} else if(cmd.equals("board_modify")) {
			action = new BoardModifyAction();
		} else if(cmd.equals("board_modify_pro")) {
			action = new BoardModifyProAction();
		} else if(cmd.equals("board_delete")) {
			action = new BoardDeleteAction();
		} else if(cmd.equals("board_delete_pro")) {
			action = new BoardDeleteProAction();
		}
		
		action.process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
