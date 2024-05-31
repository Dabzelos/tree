import tree.AVLtree

fun main() {
    println("hello")
    val tree = AVLtree<Int, Int>()
    tree.insert(1, 100)
    tree.insert(2, 200)
    println(tree)
}
