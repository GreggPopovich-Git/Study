package service.admin.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import service.CommandHandler;

public class BoardDeleteHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String sel[] = request.getParameterValues("sel");
		BoardDAO dao = BoardDAO.getInstance();
		List<String> list = new ArrayList<String>();
		for(int x = 0; x < sel.length; x++) {
			if(!sel[x].equals("selectall")) {
				list.add(sel[x]);
			}
		}
		int[] row = new int[list.size()];
		for(int x = 0; x < list.size(); x++) {
			int idx = Integer.parseInt(list.get(x));
			String pass = dao.getBoard(idx).getPass();
			row[x] = dao.boardDelete(idx,pass);
		}
		
		request.setAttribute("row", row);
		return "/Admin/board_delete.jsp";
	}

}
