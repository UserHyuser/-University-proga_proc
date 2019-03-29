package ProcLg

import java.io.FileWriter

data class ProcLg(var isAbstractDataType: Boolean ? = null)

fun InDataProc(str: String) : ProcLg ? {
    val procLg = ProcLg()

    return try {
        procLg.isAbstractDataType = when (str.split(' ')[3]) {
            "0" -> false
            "1" -> true
            else -> {
                println("Warn: ProcLg.isAbstractDataType\nWrong initial parameter \"isAbstractDataType\".\n\n")
                null
            }
        }
        procLg
    }
    catch (e: IndexOutOfBoundsException) {
        println("Warn: ProcLg.isAbstractDataType\nSmall quantity of initial parameters.\n\n")
        null
    }
}

fun OutDataProc(procLg: ProcLg ? , fileOut: FileWriter) {
    if (procLg != null) {
        if (procLg.isAbstractDataType != null) {
            fileOut.write("Is abstract data type: ${procLg.isAbstractDataType}\n\n")
        }
        else {
            fileOut.write("Is abstract data type: -\n\n")
        }
    }
    else {
        fileOut.write("-\n\n")
    }
}



//fileOut.write("Is abstract data type: ${procLg!!.isAbstractDataType}\n\n")