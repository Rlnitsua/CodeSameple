using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Utils.Log;

namespace CodeSrc.Graph
{
    class FriendCircles
    {
        private const string Tag = "FriendCircles";

        public int FindCircleNum(int[,] M)
        {
            int maxCount = M.GetLength(0);
            int maxRow = M.GetLength(0);
            int maxColumn = M.GetLength(1);
            IList<IList<int>> circleList = new List<IList<int>>();

            for (int i = 0; i < maxRow; i++) {
                for (int j = i + 1; j < maxColumn; j++) {
                    if (M[j, i] == 1)
                    {
                        if (BothSingle(circleList, j, i))
                        {
                            IList<int> list = new List<int>();
                            list.Add(i);
                            list.Add(j);
                            circleList.Add(list);
                            maxCount--;
                        }
                        else if (SingleAndCircle(circleList, j, i))
                        {
                            if (IsExist(circleList, j))
                            {
                                FindCircle(circleList, j).Add(i);
                            }
                            else
                            {
                                FindCircle(circleList, i).Add(j);
                            }
                            maxCount--;
                        }
                        else if (TwoCircle(circleList, j, i))
                        {
                            IList<int> oneCircle = FindCircle(circleList, j);
                            circleList.RemoveAt(FindCircleIndex(circleList, j));
                            foreach (int e in oneCircle)
                            {
                                FindCircle(circleList, i).Add(e);
                            }
                            maxCount--;
                        }
                        else
                        {
                            // do not handle this situation
                        }
                    }
                }
            }

            return maxCount;
        }

        private bool BothSingle(IList<IList<int>> circleList, int i, int j)
        {
            return !IsExist(circleList, i) && !IsExist(circleList, j);
        }

        private bool SingleAndCircle(IList<IList<int>> circleList, int i, int j)
        {
            return (IsExist(circleList, i) && !IsExist(circleList, j)) || 
                (!IsExist(circleList, i) && IsExist(circleList, j));
        }

        private bool TwoCircle(IList<IList<int>> circleList, int i, int j)
        {
            return (IsExist(circleList, i) && IsExist(circleList, j)) &&
                (FindCircleIndex(circleList, i) != FindCircleIndex(circleList, j));
        }

        private bool IsExist(IList<IList<int>> circleList, int i)
        {
            foreach (IList<int> list in circleList)
            {
                if (list.Contains(i))
                {
                    return true;
                }
            }
            return false;
        }

        private IList<int> FindCircle(IList<IList<int>> circleList, int i)
        {
            foreach (IList<int> list in circleList)
            {
                if (list.Contains(i))
                {
                    return list;
                }
            }
            return null;
        }

        private int FindCircleIndex(IList<IList<int>> circleList, int x)
        {
            for (int i = 0; i < circleList.Count; i++)
            {
                if (circleList[i].Contains(x))
                {
                    return i;
                }
            }
            return -1;
        }

        public static void Main(string[] args)
        {
            int[,] M =
            {
                { 1, 0, 0, 1 }, 
                { 0, 1, 1, 0 }, 
                { 0, 1, 1, 1 }, 
                { 1, 0, 1, 1 }
            };
            var demo = new FriendCircles();
            LogUtils.D(Tag, demo.FindCircleNum(M));
        }
    }
}
