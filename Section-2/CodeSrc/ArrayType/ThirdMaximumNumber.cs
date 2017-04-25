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
            DuplicateArr(nums);
            return GetThirdNum(nums);
        }

        private void DuplicateArr(int[] nums)
        {
        }

        private int GetThirdNum(int[] nums)
        {
            if (nums.Length == 1)
            {
                return nums[0];
            }
            else if (nums.Length == 2)
            {
                return Math.Max(nums[0], nums[1]);
            }

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < nums.Length - 1 - i; j++)
                {
                    if (nums[j] > nums[j + 1])
                    {
                        swap(nums, j, j + 1);
                    }
                }
            }
            return nums[nums.Length - 3];
        }

        private void swap(int[] nums, int i, int j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public static void Main(string[] args)
        {
            int[] arr = new int[] { 3, 2, 1};
            var demo = new ThirdMaximumNumber();
            LogUtils.D(Tag, demo.ThirdMax(arr));
        }
    }
}
