package trees.nodes

import trees.interfaces.Node

class AVLnode<K : Comparable<K>, V>(key: K, value: V) : Node<K, V, AVLnode<K, V>>(key, value) {
    var height: Int = 1
}
