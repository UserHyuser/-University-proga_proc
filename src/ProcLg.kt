import java.io.FileWriter

data class ProcLg(var isAbstractDataType: Boolean ? = null)

fun InDataProc(str: String) : ProcLg {
    val procLg = ProcLg(
        isAbstractDataType = when (str.split(' ')[3]) {
            "0" -> false
            "1" -> true
            else -> null
        }
    )
    return procLg
}

fun OutDataProc(procLg: ProcLg ? , fileOut: FileWriter) = fileOut.write("Is abstract data type: ${procLg!!.isAbstractDataType}\n\n")