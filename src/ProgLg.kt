import java.io.FileWriter


data class ProgLg(var langType: LangType ? = null,
                  var creationYear: String ? = null,
                  var mentions: String? = null,
                  var procLg: ProcLg ? = null,
                  var oopLg: OopLg ? = null,
                  var funcLg: FuncLg? = null)

fun InDataProg(str: String): ProgLg {
    val progLg = ProgLg(
        langType = when (str.split(' ')[0]) {
            "0" -> LangType.PROCEDURE
            "1" -> LangType.OOP
            "2" -> LangType.FUNCTIONAL
            else -> null
        },
        creationYear = str.split(' ')[1],
        mentions = str.split(' ')[2]
    )

    when (str.split(' ')[0]) {
        "0" -> progLg.procLg = InDataProc(str)
        "1" -> progLg.oopLg = InDataOop(str)
        "2" -> progLg.funcLg = InDataFunc(str)
    }

    return progLg
}

fun OutDataProg(progLg: ProgLg, fileWriter: FileWriter) {
    fileWriter.write("Language type: ${progLg.langType}\n" +
            "Year creation: ${progLg.creationYear}\n" +
            "Quantity years from creation: ${NumberOfYears(progLg)}\n"
            "Mentions in Internet: ${progLg.mentions}\n"
    )
    when (progLg.langType) {
        LangType.PROCEDURE -> OutDataProc(procLg = progLg.procLg,
            fileOut = fileWriter)
        LangType.OOP -> OutDataOop(oopLg = progLg.oopLg,
            fileOut = fileWriter)
        LangType.FUNCTIONAL -> OutDataFunc(funcLg = progLg.funcLg,
            fileOut = fileWriter)
    }
}

fun NumberOfYears(progLg: ProgLg?): Int = 2018 - progLg!!.creationYear!!.toInt()