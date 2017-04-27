using System;
using System.Collections.Generic;
using System.ComponentModel.Design;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Utils.DS;

namespace CodeSrc.Tree
{
    class BinaryTreeTilt
    {
        public int FindTilt(TreeNode root)
        {
            int res = 0;
            if (root == null)
            {
                return 0;
            }

            res += CalculateTilt(root);
            res += FindTilt(root.left);
            res += FindTilt(root.right);

            return res;
        }

        private int CalculateTilt(TreeNode root)
        {
            return System.Math.Abs(CalculateSum(root.left) - CalculateSum(root.right));
        }

        private int CalculateSum(TreeNode root)
        {
            int sum = 0;
            if (root == null)
            {
                return 0;
            }

            sum += root.val;
            sum += CalculateSum(root.left);
            sum += CalculateSum(root.right);

            return sum;
        }
    }
}
