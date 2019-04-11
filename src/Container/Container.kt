package Container

import java.io.FileReader
import java.io.FileWriter
import ProgLg.*

data class Container(var len: Int = 0, var pg: MutableList<ProgLg?> = mutableListOf())
// Функции, используемые в программе
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
