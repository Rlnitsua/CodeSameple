using System.Collections.Generic;
using Utils.DS;

namespace CodeSrc.BST
{
    class MinimumAbsoluteDifferenceinBST
    {
        public int GetMinimumDifference(TreeNode root)
        {
            List<int> valList = new List<int>();
            GetList(root, valList);

            return GetMinDiff(valList);
        }

        private void GetList(TreeNode root, List<int> valList)
        {
            if (root == null)
            {
                return;
            }

            GetList(root.left, valList);
            valList.Add(root.val);
            GetList(root.right, valList);
        }

        private int GetMinDiff(List<int> valList)
        {
            int minDiff = int.MaxValue;
            for (int i = 0; i < (valList.Count - 1); i++)
            {
                minDiff = System.Math.Min(minDiff, System.Math.Abs(valList[i + 1] - valList[i]));
            }
            return minDiff;
        }
    }
}
