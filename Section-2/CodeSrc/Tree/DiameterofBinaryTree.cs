using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Utils.DS;

namespace CodeSrc.Tree
{
    class DiameterofBinaryTree
    {
        public int DiameterOfBinaryTree(TreeNode root)
        {
            if (root == null)
            {
                return 0;
            }
            else if (root.left == null || root.right == null)
            {
                return GetMaxDeep(root.left, 0) + GetMaxDeep(root.right, 0) + 1;
            }
            else
            {
                return GetMaxDeep(root.left, 0) + GetMaxDeep(root.right, 0) + 2;
            }
        }

        public int GetMaxDeep(TreeNode root, int deep)
        {
            if (root == null)
            {
                return deep - 1;
            }
            else if (root.left == null && root.right == null)
            {
                return deep;
            }

            return Math.Max(GetMaxDeep(root.left, deep + 1), GetMaxDeep(root.right, deep + 1));
        }
    }
}
