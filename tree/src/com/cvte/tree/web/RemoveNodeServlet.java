package com.cvte.tree.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cvte.tree.dao.impl.ITreeDaoImpl;
/**
 * 处理 删除、拖拽，更新请求
 */
@WebServlet("/treeNodeController2")
public class RemoveNodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ITreeDaoImpl dao = new ITreeDaoImpl();

	/**
	 * 处理 删除更新   请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		dao.remove(id);
	}

	/**
	 * 处理 拖拽  请求
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sourceId = request.getParameter("sourceId");
		String FuId = request.getParameter("FuId");
		String drag_newId = request.getParameter("drag_newId");
		dao.drag(sourceId, FuId, drag_newId);
		
		System.out.println("sourceId=" + sourceId + "    ,FuId=" + FuId + "    ,drag_newId=" + drag_newId);
	}

}
