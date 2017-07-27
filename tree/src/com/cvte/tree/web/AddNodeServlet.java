package com.cvte.tree.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cvte.tree.dao.impl.ITreeDaoImpl;
import com.cvte.tree.entity.TreeNode;

/**
 *	处理新建、重命名节点  请求
 *	ajax请求类型(type=post、get)，PUT和delete浏览器不一定支持
 */
@WebServlet("/treeNodeController")
public class AddNodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ITreeDaoImpl dao = new ITreeDaoImpl();

	/**
	 * 处理重命名节点  请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String newId = request.getParameter("id");
		String newText = request.getParameter("newText");
		dao.reName(new TreeNode(newId, newText));
	}

	/**
	 * 处理新建节点  请求
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String newId = request.getParameter("newId");
		String FuId = request.getParameter("FuId");
		String newText = request.getParameter("newText");
		dao.add(new TreeNode(newId, newText, FuId));
	}
	
	/**
	 * ajax请求时，type:put次方法不执行
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newId = request.getParameter("id");
		String newText = request.getParameter("newText");
		dao.reName(new TreeNode(newId, newText));
	}

}
