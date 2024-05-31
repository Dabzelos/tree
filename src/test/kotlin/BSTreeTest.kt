package trees


import nodes.AVLNode
import nodes.BSNode
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import tree.BSTree
import kotlin.test.assertEquals


class BSTreeTest {
    private lateinit var tree: BSTree<Int, String>

    @BeforeEach
    fun setup() {
        tree = BSTree()
    }

    @Test
    fun `value should be added to empty tree`() {
        val expectedResult = "A"
        val key = 1
        tree.insert(key, "A")
        assertEquals(tree.root?.value, expectedResult)
    }

    @Test
    fun `root not null after adding element to empty tree`() {
        val expectedResult = "A"
        val key = 1

        tree.insert(key, expectedResult)

        assert(tree.root != null)
    }

    @Test
    fun `correct left-left order`() {
        val firstKey = -1
        val secondKey = 0
        val thirdKey = 1

        tree.insert(thirdKey, thirdKey.toString())
        tree.insert(secondKey, secondKey.toString())
        tree.insert(firstKey, firstKey.toString())

        assert(
            tree.root?.key == thirdKey &&
                    tree.root?.left?.key == secondKey &&
                    tree.root?.left?.left?.key == firstKey,
        )
    }

    @Test
    fun `correct left-right order`() {
        val firstKey = -1
        val secondKey = 0
        val thirdKey = 1

        tree.insert(thirdKey, thirdKey.toString())
        tree.insert(firstKey, firstKey.toString())
        tree.insert(secondKey, secondKey.toString())

        assert(
            tree.root?.key == thirdKey &&
                    tree.root?.left?.key == firstKey &&
                    tree.root?.left?.right?.key == secondKey,
        )
    }

    @Test
    fun `correct right-left order`() {
        val firstKey = -1
        val secondKey = 0
        val thirdKey = 1

        tree.insert(firstKey, firstKey.toString())
        tree.insert(thirdKey, thirdKey.toString())
        tree.insert(secondKey, secondKey.toString())

        assert(
            tree.root?.key == firstKey &&
                    tree.root?.right?.key == thirdKey &&
                    tree.root?.right?.left?.key == secondKey,
        )
    }

    @Test
    fun `balance should return itself`() {
        val firstKey = 1
        val secondKey = 2
        val thirdKey = 3
        val forthkey = 4

        tree.insert(firstKey, "A")
        tree.insert(secondKey, "B")
        tree.insert(thirdKey, "C")
        tree.insert(forthkey, "D")
        tree.balance(tree.root)
        assertEquals(tree.balance(tree.root)?.value, tree.root?.value)
        assertEquals(tree.balance(tree.root)?.value, "A")
    }

}