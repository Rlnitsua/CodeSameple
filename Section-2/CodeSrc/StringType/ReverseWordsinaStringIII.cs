using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Log;

namespace CodeSrc.StringType
{
    class ReverseWordsinaStringIII
    {
        private const string tag = "ReverseWordsinaStringIII";

        public string ReverseWords(string s)
        {
            if (s == null || s.Equals(" "))
            {
                return s;
            }

            char[] chArr = s.ToArray();
            StringBuilder sb = new StringBuilder();
            Stack<char> stack = new Stack<char>();

            foreach (char ch in chArr)
            {
                if (ch.Equals(' '))
                {
                    while (stack.Count != 0)
                    {
                        sb.Append(stack.Pop());
                    }
                    sb.Append(ch);
                }
                else
                {
                    stack.Push(ch);
                }
            }

            while (stack.Count != 0)
            {
                sb.Append(stack.Pop());
            }

            return sb.ToString();
        }

        public static void Main(string[] args)
        {
            string msg = "Let's take LeetCode contest";
            LogUtils.D(tag, new ReverseWordsinaStringIII().ReverseWords(msg));
        }
    }
}
