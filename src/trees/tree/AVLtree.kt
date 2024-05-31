package trees.tree

import trees.interfaces.Tree
import trees.nodes.AVLnode

class AVLtree<K : Comparable<K>, V> : Tree<K, V, AVLnode<K, V>>() {
    override fun insert(key: K, value: V) {
        root = insertVertice(key, value, root)
    }

    override fun delete(key: K) {
        root = deleteVertice(key, root)
    }

    override fun createNode(key: K, value: V): AVLnode<K, V> {
        return AVLnode(key, value)
    }

    override fun balance(currentNode: AVLnode<K, V>?): AVLnode<K, V>? {
        if (currentNode == null) return null

        var bf = balanceFactor(currentNode)
        if (bf > 1) {
            if (balanceFactor(currentNode?.left) < 0) {
                currentNode.left = leftRotate(currentNode.left)
            }
            return rightRotate(currentNode)
        } else if (bf < -1) {
            if (balanceFactor(currentNode.right) > 0) {

                currentNode.right = rightRotate(currentNode.right)
            }

            return leftRotate(currentNode)
        }
        fixHeight(currentNode)
        return currentNode
    }

    private fun balanceFactor(node: AVLnode<K, V>?): Int {
        return (node?.left?.height ?: 0) - (node?.right?.height ?: 0)
    }

    private fun fixHeight(currentNode: AVLnode<K, V>?) {
        currentNode?.height = 1 + maxOf((currentNode?.left?.height ?: 0), (currentNode?.right?.height ?: 0))
    }

    private fun rightRotate(node: AVLnode<K, V>?): AVLnode<K, V>? {
        val temp = node?.left
        node?.left = temp?.right
        temp?.right = node
        fixHeight(node)
        fixHeight(temp)
        return temp
    }

    private fun leftRotate(node: AVLnode<K, V>?): AVLnode<K, V>? {
        val temp = node?.right
        node?.right = temp?.left
        temp?.left = node
        fixHeight(node)
        fixHeight(temp)
        return temp
    }
}