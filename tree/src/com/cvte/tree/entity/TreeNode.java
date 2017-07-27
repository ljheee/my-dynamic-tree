package com.cvte.tree.entity;

/**
 * 树节点--实体类
 */
public class TreeNode {
	
	private String id;//节点的 id，它对于加载远程数据很重要。
	private String text;//要显示的节点文本。
	private String pid;
	private TreeNode[] children;//定义了一些子节点的节点数组。
	
	public TreeNode() {
	}

	public TreeNode(String id, String text, String pid) {
		this.id = id;
		this.text = text;
		this.pid = pid;
	}

	public TreeNode(String id, String text) {
		this.id = id;
		this.text = text;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public String getPid() {
		return pid;
	}



	public void setPid(String pid) {
		this.pid = pid;
	}

	
	
}
