package FuncLg

import java.io.FileWriter
import java.lang.IndexOutOfBoundsException

data class FuncLg(var typing: Typing? = null, var isLazyCalc: Boolean? = null)

fun InDataFunc(str: String): FuncLg? {

    val funcLg = FuncLg()

    funcLg.typing = try {
        when (str.split(' ')[3]) {
            "0" -> Typing.STRONG
            "1" -> Typing.DYNAMIC
            else -> {
                println("Warn: FuncLg.typing\n" +
                        "Wrong initial parameter \"typing\".\n\n")
                null
            }
        }
    }
    catch (e: IndexOutOfBoundsException) {
        println("Warn: FuncLg.typing\n" +
                "Small quantity of initial parameters.\n\n")
        return null
    }

    funcLg.isLazyCalc = try {
        when (str.split(' ')[4]) {
            "0" -> false
            "1" -> true
            else -> {
                println("Warn: FuncLg.isLazyCalc\n" +
                        "Wrong initial parameter \"isLazyCalc\".\n\n")
                null
            }
        }
    }
    catch (e: IndexOutOfBoundsException) {
        println("Warn: FuncLg.isLazyCalc\n" +
                "Small quantity of initial parameters.\n\n")
        return null
    }
    return funcLg
}

fun OutDataFunc(funcLg: FuncLg ? , fileOut: FileWriter) {
    if (funcLg != null) {
        if (funcLg.typing != null) {
            fileOut.write("Typing: ${funcLg.typing}\n")
        } else {
            fileOut.write("Typing: -\n")
        }

        if (funcLg.isLazyCalc != null) {
            fileOut.write("Is lazy  calc: ${funcLg.isLazyCalc}\n\n")
        }
        else {
            fileOut.write("Is lazy  calc: -\n")
        }
    }

    else {
        fileOut.write("-\n\n")
    }
}