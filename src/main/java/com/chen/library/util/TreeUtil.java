package com.chen.library.util;

import java.util.ArrayList;
import java.util.List;


public class TreeUtil {

	/**
	 * 将List<TreeNode>类型转换成树列表（方法1)
	 * 
	 * @param list
	 * @return
	 */
	public static List<TreeNode> listGetStree(List<TreeNode> list) {
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		for (TreeNode tree : list) {
			// 找到根
			if (tree.getPid().equals("0") || tree.getPid().equals("00")) {
				treeList.add(tree);
			}
			// 找到子
			for (TreeNode treeNode : list) {
				if (treeNode.getPid().equals(tree.getId())) {
					if (tree.getChildren() == null) {
						tree.setChildren(new ArrayList<TreeNode>());
					}
					tree.getChildren().add(treeNode);
				}
			}
		}
		return treeList;
	}

	/**
	 * 将List<TreeNode>类型转换成树列表(方法2)
	 * 
	 * @param list
	 * @return
	 */
	public static List<TreeNode> listToTree(List<TreeNode> list) {
		// 用递归找子。
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		for (TreeNode tree : list) {
			if (tree.getPid().equals("0")) {
				treeList.add(findChildren(tree, list));
			}
		}
		return treeList;
	}

	/**
	 * 获取当前节点下的子节点。
	 * 
	 * @param list
	 * @return
	 */
	private static TreeNode findChildren(TreeNode tree, List<TreeNode> list) {
		for (TreeNode node : list) {
			if (node.getPid().equals(tree.getId())) {
				if (tree.getChildren() == null) {
					tree.setChildren(new ArrayList<TreeNode>());
				}
				tree.getChildren().add(findChildren(node, list));
			}
		}
		return tree;
	}

	/**
	 * 将List<TreeNode>类型转换成树列表(方法3）
	 * 
	 * @param list
	 * @return
	 */
	private static List<TreeNode> toTree(List<TreeNode> list) {
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		for (TreeNode tree : list) {
			if (tree.getPid().equals("0")) {
				treeList.add(tree);
			}
		}
		for (TreeNode tree : list) {
			toTreeChildren(treeList, tree);
		}
		return treeList;
	}

	/**
	 * 转换树Children节点
	 * 
	 * @param treeList
	 * @param tree
	 */
	private static void toTreeChildren(List<TreeNode> treeList, TreeNode tree) {
		for (TreeNode node : treeList) {
			if (tree.getPid().equals(node.getId())) {
				if (node.getChildren() == null) {
					node.setChildren(new ArrayList<TreeNode>());
				}
				node.getChildren().add(tree);
			}
			if (node.getChildren() != null) {
				toTreeChildren(node.getChildren(), tree);
			}
		}
	}
}
