
package tree

import interfaces.Tree
import nodes.BSNode

class BSTree<K : Comparable<K>, V> : Tree<K, V, BSNode<K, V>>() {

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

    override fun iterator(): Iterator<Pair<K, V>> {
        TODO("Not yet implemented")
    }

}