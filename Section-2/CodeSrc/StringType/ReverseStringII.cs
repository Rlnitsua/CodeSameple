using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Utils.Log;

namespace CodeSrc.StringType
{
    class ReverseStringII
    {
        private const string TAG = "ReverseStringII";

        public string ReverseStr(string s, int k)
        {
            var res = new StringBuilder();
            for (int i = 0; i < s.Length; i += 2 * k)
            {
                int lastIndex = (i + 2 * k - 1) >= s.Length ? s.Length - i : 2 * k;
                res.Append(HandleTarget(s.Substring(i, lastIndex), k));
            }
            return res.ToString();
        }

        private string HandleTarget(string target, int k)
        {
            if (target.Length < k)
            {
                return ReverseTarget(target);
            }
            else
            {
                string res = ReverseTarget(target.Substring(0, k));
                res += target.Substring(k, target.Length - k);
                return res;
            }
        }

        private string ReverseTarget(string substring)
        {
            Stack<char> stack = new Stack<char>();
            foreach (char ch in substring.ToCharArray())
            {
                stack.Push(ch);
            }
            StringBuilder sb = new StringBuilder();
            while (stack.Count != 0)
            {
                sb.Append(stack.Pop());
            }
            return sb.ToString();
        }

        public static void Main(string[] args)
        {
            const string s = "abcdefg";
            var demo = new ReverseStringII();
            LogUtils.D(TAG, demo.ReverseStr(s, 2));
        }
    }
}
