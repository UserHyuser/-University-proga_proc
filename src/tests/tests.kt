package tests

import OopLg.*
import ProcLg.*
import FuncLg.*
import InDataProg
import jdk.nashorn.internal.runtime.JSType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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
//        val progLg = InDataProg("0 ")
    }
}