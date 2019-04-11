package OopLg

import java.io.FileWriter

data class OopLg(var inh: Inheritance? = null)

fun InDataOop(str: String): OopLg? {
    val oopLg = OopLg()

    return try {
        oopLg.inh = when (str.split(' ')[3]) {
            "0" -> Inheritance.SINGLE
            "1" -> Inheritance.PLURAL
            "2" -> Inheritance.INTERFACE
            else -> {
                println("Warn: OopLg.inh\n" +
                        "Wrong initial parametr \"inh\".\n\n")
                null
            }
        }
        oopLg
    }
    catch (e: IndexOutOfBoundsException) {
        println("Warn: OopLg.inh\n" +
                "Small quantity of initial parameters.\n\n")
        null
    }
}

fun OutDataOop(oopLg: OopLg ?, fileOut: FileWriter) {
    if (oopLg != null) {
        if (oopLg.inh != null) {
            fileOut.write("Inheritance: ${oopLg.inh}\n\n")
        }
        else {
            fileOut.write("Inheritance: -\n\n")
        }
    }
    else {
        fileOut.write("-\n\n")
    }
}