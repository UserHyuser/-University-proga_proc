package tests

import OopLg.*
import ProcLg.*
import FuncLg.*
import ProgLg.*
import Container.*
import jdk.nashorn.internal.runtime.JSType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.FileReader
import java.io.FileWriter

class Tests {

    @Test
    fun ProcLgInData() {
        val str = "test test test "
        for (i in 0..20) {
            val tmp = str + "$i"
            val procLg = InDataProc(tmp)
            when(i) {
                0, 1 -> assertEquals(JSType.toBoolean(i),
                    procLg?.isAbstractDataType,
                        "Wrong \"isAbstractDataType\"")
                else -> assertEquals(null,
                        procLg!!.isAbstractDataType,
                        "Wrong \"isAbstractDataType\"")
            }
        }
    }

    @Test
    fun OopLgInData() {
        val str = "test test test "
        for (i in 0..20) {
            val tmp = str + "$i"
            val oopLg = InDataOop(tmp)
            when(i) {
                0 -> assertEquals(Inheritance.SINGLE,
                    oopLg!!.inh,
                    "Wrong \"inh\"")
                1 -> assertEquals(Inheritance.PLURAL,
                    oopLg!!.inh,
                    "Wrong \"inh\"")
                2 -> assertEquals(Inheritance.INTERFACE,
                    oopLg!!.inh,
                    "Wrong \"inh\"")
                else -> assertEquals(null,
                    oopLg!!.inh,
                    "Wrong \"inh\"")
            }
        }
    }

    @Test
    fun FuncLgInData() {
        val str = "test test test"
        for (i in 0..20) {
            for (j in 0..20) {
                val tmp = "$str $i $j"
                val funcLg = InDataFunc(tmp)
                when (i) {
                    0 -> assertEquals(
                        Typing.STRONG,
                        funcLg!!.typing,
                        "Wrong \"typing\""
                    )
                    1 -> assertEquals(
                        Typing.DYNAMIC,
                        funcLg!!.typing,
                        "Wrong \"typing\""
                    )
                    else -> assertEquals(
                        null,
                        funcLg!!.typing,
                        "Wrong \"typing\""
                    )
                }
                when (j) {
                    0, 1 -> assertEquals(
                        JSType.toBoolean(j),
                        funcLg.isLazyCalc,
                        "Wrong \"isLazyCalc $j\""
                    )
                    else -> assertEquals(
                        null,
                        funcLg.isLazyCalc,
                        "Wrong \"isLazyCalc\""
                    )
                }
            }
        }
    }

    @Test
    fun ProgLgInData() {
        for (i in 0..20) {
            val str = "$i"
            for (j in 0..20) {
                val tmpJ = "$str $j"
                for (g in 0..20) {
                    val tmpG = "$tmpJ $g"
                    val progLg = InDataProg(tmpG)

                    when (i) {
                        0 -> assertEquals(LangType.PROCEDURE,
                            progLg!!.langType,
                            "Wrong 'langType'")
                        1 -> assertEquals(LangType.OOP,
                            progLg!!.langType,
                            "Wrong 'langType'")
                        2 -> assertEquals(LangType.FUNCTIONAL,
                            progLg!!.langType,
                            "Wrong 'langType'")
                    }

                    if (JSType.isNumber(j))
                        assertEquals(j, progLg!!.creationYear, "Wrong 'creation year'")
                    else
                        assertEquals(null, progLg!!.creationYear, "Wrong 'creation year'")

                    if (JSType.isNumber(j))
                        assertEquals(g, progLg.mentions, "Wrong 'mentions'")
                    else
                        assertEquals(null, progLg.mentions, "Wrong 'mentions'")

                }
            }

        }
    }

    @Test
    fun ProgLgNumberOfYears() {
        for (i in 0..20) {
            val str = "0 $i 0"
            val progLg = InDataProg(str)
            assertEquals((2019 - i), NumberOfYears(progLg), "Wrong 'NumberOfYears'")
        }
    }

    @Test
    fun ContainerOut() {
        val container = Container()
        val fileIn = FileReader("in.txt")
        In(fileIn, container)
        val fileOut = FileWriter("src/tests/tmp.txt")
        Out(fileOut, container)
        fileIn.close()
        fileOut.close()

        val file1 = FileReader("src/tests/tmp.txt")
        val file2 = FileReader("src/tests/cont_out.txt")
        assertEquals(true, file1.readText() == file2.readText(), "Wrong 'Out'")
    }

    @Test
    fun ContainerFilter() {
        val container = Container()
        val fileIn = FileReader("in.txt")
        In(fileIn, container)
        val fileOut = FileWriter("src/tests/tmp.txt")
        Filter(fileOut, container)
        fileIn.close()
        fileOut.close()

        val file1 = FileReader("src/tests/tmp.txt")
        val file2 = FileReader("src/tests/cont_filt.txt")
        assertEquals(true, file1.readText() == file2.readText(), "Wrong 'Filter'")
    }

    @Test
    fun ContainerSort() {
        val container = Container()
        val fileIn = FileReader("in.txt")
        In(fileIn, container)
        val fileOut = FileWriter("src/tests/tmp.txt")
        Sort(container)
        Out(fileOut, container)
        fileIn.close()
        fileOut.close()

        val file1 = FileReader("src/tests/tmp.txt")
        val file2 = FileReader("src/tests/cont_sort.txt")
        assertEquals(true, file1.readText() == file2.readText(), "Wrong 'Sort'")
    }

}