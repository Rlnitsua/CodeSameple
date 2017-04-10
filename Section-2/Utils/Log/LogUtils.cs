using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Utils.Log
{
    public class LogUtils
    {
        private static String dVersion = "D";
        private static String colonTag = ":";
        private static String slashTag = "/";
        private static String blankTag = " ";

        public static void D(String TAG, String content)
        {
            String currentTime = TimeUtils.GetCurrentTime();
            String fileTag = dVersion + slashTag + TAG + colonTag + blankTag;
            Console.WriteLine(currentTime + blankTag + fileTag + blankTag + content);
        }

        public static void D(String TAG, int content)
        {
            String currentTime = TimeUtils.GetCurrentTime();
            String fileTag = dVersion + slashTag + TAG + colonTag + blankTag;
            Console.WriteLine(currentTime + blankTag + fileTag + blankTag + content);
        }
    }
}
