## This package contains realization of two types of trees:
1) [AVLTree](https://en.wikipedia.org/wiki/AVL_tree)
2) [BSTree](https://en.wikipedia.org/wiki/Binary_search_tree)

# How to Launch
```./gradlew build```
# Creating trees:
```kotlin   
val AVLTree = AVLTree<Int, String>()
val BSTree = BSTree<Int, String>()
```

# Examples:
```kotlin
fun main() {

    val BSTree = BSTree<Int, String>()
    //Adding 4 nodes
    BSTree.insert(1, "A")
    BSTree.insert(2, "B")
    BSTree.insert(3, "C")
    BSTree.insert(4, "D")

    //Deleting node by its key
    BSTree.delete(4)

    //to update use same function as insert
    BSTree.insert(3, "Z")
}

```
Also if you want to iterate your tree and print out its values
```kotlin
val BSTree = BSTree<Int, String>()

BSTree.insert(1, "A")
BSTree.insert(2, "B")
BSTree.insert(3, "C")
BSTree.insert(4, "D")

inorderTraversalRecursive(BSTree.root)

```
This will print "ABCD" in console

Moreover trees have its own parameters such as height in AVLTree
```kotlin
    val h = AVLTree.root.height
```
Or you can get access to nodes directly:
```kotlin
val BSTree = BSTree<Int, String>()
BSTree.insert(1, "A")
BSTree.insert(2, "B")
BSTree.insert(3, "C")
BSTree.insert(4, "D")
println(BSTree?.root.value)// -> A
println(BSTree?.root?.right.value) // -> B
println(BSTree?.root?.right?.right.value) // -> C

```