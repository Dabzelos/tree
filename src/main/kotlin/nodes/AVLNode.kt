package nodes

import interfaces.Node

class AVLNode<K : Comparable<K>, V>(key: K, value: V) : Node<K, V, AVLNode<K, V>>(key, value) {
    var height: Int = 1
}
