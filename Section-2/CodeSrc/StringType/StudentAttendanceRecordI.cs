using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeSrc.StringType
{
    class StudentAttendanceRecordI
    {
        public bool CheckRecord(string s)
        {
            if (string.IsNullOrEmpty(s))
            {
                return false;
            }

            int aCount = 0;
            int lCount = 0;

            foreach (char ch in s.ToCharArray())
            {
                if (ch.Equals('A'))
                {
                    lCount = 0;
                    aCount++;
                }
                else if (ch.Equals('L'))
                {
                    lCount++;
                }
                else
                {
                    lCount = 0;
                }
                if (aCount >= 2 || lCount >= 3)
                {
                    return false;
                }
            }
            return true;
        }
    }
}
