package 树;


import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Day3 {
    public static void main(String[] args) {
        Day3 day3 = new Day3();
        TreeNode ans = day3.inorderSuccessor(new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(2));
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        TreeNode ans = null;
        if (p.right!=null){
            ans = p.right;
            while (ans.left != null){
                ans = ans.left;
            }
            return ans;
        }
        TreeNode node = root;
        while (node!=null){
            if (node.val > p.val){
                ans = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ans;
    }

//    List<TreeNode> list;
//
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        list = new ArrayList<>();
//        dfs(root);
//        list.add(null);
//        for (int i = 0; i < list.size()-1; ++i){
//            if (list.get(i) == p){
//                return list.get(i+1);
//            }
//        }
//        return null;
//    }
//
//    public void dfs(TreeNode node){
//        if (node == null){
//            return;
//        }
//        dfs(node.left);
//        list.add(node);
//        dfs(node.right);
//    }

}
