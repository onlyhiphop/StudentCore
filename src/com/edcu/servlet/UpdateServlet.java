package com.edcu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edcu.dao.ScoreDao;
import com.edcu.domain.Score;

public class UpdateServlet extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String courseNo = request.getParameter("courseNo");
		String[] stuNos = request.getParameterValues("stuNo");
		String[] cores = request.getParameterValues("score");
		String[] types = request.getParameterValues("type");
		
		ScoreDao sd = new ScoreDao();
		
		ArrayList<Score> scoreList = new ArrayList<Score>();
		for(int i =0;i < stuNos.length;i++){
			String stuNo = stuNos[i];
			String type = types[i];
			String core = cores[i];
			Score score = new Score(stuNo, null, type, core);
			try {
				sd.UpdateStuScore(score, courseNo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("ScoreServlet?courseNo="+courseNo);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		this.doGet(request, response);
	}

}
