using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Utils.Log
{
    public class LogUtils
    {
        public static String dVersion = "D";
        public static String colonTag = ":";
        public static String slashTag = "/";
        public static String blankTag = " ";

        public static void D(String TAG, String content)
        {
            String currentTime = TimeUtils.GetCurrentTime();
            String fileTag = dVersion + slashTag + TAG + colonTag + blankTag;
            Console.WriteLine(currentTime + blankTag + fileTag + blankTag + content);
        }
    }
}
