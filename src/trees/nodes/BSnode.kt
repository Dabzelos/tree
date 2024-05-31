package trees.nodes

import trees.interfaces.Node

class BSNode<K : Comparable<K>, V>(k: K, v: V) : Node<K, V, BSNode<K, V>>(k, v) {}
