using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Utils.Log
{
    class TimeUtils
    {
        public static String GetCurrentTime()
        {
            return DateTime.Now.ToString("MM-MM HH:mm:ss.fffff");
        }
    }
}
