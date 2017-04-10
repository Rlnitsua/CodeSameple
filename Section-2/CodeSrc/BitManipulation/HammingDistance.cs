using System;
using Utils.Log;

namespace CodeSrc.BitManipulation
{
    class HammingDistance
    {
        private const String tag = "HammingDistance";

        static void Main(String[] args)
        {
            LogUtils.D(tag, new HammingDistance().HammingDistance0(2, 2));
        }

        public int HammingDistance0(int x, int y)
        {
            int z = x ^ y;

            int count = 0;

            while (z >= 1)
            {
                if (z % 2 == 1)
                {
                    count++;
                }
                z /= 2;
            }

            return count;
        }

    }
}
