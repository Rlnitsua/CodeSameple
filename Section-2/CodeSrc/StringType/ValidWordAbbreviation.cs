using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Utils.Log;

namespace CodeSrc.StringType
{
    class ValidWordAbbreviation
    {
        private const string Tag = "internationalization";

        public bool ValidWord(string word, string abbr)
        {
            if (!JdugeLength(word, abbr))
            {
                return false;
            }

            int wordIndex = 0;
            int abbrIndex = 0;
            while (abbrIndex < abbr.Length)
            {
                if (char.IsLower(abbr[abbrIndex]))
                {
                    if (abbr[abbrIndex] != word[wordIndex])
                    {
                        return false;
                    }
                    abbrIndex++;
                    wordIndex++;
                }
                else
                {
                    if (abbr[abbrIndex].Equals('0'))
                    {
                        return false;
                    }

                    int numTag = abbrIndex + 1;
                    while (numTag < abbr.Length)
                    {
                        if (char.IsNumber(abbr[numTag]))
                        {
                            numTag++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    int number = GetNum(abbr.Substring(abbrIndex, numTag - abbrIndex));
                    abbrIndex += numTag - abbrIndex;
                    wordIndex += number;

                    if (abbrIndex == abbr.Length && wordIndex == word.Length)
                    {
                        return true;
                    }

                    if (wordIndex >= word.Length)
                    {
                        return false;
                    }
                }
            }
            return true;
        }

        private bool JdugeLength(string word, string abbr)
        {
            int length = 0;
            int abbrIndex = 0;

            while (abbrIndex < abbr.Length)
            {
                if (char.IsNumber(abbr[abbrIndex]))
                {
                    int numTag = abbrIndex + 1;
                    while (numTag < abbr.Length)
                    {
                        if (char.IsNumber(abbr[numTag]))
                        {
                            numTag++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    int number = GetNum(abbr.Substring(abbrIndex, numTag - abbrIndex));

                    abbrIndex += numTag - abbrIndex;
                    length += number;
                }
                else
                {
                    length++;
                    abbrIndex++;
                }
            }

            return word.Length == length;
        }

        private int GetNum(String number)
        {
            return int.Parse(number);
        }

        public static void Main(string[] args)
        {
            const string word = "internationalization";
            const string abbr = "i5a11o1";
            var demo = new ValidWordAbbreviation();
            LogUtils.D(Tag, demo.ValidWord(word, abbr));
        }
    }
}
