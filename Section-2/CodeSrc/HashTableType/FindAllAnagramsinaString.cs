using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Utils.Log;

namespace CodeSrc.HashTableType
{
    class FindAllAnagramsinaString
    {
        private const string Tag = "FindAllAnagramsinaString";

        public IList<int> FindAnagrams(string s, string p)
        {
            IList<int> res = new List<int>();
            if (string.IsNullOrEmpty(s) || s.Length < p.Length)
            {
                return res;
            }

            Dictionary<char, int> pDic = ConvertToDic(p);
            Dictionary<char, int> sPartDic = null;
            Queue<char> chQueue  = new Queue<char>();
            for (int i = 0; i < s.Length; i++)
            {
                if (chQueue.Count < p.Length - 1)
                {
                    chQueue.Enqueue(s[i]);
                }
                else if (chQueue.Count == p.Length - 1)
                {
                    chQueue.Enqueue(s[i]);
                    sPartDic = CountQueueCh(chQueue);
                    if (CompareDic(sPartDic, pDic))
                    {
                        res.Add(i - p.Length + 1);
                    }
                }
                else
                {
                    chQueue.Enqueue(s[i]);
                    char firstCh = chQueue.Dequeue();
                    AddOneCh(sPartDic, s[i]);
                    DeleteOneCh(sPartDic, firstCh);
                    if (CompareDic(sPartDic, pDic))
                    {
                        res.Add(i - p.Length + 1);
                    }
                }
            }
            return res;
        }

        

        private Dictionary<char, int> ConvertToDic(string p)
        {
            Dictionary<char, int> dic = new Dictionary<char, int>();
            foreach (char ch in p.ToCharArray())
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
            return dic;
        }

        private Dictionary<char, int> CountQueueCh(Queue<char> chQueue)
        {
            Dictionary<char, int> dic = new Dictionary<char, int>();
            char[] chArr = new char[chQueue.Count];
            chQueue.CopyTo(chArr, 0);

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
            return dic;
        }

        private Dictionary<char, int> DeleteOneCh(Dictionary<char, int> dic, char target)
        {
            if (dic.ContainsKey(target))
            {
                if (dic[target] == 1)
                {
                    dic.Remove(target);
                }
                else
                {
                    dic[target]--;
                }
            }
            return dic;
        }

        private Dictionary<char, int> AddOneCh(Dictionary<char, int> dic, char target)
        {
            if (dic.ContainsKey(target))
            {
                dic[target]++;
            }
            else
            {
                dic.Add(target, 1);
            }
            return dic;
        }

        private bool CompareDic(Dictionary<char, int> dic1, Dictionary<char, int> dic2)
        {
            if (dic1.Count != dic2.Count)
            {
                return false;
            }
            foreach (char ch in dic1.Keys)
            {
                if (!dic2.ContainsKey(ch))
                {
                    return false;
                }
                if (dic2[ch] != dic1[ch])
                {
                    return false;
                }
            }
            return true;
        }

        public static void Main(string[] args)
        {
            const string s = "cbaebabacd";
            const string p = "abc";
            var demo = new FindAllAnagramsinaString();
            LogUtils.D(Tag, demo.FindAnagrams(s, p));
        }
    }
}
