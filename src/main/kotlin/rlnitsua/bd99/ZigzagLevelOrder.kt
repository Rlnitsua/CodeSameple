package rlnitsua.bd99

import java.util.*

class ZigzagLevelOrder {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        root ?: return res
        val queue = LinkedList<TreeNode>()

        while (queue.isNotEmpty()) {
            val size = queue.size
            val list = mutableListOf<Int>()
            for (i in 0 until size) {
                val curr = queue.poll()
                if (res.size % 2 == 0) {
                    list.add(curr.`val`)
                } else {
                    list.add(0, curr.`val`)
                }
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