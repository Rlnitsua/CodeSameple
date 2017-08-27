using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Utils.Log;

namespace CodeSrc.ArrayType
{
    class ThirdMaximumNumber
    {
        private const string Tag = "ThirdMaximumNumber";

        public int ThirdMax(int[] nums)
        {
            SortedSet<int> sortedSet = new SortedSet<int>();
            foreach (int num in nums)
            {
                if (!sortedSet.Contains(num))
                {
                    sortedSet.Add(num);
                }
            }

            if (sortedSet.Count < 3)
            {
                return sortedSet.Max;
            }

            int index = 0;
            int res = 0;
            foreach (int num in sortedSet)
            {
                res = num;
                if (index == sortedSet.Count - 3)
                {
                    return res;
                }
                index++;
            }
            return res;
        }
        
        public static void Main(string[] args)
        {
            int[] arr = new int[] { 3, 2, 1};
            var demo = new ThirdMaximumNumber();
            LogUtils.D(Tag, demo.ThirdMax(arr));
        }
    }
}
