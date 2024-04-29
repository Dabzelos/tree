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


    override fun createNode(key: K, value: V): BSNode<K, V> {
        return BSNode(key, value)
    }

    override fun balance(currentNode: BSNode<K, V>?): BSNode<K, V>? {
        return currentNode
    }

}