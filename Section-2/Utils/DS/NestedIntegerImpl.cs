using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Utils.DS
{
    public class NestedIntegerImpl : NestedInteger
    {
        private int integer = 0;
        private bool isIntger = true;
        private IList<NestedInteger> nestedList;

        public NestedIntegerImpl()
        {
            nestedList = new List<NestedInteger>();
        }

        public NestedIntegerImpl(int value)
        {
            integer = value;
            nestedList = new List<NestedInteger>();
        }

        public bool IsInteger()
        {
            return isIntger;
        }

        public int GetInteger()
        {
            return integer;
        }

        public void SetInteger(int value)
        {
            integer = value;
        }

        public void Add(NestedInteger ni)
        {
            isIntger = false;
            
            if (this.isIntger)
            {
                nestedList.Add(new NestedIntegerImpl(integer));
            }
            else
            {
                nestedList.Add(ni);
            }
            nestedList.Add(ni);
        }

        public IList<NestedInteger> GetList()
        {
            return nestedList;
        }
    }
}
