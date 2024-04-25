package trees.interfaces



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
abstract class Tree<K : Comparable<K>, V, N : Node<K, V, N>> {
    /*
    * The root node of the tree
    */
    var root: N? = null

    //
    //
    //
    abstract fun insert(key: K, value: V)
    abstract fun delete(key: K)

    fun search(key: K): V? {
        return verticeSearch(key, root)?.value
    }

    private fun verticeSearch(key: K, treeroot: N?): N? {
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
}