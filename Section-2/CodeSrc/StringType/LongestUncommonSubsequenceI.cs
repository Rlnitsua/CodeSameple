using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Utils.Log;

namespace CodeSrc.StringType
{
    class LongestUncommonSubsequenceI
    {
        private const String tag = "LongestUncommonSubsequenceI";

        public int FindLUSlength(string a, string b)
        {
            Dictionary<char, int> dic = new Dictionary<char, int>();
            AddChIntoDic(dic, a.ToCharArray());
            AddWithDelete(dic, b.ToCharArray());
            int commomElementCount = a.Length + b.Length - CountDic(dic);
            return Math.Min(a.Length, b.Length) - commomElementCount;
        }

        private void AddChIntoDic(Dictionary<char, int> dic, char[] chArr)
        {
            foreach (char ch in chArr)
            {
                if (dic.ContainsKey(ch))
                {
                    dic[ch]++;
                }
                else
                {
                    dic.Add(ch, 1);
                }
            }
        }

        private void AddWithDelete(Dictionary<char, int> dic, char[] chArr)
        {
            foreach (char ch in chArr)
            {
                if (dic.ContainsKey(ch))
                {
                    if (dic[ch] == 1)
                    {
                        dic.Remove(ch);
                    }
                    else
                    {
                        dic[ch]--;
                    }
                }
                else
                {
                    dic.Add(ch, 1);
                }
            }
        }

        private int CountDic(Dictionary<char, int> dic)
        {
            int count = 0;
            foreach (char ch in dic.Keys)
            {
                count += dic[ch];
            }
            return count;
        }

        public static void Main(String[] args)
        {
            String a = "aba";
            String b = "cdc";
            LongestUncommonSubsequenceI unCommomS = new LongestUncommonSubsequenceI();
            LogUtils.D(tag, unCommomS.FindLUSlength(a, b));
        }
    }
}
