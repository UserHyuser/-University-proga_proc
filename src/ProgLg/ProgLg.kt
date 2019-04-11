package ProgLg

import ProcLg.*
import OopLg.*
import FuncLg.*
import java.io.FileWriter

data class ProgLg(var langType: LangType ? = null,
                  var creationYear: Int ? = null,
                  var mentions: Int? = null,
                  var procLg: ProcLg? = null,
                  var oopLg: OopLg ? = null,
                  var funcLg: FuncLg? = null)

fun InDataProg(str: String): ProgLg? {
    val progLg = ProgLg()
    progLg.langType = try {
        when (str.split(' ')[0]) {
            "0" -> {
                progLg.procLg = InDataProc(str)
                LangType.PROCEDURE
            }
            "1" -> {
                progLg.oopLg = InDataOop(str)
                LangType.OOP
            }
            "2" -> {
                progLg.funcLg = InDataFunc(str)
                LangType.FUNCTIONAL
            }
            else -> {
                println("Warn: ProgLg.langType\n" +
                        "Wrong initial parameter \"langType\".\n\n")
                null
            }
        }
    }
    catch (e: IndexOutOfBoundsException) {
        println("Warn: ProgLg.langType\n" +
                "Small quantity of initial parameters.\n\n")
        return null
    }

    progLg.creationYear = try {
        str.split(' ')[1].toInt()
    }
    catch (e: IndexOutOfBoundsException) {
        println("Warn: ProgLg.creationYear\n" +
                "Small quantity of initial parameters.\n\n")
        return null
    }
    catch (e: NumberFormatException) {
        println("Warn: ProgLg.creationYear\n" +
                "Wrong initial parameter \"creationYear\" (Can't convert String to Int).\n\n")
        return null
    }

    progLg.mentions = try {
        str.split(' ')[2].toInt()
    }
    catch (e: IndexOutOfBoundsException) {
        println("Warn: ProgLg.mentions\n" +
                "Small quantity of initial parameters.\n\n")
        return null
    }
    catch (e: NumberFormatException) {
        println("Warn: ProgLg.mentions\n" +
                "Wrong initial parameter \"mentions\" (Can't convert String to Int).\n\n")
        return null
    }

    return progLg
}

fun OutDataProg(progLg: ProgLg?, fileWriter: FileWriter) {
    if (progLg != null) {
        if (progLg.langType != null) {
            fileWriter.write("Language type: ${progLg.langType}\n")
        }
        else {
            fileWriter.write("Language type: -\n")
        }

        if (progLg.creationYear != null) {
            fileWriter.write("Year creation: ${progLg.creationYear}\n")
        }
        else {
            fileWriter.write("Year creation: -\n")
        }

        if (NumberOfYears(progLg) != null) {
            fileWriter.write("Quantity years from creation: ${NumberOfYears(progLg)}\n")
        }
        else {
            fileWriter.write("Quantity years from creation: -\n")
        }

        if (progLg.mentions != null) {
            fileWriter.write("Mentions in Internet: ${progLg.mentions}\n")
        }
        else {
            fileWriter.write("Mentions in Internet: -\n")
        }

        if (progLg.langType != null) {
            when (progLg.langType) {
                LangType.PROCEDURE -> OutDataProc(procLg = progLg.procLg,
                    fileOut = fileWriter)
                LangType.OOP -> OutDataOop(oopLg = progLg.oopLg,
                    fileOut = fileWriter)
                LangType.FUNCTIONAL -> OutDataFunc(funcLg = progLg.funcLg,
                    fileOut = fileWriter)
            }
        }
        fileWriter.write("\n")

    }
    else {
        fileWriter.write("-\n\n")
    }
}

fun NumberOfYears(progLg: ProgLg?): Int? {
    return if (progLg != null) {
        if (progLg.creationYear != null) {
            (2019 - progLg.creationYear!!)
        } else {
            null
        }
    }
    else {
        null
    }
}