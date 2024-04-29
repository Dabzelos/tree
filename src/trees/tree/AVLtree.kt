package trees.tree

import trees.interfaces.Tree
import trees.nodes.AVLnode

class AVLtree<K : Comparable<K>, V> : Tree<K, V, AVLnode<K, V>>() {
    override fun insert(key: K, value: V) {
        root = insertVertice(key, value, root)
    }

    override fun delete(key: K) {
        TODO("Not yet implemented")
    }

    override fun createNode(key: K, value: V): AVLnode<K, V> {
        return AVLnode(key, value)
    }

    override fun balance(currentNode: AVLnode<K, V>?): AVLnode<K, V>? {
        if (balanceFactor(currentNode)) {
        }
    }

    private fun balanceFactor(currentNode: AVLnode<K, V>?): Int? {
        return currentNode?.left?.height!! - currentNode?.right?.height!!
    }

    private fun fixBalance(currentNode: AVLnode<K, V>?): AVLnode<K, V>? {
        TODO("Not yet implemented")
    }

    private fun rightRotate(currentNode: AVLnode<K, V>?): AVLnode<K, V>? {
        TODO()
    }

    private fun legtRotate(currentNode: AVLnode<K, V>?): AVLnode<K, V>? {
        TODO()
    }
}