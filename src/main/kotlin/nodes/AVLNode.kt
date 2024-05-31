package nodes

import interfaces.Node

class AVLnode<K : Comparable<K>, V>(key: K, value: V) : Node<K, V, AVLnode<K, V>>(key, value) {
    var height: Int = 1
}
