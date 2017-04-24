using System;
using Utils.Log;

namespace CodeSrc.StringType
{
    class LongestUncommonSubsequenceI
    {
        private const string Tag = "LongestUncommonSubsequenceI";

        public int FindLUSlength(string a, string b)
        {
            if (a.Length != b.Length)
            {
                return Math.Max(a.Length, b.Length);
            }
            else
            {
                return a.Equals(b) ? -1 : a.Length;
            }
        }
        
        public static void Main(string[] args)
        {
            const string a = "aba";
            const string b = "cdc";
            var unCommomS = new LongestUncommonSubsequenceI();
            LogUtils.D(Tag, unCommomS.FindLUSlength(a, b));
        }
    }
}
