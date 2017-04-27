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
            var res = int.MinValue;
            if (root == null)
            {
                return 0;
            }

            res = System.Math.Max(res, CalculateLRSum(root));
            res = System.Math.Max(res, DiameterOfBinaryTree(root.left));
            res = System.Math.Max(res, DiameterOfBinaryTree(root.right));

            return res;
        }

        private int CalculateLRSum(TreeNode root)
        {
            if (root == null)
            {
                return 0;
            }

            int leftDeep = root.left == null ? 0 : getDeep(root.left);
            int rightDeep = root.right == null ? 0 : getDeep(root.right);
            return leftDeep + rightDeep;
        }

        private int getDeep(TreeNode root)
        {
            if (root == null)
            {
                return 0;
            }
            return System.Math.Max(getDeep(root.left), getDeep(root.right)) + 1;
        }
    }
}
