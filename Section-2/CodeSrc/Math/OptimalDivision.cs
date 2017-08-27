using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeSrc.Math
{
    class OptimalDivision
    {
        public string OptimalDivisionM(int[] nums)
        {
            if (nums.Length == 1)
            {
                return nums[0].ToString();
            }
            else if (nums.Length == 2)
            {
                return nums[0] + "/" + nums[1];
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.Length; i++)
            {
                sb.Append(nums[i] + "/");
                if (i == 0)
                {
                    sb.Append("(");
                }
            }
            sb.Remove(sb.Length - 1, 1);
            sb.Append(")");
            return sb.ToString();
        }
    }
}
