package trees.tree

import trees.interfaces.Tree
import trees.nodes.AVLnode

class AVLtree<K : Comparable<K>, V> : Tree<K, V, AVLnode<K, V>>() {
    override fun insert(key: K, value: V) {
        TODO("Not yet implemented")
    }

    override fun delete(key: K) {
        TODO("Not yet implemented")
    }
}