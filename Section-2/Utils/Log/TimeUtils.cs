using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Utils.Log
{
    public class TimeUtils
    {
        public static String GetCurrentTime()
        {
            String timePattern = "MM-MM HH:mm:ss.fffff";
            return new DateTime().ToString(timePattern);
        }
    }
}
