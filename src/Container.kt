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


fun Sort(cnt: Container) {
    for (i in cnt.pg) {
        for (j in cnt.pg) {
            if (i.creationYear!!.toInt() > j.creationYear!!.toInt()) {
                val tmp = i
                cnt.pg[cnt.pg.indexOf(i)] = j
                cnt.pg[cnt.pg.indexOf(j)] = tmp
            }
        }
    }
}