import java.io.FileWriter

data class OopLg(var inh: Inheritance ? = null)

fun InDataOop(str: String): OopLg {
    val oopLg = OopLg(
        inh = when (str.split(' ')[2]) {
            "0" -> Inheritance.SINGLE
            "1" -> Inheritance.PLURAL
            "2" -> Inheritance.INTERFACE
            else -> null
        }
    )
    return oopLg

}

fun OutDataOop(oopLg: OopLg ?, fileOut: FileWriter) =
    fileOut.write("Inheritance: ${oopLg!!.inh}\n\n")