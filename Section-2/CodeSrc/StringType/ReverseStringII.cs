using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeSrc.StringType
{
    class ReverseStringII
    {
        public string ReverseStr(string s, int k)
        {
            if (k >= s.Length)
            {
                return ReverseKIndexStr(s, s.Length);
            }
            else
            {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < (s.Length / k); i += 2)
                {
                    sb.Append(ReverseKIndexStr(s.Substring(i * k, 2 * k), k));
                }
                return sb.ToString();
            }
        }

        private string ReverseKIndexStr(string s, int k)
        {
            StringBuilder sb = new StringBuilder();
            Stack<char> stack = new Stack<char>();
            for (int i = 0; i < k; i++)
            {
                stack.Push(s[i]);
            }
            while (stack.Count != 0)
            {
                sb.Append(stack.Pop());
            }
            for (int i = k; i < s.Length; i++)
            {
                sb.Append(s[i]);
            }
            return sb.ToString();
        }
    }
}
