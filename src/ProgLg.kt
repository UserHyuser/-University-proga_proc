import java.io.FileWriter


data class ProgLg(var langType: LangType ? = null,
                  var creationYear: String ? = null,
                  var procLg: ProcLg ? = null,
                  var oopLg: OopLg ? = null)

fun InDataProg(str: String): ProgLg {
    val progLg = ProgLg(
        langType = when (str.split(' ')[0]) {
            "1" -> LangType.PROCEDURE
            "2" -> LangType.OOP
            else -> null
        },
        creationYear = str.split(' ')[2]
    )

    when (str.split(' ')[0]) {
        "1" -> progLg.procLg = InDataProc(str)
        "2" -> progLg.oopLg = InDataOop(str)
    }

    return progLg
}

fun OutDataProg(progLg: ProgLg, fileWriter: FileWriter) {
    fileWriter.write("${progLg.langType}\t" +
            "Year creation: ${progLg.creationYear}\t"
    )
    when (progLg.langType) {
        LangType.PROCEDURE -> OutDataProc(procLg = progLg.procLg,
            fileOut = fileWriter)
        LangType.OOP -> OutDataOop(oopLg = progLg.oopLg,
            fileOut = fileWriter)
    }
}