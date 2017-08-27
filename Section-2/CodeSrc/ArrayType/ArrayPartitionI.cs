using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeSrc.ArrayType
{
    class ArrayPartitionI
    {
        public int ArrayPairSum(int[] nums)
        {
            if (nums == null || nums.Length == 0)
            {
                return 0;
            }

            Array.Sort(nums);

            int res = 0;
            for (int i = 0; i < nums.Length; i += 2)
            {
                res += nums[i];
            }
            return res;
        }
    }
}
