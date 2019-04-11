import java.io.FileReader
import java.io.FileWriter

data class Container(var len: Int = 0, var pg: MutableList<ProgLg> = mutableListOf())

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

fun Clear(cnt: Container) {
    cnt.len = 0
    cnt.pg.clear()
}

fun Multimethod(container: Container, fileWriter: FileWriter) {
    for (item1 in container.pg) {
        for (item2 in container.pg) {
            when (item1.langType) {
                LangType.OOP -> when (item2.langType) {
                    LangType.OOP -> fileWriter.write("OOP and OOP\n")
                    LangType.PROCEDURE -> fileWriter.write("OOP and PROCEDURE\n")
                    else -> fileWriter.write("OOP and null\n")
                }
                LangType.PROCEDURE -> when (item2.langType) {
                    LangType.OOP -> fileWriter.write("PROCEDURE and OOP\n")
                    LangType.PROCEDURE -> fileWriter.write("PROCEDURE and PROCEDURE\n")
                    else -> fileWriter.write("PROCEDURE and null\n")
                }
                else -> when (item2.langType) {
                    LangType.OOP -> fileWriter.write("null and OOP\n")
                    LangType.PROCEDURE -> fileWriter.write("null and PROCEDUREOOP\n")
                    else -> fileWriter.write("null and null\n")
                }
            }
        }
    }
}