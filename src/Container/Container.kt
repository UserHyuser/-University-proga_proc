package Container

import java.io.FileReader
import java.io.FileWriter
import ProgLg.*

data class Container(var len: Int = 0, var pg: MutableList<ProgLg?> = mutableListOf())

fun In(fileIn: FileReader, cnt: Container) {
    for (line in fileIn.readLines()) {
        cnt.pg.add(InDataProg(line))
        cnt.len++
    }
}

fun Out(fileWriter: FileWriter, cnt: Container) {
    fileWriter.write("Elements:\n\n")
    for (item in cnt.pg) {
        OutDataProg(item, fileWriter)
    }
}

fun Filter(fileWriter: FileWriter, cnt: Container) {
    fileWriter.write("Elements:\n\n")
    for (item in cnt.pg) {
        if (item != null) {
            if(item.procLg != null) {
                OutDataProg(item, fileWriter)
            }
        }
    }
}

fun Clear(cnt: Container) {
    cnt.len = 0
    cnt.pg.clear()
}

fun Sort(cnt: Container) {
    for (i in 0 until cnt.len) {
        if (cnt.pg[i] == null) {
            cnt.pg.add(cnt.pg.removeAt(i))
            continue
        }
        else
            if (NumberOfYears(cnt.pg[i]) == null) {
                cnt.pg.add(cnt.pg.removeAt(i))
                continue
            }
    }

    for (i in 0 until cnt.len) {
        if (cnt.pg[i] == null)
            break
        else
            if (NumberOfYears(cnt.pg[i]) == null)
                break

        for (j in i until cnt.len) {
            if (cnt.pg[j] == null)
                break
            else
                if (NumberOfYears(cnt.pg[j]) == null)
                    break

            if (NumberOfYears(cnt.pg[i])!! > NumberOfYears(cnt.pg[j])!!) {
                val tmp = cnt.pg[i]
                cnt.pg[i] = cnt.pg[j]
                cnt.pg[j] = tmp
            }
        }
    }
}

fun Multimethod(container: Container, fileWriter: FileWriter) {
    for (item1 in container.pg) {
        for (item2 in container.pg) {
            when (item1?.langType) {
                LangType.OOP -> when (item2?.langType) {
                    LangType.OOP -> fileWriter.write("OOP and OOP\n")
                    LangType.PROCEDURE -> fileWriter.write("OOP and PROCEDURE\n")
                    LangType.FUNCTIONAL -> fileWriter.write("OOP and FUNCTIONAL\n")
                    else -> fileWriter.write("OOP and null\n")
                }
                LangType.PROCEDURE -> when (item2?.langType) {
                    LangType.OOP -> fileWriter.write("PROCEDURE and OOP\n")
                    LangType.PROCEDURE -> fileWriter.write("PROCEDURE and PROCEDURE\n")
                    LangType.FUNCTIONAL -> fileWriter.write("PROCEDURE and FUNCTIONAL\n")
                    else -> fileWriter.write("PROCEDURE and null\n")
                }
                LangType.FUNCTIONAL -> when (item2?.langType) {
                    LangType.OOP -> fileWriter.write("FUNCTIONAL and OOP\n")
                    LangType.PROCEDURE -> fileWriter.write("FUNCTIONAL and PROCEDURE\n")
                    LangType.FUNCTIONAL -> fileWriter.write("FUNCTIONAL and FUNCTIONAL\n")
                    else -> fileWriter.write("FUNCTIONAL and null\n")
                }
                else -> when (item2?.langType) {
                    LangType.OOP -> fileWriter.write("null and OOP\n")
                    LangType.PROCEDURE -> fileWriter.write("null and PROCEDUREOOP\n")
                    LangType.FUNCTIONAL -> fileWriter.write("null and FUNCTIONAL\n")
                    else -> fileWriter.write("null and null\n")
                }
            }
        }
    }
}