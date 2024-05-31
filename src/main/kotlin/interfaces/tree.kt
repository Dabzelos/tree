package interfaces

import interfaces.Node


/**
 * An abstract class of tree
 * This class contains the declaration of all the main functions of working with trees
 *
 * @generic <K> the type of key stored in the tree. It must be comparable
 * @generic <V> the type of value stored in the tree
 * @generic <N> the type of node used in tree
 *
 *
 */
abstract class Tree<K : Comparable<K>, V, N : Node<K, V, N>> : Iterable<Pair<K, V>> {
    /*
    * The root node of the tree
    */
    var root: N? = null

    abstract fun insert(key: K, value: V)
    abstract fun delete(key: K)
    abstract fun createNode(key: K, value: V): N
    abstract fun balance(currentNode: N?): N?

    fun search(key: K): V? {
        return verticeSearch(key, root)?.value
    }

    protected fun insertVertice(key: K, value: V, currentNode: N?): N? {
        if (currentNode == null) {
            return createNode(key, value)
        }
        if (currentNode.key == key) {
            currentNode.value = value
        }
        if (currentNode.key < key) {
            currentNode.right = insertVertice(key, value, currentNode.right)
        }

        if (currentNode.key > key) {
            currentNode.left = insertVertice(key, value, currentNode.left)
        }
        return balance(currentNode)
    }

    protected fun verticeSearch(key: K, treeroot: N?): N? {
        if (treeroot == null) {
            return null
        } else if (key < treeroot.key) {
            return verticeSearch(key, treeroot.left)
        } else if (key > treeroot.key) {
            return verticeSearch(key, treeroot.right)
        } else {
            return treeroot
        }
    }

    protected fun findMinKey(node: N?): N {
        return if (node?.left == null) {
            node!!
        } else {
            findMinKey(node.left)
        }
    }

    protected fun deleteVertice(key: K, currentNode: N?): N? {
        if (currentNode == null) {
            return null
        }
        if (currentNode.key < key) {
            currentNode.right = deleteVertice(key, currentNode.right)
            return balance(currentNode)}
        else if (currentNode.key > key) {
            currentNode.left = deleteVertice(key, currentNode.left)
            return balance(currentNode)}
        else{
            if (currentNode.right == null) {
                return balance(currentNode.left)
            }
            else if (currentNode.left == null) {
                return balance(currentNode.right)
            }
            else {
                var nodeMinKey: N = findMinKey(currentNode.right)
                var minkey = nodeMinKey.key
                var minvalue = nodeMinKey.value
                currentNode.key = minkey
                currentNode.value = minvalue
                currentNode.right = deleteVertice(minkey, currentNode.right)
            }
        }
        return balance(currentNode)
    }

}