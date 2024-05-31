
package trees

import nodes.AVLNode
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import tree.AVLTree
import java.lang.reflect.Field
import kotlin.test.assertEquals
import kotlin.test.assertNull

class AVLTreeTest {
    private lateinit var tree: AVLTree<Int, String>

    private lateinit var f: Field

    @BeforeEach
    fun setup() {
        tree = AVLTree()
        f = AVLTree::class.java.superclass.getDeclaredField("root")
        f.trySetAccessible()
    }

    @Test
    fun `insertion in empty tree`() {
        tree.insert(1, "A")

        assertEquals(Pair(1, "A"), Pair(tree.root?.key, tree.root?.value))
    }

    @Test
    fun `insertion and search`() {
        tree.insert(1, "A")

        assertEquals("A", tree.search(1))
    }

    @Test
    fun `insertion and deletion`() {
        tree.insert(1, "A")
        tree.delete(1)

        assertNull(tree.root)
    }

    @Test
    fun `root deletion`() {
        tree.insert(1, "A") // root
        tree.insert(2, "B") // right child
        tree.delete(1)

        assertEquals(Pair(2, "B"), Pair(tree.root?.key, tree.root?.value))
    }

    @Test
    fun `insertion and height balance`() {
        tree.insert(1, "A")
        tree.insert(2, "B")
        tree.insert(3, "C")

        assertEquals(2, tree.root?.height)
    }

    @Test
    fun `tree balancing`() {
        tree.insert(4, "A")
        tree.insert(2, "B")
        tree.insert(6, "C")
        tree.insert(1, "D")
        tree.insert(3, "E")
        tree.insert(5, "F")
        tree.insert(7, "G")


        assertEquals(4, tree.root?.key)
        assertEquals(2, tree.root?.left?.key)
        assertEquals(1, tree.root?.left?.left?.key)
        assertEquals(3, tree.root?.left?.right?.key)
        assertEquals(6, tree.root?.right?.key)
        assertEquals(7, tree.root?.right?.right?.key)
        assertEquals(5, tree.root?.right?.left?.key)
    }

    @Test
    fun `insert duplicate key`() {
        tree.insert(1, "A")
        tree.insert(1, "B")

        assertEquals("B", tree.search(1))
    }

    @Test
    fun `left rotation`() {
        tree.insert(3, "A")
        tree.insert(1, "B")
        tree.insert(4, "C")
        tree.insert(5, "D")
        tree.insert(6, "E")


        assertEquals(5, tree.root?.right?.key)
        assertEquals(4, tree.root?.right?.left?.key)
        assertEquals(6, tree.root?.right?.right?.key)
    }

    @Test
    fun `right rotation`() {
        tree.insert(3, "A")
        tree.insert(1, "B")
        tree.insert(7, "C")
        tree.insert(5, "D")
        tree.insert(6, "E")


        assertEquals(6, tree.root?.right?.key)
        assertEquals(5, tree.root?.right?.left?.key)
        assertEquals(7, tree.root?.right?.right?.key)
    }

    @Test
    fun `delete node with 2 children`() {


        tree.insert(3, "A")
        tree.insert(1, "B")
        tree.insert(7, "C")
        tree.insert(5, "D")
        tree.insert(6, "E")

        tree.delete(6)

        println(tree)
        assertEquals(7, tree?.root?.right?.key)
        assertEquals(5, tree?.root?.right?.left?.key)
    }



    @Test
    fun `big left rotation`() {
        tree.insert(20, "A")
        tree.insert(10, "B")
        tree.insert(40, "C")
        tree.insert(30, "D")
        tree.insert(2, "E")
        tree.insert(50, "F")
        tree.insert(25, "G")

        tree.delete(2)
        println(tree.root?.height)
        println(tree.root?.left?.height)
        println(tree.root?.right?.height)

        assertEquals(30, tree.root?.key)
        assertEquals(40, tree.root?.right?.key)
        assertEquals(20, tree.root?.left?.key)
    }

}
