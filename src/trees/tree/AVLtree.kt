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
        if (balanceFactor(currentNode) = 1) {

        }
    }

    private fun balanceFactor(node: AVLnode<K, V>?): Int {
        return (node?.left?.height ?: 0) - (node?.right?.height ?: 0)
    }

    private fun fixHeight(currentNode: AVLnode<K, V>?) {
        currentNode?.height = 1 + maxOf((currentNode?.left?.height ?: 0), (currentNode?.right?.height ?: 0))
    }

    private fun rightRotate(currentNode: AVLnode<K, V>?): AVLnode<K, V>? {
        TODO()
    }

    private fun legtRotate(currentNode: AVLnode<K, V>?): AVLnode<K, V>? {
        TODO()
    }
}