package com.cvte.tree.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cvte.tree.dao.ITreeDao;
import com.cvte.tree.entity.TreeNode;

/**
 * 操作DB 的接口 实现
 */
public class ITreeDaoImpl implements ITreeDao {

	public static final String DBURL = "jdbc:mysql://172.18.81.146:3306/leejh_test2";
	public static final String USERNAME = "leejh";
	public static final String PASSWD = "leejh2017";

	private volatile Connection con;

	/**
	 * 获得Connection
	 * 
	 * @return
	 */
	private Connection getConnection() {

		if (con == null) {
			try {
				synchronized (Connection.class) {
					if (con == null) {
						Class.forName("com.mysql.jdbc.Driver");//
						con = DriverManager.getConnection(DBURL, USERNAME, PASSWD);
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	/**
	 * 新建节点
	 */
	@Override
	public boolean add(TreeNode node) {
		boolean result = false;
		String sql = "INSERT INTO `leejh_test2`.`treedata` (`id`, `text`, `pid`, `create_time`, `update_time`) VALUES ( ?, ?, ?, ?, ?);";
		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, node.getId());
			ps.setString(2, node.getText());
			ps.setString(3, node.getPid());
			ps.setFloat(4, new Date().getTime());
			ps.setFloat(5, new Date().getTime());
			result = ps.execute();
			if (result == false) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 重命名节点
	 */
	@Override
	public boolean reName(TreeNode node) {

		boolean result = false;
		String sql = "UPDATE `leejh_test2`.`treedata` SET`text`=? WHERE `id`=?";
		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, node.getText());
			ps.setString(2, node.getId());
			result = ps.execute();
			if (result == false) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 移除节点
	 */
	@Override
	public boolean remove(String nodeId) {
		boolean result = false;
		String sql = "DELETE FROM `leejh_test2`.`treedata`  WHERE `id`=?";
		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, nodeId);
			result = ps.execute();
			if (result == false) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 拖拽节点
	 */
	@Override
	public boolean drag(String sourceId, String targetId, String dragNewId) {
		boolean result = false;
		String sql = "UPDATE `leejh_test2`.`treedata` SET `id`=?, `pid`=? WHERE `id`=?";
		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, dragNewId);
			ps.setString(2, targetId);
			ps.setString(3, sourceId);
			result = ps.execute();
			if (result == false) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public List<TreeNode> getChildren(String fuId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询--直系孩子节点 异步加载，每次只加载一个节点的数据
	 */
	@Override
	public List<TreeNode> getLinealChildren(String groupId) {
		List<TreeNode> list = new ArrayList<>();
		TreeNode node = null;
		String sql = "select id,text,pid from treedata WHERE pid =?";
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, groupId);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String text = rs.getString("text");
				String pid = rs.getString("pid");
				node = new TreeNode(id, text, pid);
				list.add(node);
				node = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
