package rlnitsua.design;

import org.junit.Assert;
import org.junit.Test;

public class ThroneInheritanceTest {

    @Test
    public void test() {
        ThroneInheritanceTLE demo = new ThroneInheritanceTLE("king");
        demo.birth("king", "andy"); // order: king > andy
        demo.birth("king", "bob"); // order: king > andy > bob
        demo.birth("king", "catherine"); // order: king > andy > bob > catherine
        demo.birth("andy", "matthew"); // order: king > andy > matthew > bob > catherine
        demo.birth("bob", "alex"); // order: king > andy > matthew > bob > alex > catherine
        demo.birth("bob", "asha"); // order: king > andy > matthew > bob > alex > asha > catherine
        Assert.assertArrayEquals(new String[]{"king", "andy", "matthew", "bob", "alex", "asha", "catherine"},
                demo.getInheritanceOrder().toArray());
        demo.death("bob"); // order: king > andy > matthew > bob > alex > asha > catherine
        Assert.assertArrayEquals(new String[]{"king", "andy", "matthew", "alex", "asha", "catherine"},
                demo.getInheritanceOrder().toArray());
    }
}