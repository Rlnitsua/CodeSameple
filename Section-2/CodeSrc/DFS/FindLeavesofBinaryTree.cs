using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Utils.DS;
using Utils.Log;

namespace CodeSrc.DFS
{
    class FindLeavesofBinaryTree
    {
        private const string Tag = "FindLeavesofBinaryTree";
        public IList<IList<int>> FindLeaves(TreeNode root)
        {
            IList<IList<int>> res = new List<IList<int>>();
            while (root != null)
            {
                res.Add(GetLeaves(root));
                deleteLeaves(ref root);
            }
            return res;
        }

        public IList<int> GetLeaves(TreeNode root)
        {
            List<int> leaves = new List<int>();
            if (root == null)
            {
                return leaves;
            }

            if (root.left == null && root.right == null)
            {
                leaves.Add(root.val);
            }
            leaves.AddRange(GetLeaves(root.left));
            leaves.AddRange(GetLeaves(root.right));
            return leaves;
        }

        private void deleteLeaves(ref TreeNode root)
        {
            if (root == null)
            {
                return;
            }

            if (root.left == null && root.right == null)
            {
                root = null;
                return;
            }
            deleteLeaves(ref root.left);
            deleteLeaves(ref root.right);
        }

        public static void Main(string[] args)
        {
            var demo = new FindLeavesofBinaryTree();
            LogUtils.D(Tag, demo.FindLeaves(demo.CreateRootNode()));
        }

        private TreeNode CreateRootNode()
        {
            TreeNode root = new TreeNode(1);
            TreeNode node1 = new TreeNode(2);
            TreeNode node2 = new TreeNode(3);
            TreeNode node3 = new TreeNode(4);
            TreeNode node4 = new TreeNode(5);

            root.left = node1;
            root.right = node2;
            node1.left = node3;
            node1.right = node4;
            return root;
        }
    }
}
