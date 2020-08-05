package lizbyu.tree;

import lizbyu.utils.log.LogUtils;
import org.junit.Test;

public class PopulatingNextRightPointersinEachNodeTest {
    private static final String TAG = "PopulatingNextRightPointersinEachNodeTest";

    @Test
    public void test() {
        PopulatingNextRightPointersinEachNode demo = new PopulatingNextRightPointersinEachNode();

        PopulatingNextRightPointersinEachNode.Node root = new PopulatingNextRightPointersinEachNode.Node(1);
        PopulatingNextRightPointersinEachNode.Node node2 = new PopulatingNextRightPointersinEachNode.Node(1);
        PopulatingNextRightPointersinEachNode.Node node3 = new PopulatingNextRightPointersinEachNode.Node(1);
        root.left = node2;
        root.right = node3;

        PopulatingNextRightPointersinEachNode.Node node4 = new PopulatingNextRightPointersinEachNode.Node(1);
        PopulatingNextRightPointersinEachNode.Node node5 = new PopulatingNextRightPointersinEachNode.Node(1);
        node2.left = node4;
        node2.right = node5;

        PopulatingNextRightPointersinEachNode.Node node6 = new PopulatingNextRightPointersinEachNode.Node(1);
        PopulatingNextRightPointersinEachNode.Node node7 = new PopulatingNextRightPointersinEachNode.Node(1);
        node3.left = node6;
        node3.right = node7;

        demo.connect(root);

        LogUtils.d(TAG, root);
    }
}