package com.cvte.tree.dao;

import java.util.List;

import com.cvte.tree.entity.TreeNode;
/**
 * 操作DB 的接口
 */
public interface ITreeDao {
	public abstract boolean add(TreeNode node);
	public abstract boolean reName(TreeNode node);
	public abstract boolean remove(String nodeId);
	public abstract boolean drag(String sourceId, String targetId, String dragNewId);
	public abstract List<TreeNode> getChildren(String fuId);
	public abstract List<TreeNode> getLinealChildren(String groupId);
}
