package swordoffer;

import swordoffer.data.TreeLinkNode;

/**
 * Created by Weicools on 2018/4/22.
 * <p>
 * desc: 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class SOBinaryTreeNextNode {
    public TreeLinkNode getNextNode(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }

        return null;
    }
}
