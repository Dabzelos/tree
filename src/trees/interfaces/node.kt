package trees.interfaces
/*

abstract class Node<K : Comparable<K>, V, N : Comparable<Node<K, V, N>>(var key: K, var value: V) {
    var left: N? = null
    var right: N? = null
}
*/

abstract class Node<K : Comparable<K>, V, N : Node<K, V, N>>(var key: K, var value: V) {
    var right: N? = null
    var left: N? = null
}