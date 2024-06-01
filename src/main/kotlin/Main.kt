import iterator.inorderTraversalRecursive
import tree.AVLTree

fun main() {

    val tree = AVLTree<Int, String>()
    tree.insert(3, "A")
    tree.insert(1, "B")
    tree.insert(7, "C")
    tree.insert(5, "D")
    tree.insert(6, "E")
    inorderTraversalRecursive(tree.root)
    /*println(tree.toString())
    tree.delete(6)
    println(tree.root?.right?.left?.key)

    println(tree.toString())*/

}
