package trees.tree

import trees.interfaces.Node
import trees.interfaces.Tree
import trees.nodes.BSNode

class BStree<K : Comparable<K>, V> : Tree<K, V, BSNode<K, V>>() {

    override fun insert(key: K, value: V) {
        root = insertVertice(key, value, root)
    }

    override fun delete(key: K) {
        root = deleteVertice(key, root)
    }

    private fun insertVertice(key: K, value: V, currentNode: BSNode<K, V>?): BSNode<K, V> {
        if (currentNode == null) {
            return BSNode(key, value)
        }
        if (currentNode.key == key) {
            currentNode.value = value
        }
        if (currentNode.key < key) {
            currentNode.right = insertVertice(key, value, currentNode.right)
        }

        if (currentNode.key > key) {
            currentNode.left = insertVertice(key, value, currentNode.left)
        }
        return currentNode
    }

    private fun deleteVertice(key: K, currentNode: BSNode<K, V>?): BSNode<K, V>? {
        if (currentNode == null) {
            return null
        } else if (currentNode.key == key) {
            if (currentNode.right == null && currentNode.left == null) {
                return null
            } else if (currentNode.right == null) {
                return currentNode.left
            } else if (currentNode.left == null) {
                return currentNode.right
            } else {
                var nodeMinKey: BSNode<K, V> = findMinKey(currentNode.right)
                var minkey = nodeMinKey.key
                var minvalue = nodeMinKey.value
                currentNode.key = minkey
                currentNode.value = minvalue
                currentNode.right = deleteVertice(minkey, currentNode.right)
            }


        } else if (currentNode.key < key) {
            currentNode.right = deleteVertice(key, currentNode.left)
            return currentNode
        }

        currentNode.left = deleteVertice(key, currentNode.left)
        return currentNode
    }

    private fun findMinKey(node: BSNode<K, V>?): BSNode<K, V> {
        return if (node?.left == null) {
            node!!
        } else {
            findMinKey(node.left)
        }
    }

}