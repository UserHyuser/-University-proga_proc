import java.io.FileWriter


data class ProgLg(var langType: LangType ? = null,
                  var creationYear: String ? = null,
                  var procLg: ProcLg ? = null,
                  var oopLg: OopLg ? = null)

fun InDataProg(str: String): ProgLg {
    val progLg = ProgLg(
        langType = when (str.split(' ')[0]) {
            "0" -> LangType.PROCEDURE
            "1" -> LangType.OOP
            else -> null
        },
        creationYear = str.split(' ')[1]
    )

    when (str.split(' ')[0]) {
        "0" -> progLg.procLg = InDataProc(str)
        "1" -> progLg.oopLg = InDataOop(str)
    }

    return progLg
}

fun OutDataProg(progLg: ProgLg, fileWriter: FileWriter) {
    fileWriter.write("Language type: ${progLg.langType}\n" +
            "Year creation: ${progLg.creationYear}\n"
    )
    when (progLg.langType) {
        LangType.PROCEDURE -> OutDataProc(procLg = progLg.procLg,
            fileOut = fileWriter)
        LangType.OOP -> OutDataOop(oopLg = progLg.oopLg,
            fileOut = fileWriter)
    }
}