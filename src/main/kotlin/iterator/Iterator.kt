package iterator

import interfaces.Node

fun <K : Comparable<K>, V, N : Node<K, V, N>> inorderTraversalRecursive(root: N?) {
    if (root != null) {
        inorderTraversalRecursive(root.left)
        println("${root.value}")
        inorderTraversalRecursive(root.right)
    }
}