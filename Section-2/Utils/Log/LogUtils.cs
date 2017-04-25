using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Utils.Log
{
    public class LogUtils
    {
        private static string dVersion = "D";
        private static string colonTag = ":";
        private static string slashTag = "/";
        private static string blankTag = " ";

        public static void D(string tag, String content)
        {
            string currentTime = TimeUtils.GetCurrentTime();
            string fileTag = dVersion + slashTag + tag + colonTag;
            Console.WriteLine(currentTime + blankTag + fileTag + blankTag + content);
        }

        public static void D(string tag, bool content)
        {
            string currentTime = TimeUtils.GetCurrentTime();
            string fileTag = dVersion + slashTag + tag + colonTag;
            Console.WriteLine(currentTime + blankTag + fileTag + blankTag + content);
        }

        public static void D(string tag, int content)
        {
            string currentTime = TimeUtils.GetCurrentTime();
            string fileTag = dVersion + slashTag + tag + colonTag + blankTag;
            Console.WriteLine(currentTime + blankTag + fileTag + blankTag + content);
        }

        public static void D<T>(string tag, IList<T> list)
        {
            string currentTime = TimeUtils.GetCurrentTime();
            string fileTag = dVersion + slashTag + tag + colonTag + blankTag;
            string content = GetContent<T>(list);
            Console.WriteLine(currentTime + blankTag + fileTag + blankTag + content);
        }

        private static string GetContent<T>(IList<T> list)
        {
            StringBuilder content = new StringBuilder();
            content.Append("[");
            foreach (T e in list)
            {
                content.Append(e + ",");
            }
            content.Remove(content.Length - 1, 1);
            content.Append("]");
            return content.ToString();
        }
    }
}
