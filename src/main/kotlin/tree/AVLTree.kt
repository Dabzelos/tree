package tree

import interfaces.Tree
import nodes.AVLNode

class AVLTree<K : Comparable<K>, V> : Tree<K, V, AVLNode<K, V>>() {
    override fun insert(key: K, value: V) {
        root = insertVertice(key, value, root)
    }

    override fun delete(key: K) {
        root = deleteVertice(key, root)
    }

    override fun createNode(key: K, value: V): AVLNode<K, V> {
        return AVLNode(key, value)
    }

    override fun balance(currentNode: AVLNode<K, V>?): AVLNode<K, V>? {
        if (currentNode == null) return null

        var bf = balanceFactor(currentNode)
        if (bf > 1) {
            if (balanceFactor(currentNode?.left) < 0) {
                currentNode.left = leftRotate(currentNode.left)
            }
            return rightRotate(currentNode)
        }
        if (bf < -1) {
            if (balanceFactor(currentNode.right) > 0) {

                currentNode.right = rightRotate(currentNode.right)
            }

            return leftRotate(currentNode)
        }
        fixHeight(currentNode)
        return currentNode
    }

    private fun balanceFactor(node: AVLNode<K, V>?): Int {
        return (node?.left?.height ?: 0) - (node?.right?.height ?: 0)
    }

    private fun fixHeight(currentNode: AVLNode<K, V>?) {
        currentNode?.height = 1 + maxOf((currentNode?.left?.height ?: 0), (currentNode?.right?.height ?: 0))
    }

    private fun rightRotate(node: AVLNode<K, V>?): AVLNode<K, V>? {
        val temp = node?.left
        node?.left = temp?.right
        temp?.right = node
        fixHeight(node)
        fixHeight(temp)
        return temp
    }

    private fun leftRotate(node: AVLNode<K, V>?): AVLNode<K, V>? {
        val temp = node?.right
        node?.right = temp?.left
        temp?.left = node
        fixHeight(node)
        fixHeight(temp)
        return temp
    }
    override fun toString() = diagram(root)
    private fun diagram(node: AVLNode<K, V>?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.left == null && node.right == null) {
                "$root${node.key}\n"
            } else {
                diagram(node.right, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.key}\n" + diagram(node.left,
                    "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }
    override fun iterator(): Iterator<Pair<K, V>> {
        TODO("Not yet implemented")
    }
}