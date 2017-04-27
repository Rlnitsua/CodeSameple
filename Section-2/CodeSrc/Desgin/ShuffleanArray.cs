using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeSrc.Desgin
{
    class ShuffleanArray
    {
        private int[] numsCopy = null;
        private Random random;

        public ShuffleanArray(int[] nums)
        {
            numsCopy = nums;
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] Reset()
        {
            return numsCopy;
        }

        /** Returns a random shuffling of the array. */
        public int[] Shuffle()
        {
            int[] shuffleArray = (int[]) numsCopy.Clone();

            for (int i = 1; i < numsCopy.Length; i++)
            {
                int j = random.Next(i + 1);
                swap(shuffleArray, i, j);
            }

            return shuffleArray;
        }

        private void swap(int[] shuffleArray, int i, int j)
        {
            int temp = shuffleArray[i];
            shuffleArray[i] = shuffleArray[j];
            shuffleArray[j] = temp;
        }
    }
}
