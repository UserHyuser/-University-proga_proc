import java.io.FileNotFoundException
import java.io.FileReader
import java.io.FileWriter
import kotlin.system.exitProcess
import Container.*

fun main(args: Array<String>) { // Проверка на количество аргументов
    if (args.size != 2) {
        println("***\nIncorrect command line!\n" +
                "Waited: command in_file out_file\n***")
        exitProcess(1)
    }

    println("***\nStart\n***\n")

    val cont = Container()

    val fileIn: FileReader
    
    try {
        fileIn = FileReader(args[0]) // Проверка на корректность введенных данных

    }
    catch (e: FileNotFoundException) {
        println("File not exist!\n")
        return
    }

    In(fileIn, cont) // Заполение контейнеров
    fileIn.close()
    println("***\nFilled container\n***\n")

    val fileOut1 = FileWriter(args[1], false)
    Out(fileOut1, cont)
    fileOut1.close()

    println("***\nFilled file\n***\n")

    val fileOut3 = FileWriter(args[1], false)
    Sort(cont)
    Out(fileOut3, cont)
    fileOut3.close()
    println("***\nFilled file(sort)\n***\n")

    val fileOut4 = FileWriter(args[1], false)
    Filter(fileOut4, cont)
    fileOut4.close()
    println("***\nFilled file(filter)\n***\n")

    Clear(cont)
    println("***\nErased container\n***\n")

    val fileOut2 = FileWriter(args[1], false)
    Out(fileOut2, cont)
    fileOut2.close()
    println("***\nStop\n***\n")
}
