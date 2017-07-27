package com.cvte.tree.web;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cvte.tree.dao.impl.ITreeDaoImpl;

import net.sf.json.JSONArray;

/**
 * 处理数据加载请求
 * 异步--加载每一级节点下的数据
 */
@WebServlet("/treatServlet")
public class LoadSubDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 处理数据加载请求
	 * 每次返回本节点下的数据
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String pid = request.getParameter("pid");
		pid = (pid == null) ?  "0" : pid;
		System.out.println("get request pid="+pid);
		
		ITreeDaoImpl dao = new ITreeDaoImpl();
		JSONArray getJsonArray=JSONArray.fromObject(dao.getLinealChildren(pid));//查询当前节点下的  子数据
		response.getWriter().print(getJsonArray);
		response.getWriter().flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
