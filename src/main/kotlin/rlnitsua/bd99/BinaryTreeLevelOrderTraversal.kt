package rlnitsua.bd99

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        // 提供空的默认值
        root ?: return res
        val queue = LinkedList<TreeNode>()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            val list = mutableListOf<Int>()
            for (i in 0 until size) {
                val curr = queue.poll()
                list.add(curr.`val`)
                // 参数空调用
                curr.left?.let {
                    queue.offer(it)
                }
                curr.right?.let {
                    queue.offer(it)
                }
            }
            res.add(list)
        }

        return res
    }
}