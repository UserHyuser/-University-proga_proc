import java.io.FileReader
import java.io.FileWriter
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("***\nIncorrect command line!\nWaited: command in_file out_file\n***")
        exitProcess(1)
    }

    println("***\nStart\n***\n")

    val cont : Container = Container()

    val fileIn = FileReader(args[0])
    In(fileIn, cont)
    fileIn.close()
    println("***\nFilled container\n***\n")

    val fileOut1 = FileWriter(args[1], false)
    Out(fileOut1, cont)
    fileOut1.close()
    println("***\nFilled file\n***\n")

    val fileOut3 = FileWriter(args[1], false)
    Multimethod(cont, fileOut3)
    fileOut3.close()
    println("***\nMultimethod\n***\n")

    Clear(cont)
    println("***\nErased container\n***\n")

    val fileOut2 = FileWriter(args[1], false)
    Out(fileOut2, cont)
    fileOut2.close()
    println("***\nStop\n***\n")
}