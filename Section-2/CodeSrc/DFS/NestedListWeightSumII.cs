using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;
using Utils.DS;
using Utils.Log;

namespace CodeSrc.DFS
{
    class NestedListWeightSumII
    {
        private const string Tag = "NestedListWeightSumII";

        public int DepthSumInverse(IList<NestedInteger> nestedList)
        {
            int deep = GetDeep(nestedList);
            return CalculateSum(nestedList, deep);
        }

        private int GetDeep(IList<NestedInteger> nestelIntegers)
        {
            // at lease 1 deep 
            // d([[1]]) = 2, d([1,1,1]) = 1 
            int deep = 1;
            int childDeep = 0;
            foreach (NestedInteger e in nestelIntegers)
            {
                if (!e.IsInteger())
                {
                    childDeep = System.Math.Max(childDeep, GetDeep(e.GetList()));
                }
            }
            deep += childDeep;
            return deep;
        }

        private int CalculateSum(IList<NestedInteger> nestedList, int deep)
        {
            int res = 0;
            foreach (NestedInteger e in nestedList)
            {
                if (e.IsInteger())
                {
                    res += e.GetInteger() * deep;
                }
                else
                {
                    res += CalculateSum(e.GetList(), deep - 1);
                }
            }
            return res;
        }

        public static void Main(string[] args)
        {
            IList<NestedInteger> source = CreateIList();
            var demo = new NestedListWeightSumII();
            LogUtils.D(Tag, demo.DepthSumInverse(source));
        }

        private static IList<NestedInteger> CreateIList()
        {
            IList<NestedInteger> source = new List<NestedInteger>();
            var e1 = new NestedIntegerImpl(1);
            e1.Add(new NestedIntegerImpl(1));
            source.Add(e1);
            source.Add(new NestedIntegerImpl(2));
            source.Add(e1);
            return source;
        }
    }
}
