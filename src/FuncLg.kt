import java.io.FileWriter

data class FuncLg(var typing: Typing? = null, var isLazyCalc: Boolean? = null)

fun InDataFunc(str: String): FuncLg? {
    return FuncLg(
        typing = when (str.split(' ')[2]) {
            "0" -> Typing.STRONG
            "1" -> Typing.DYNAMIC
            else -> null
        },
        isLazyCalc = when(str.split(' ')[3]) {
            "0" -> false
            "1" -> true
            else -> null
        }
    )
}

fun OutDataFunc(funcLg: FuncLg? , fileOut: FileWriter) = fileOut.write("Typing: ${funcLg!!.typing}\nIs lazy  calc: ${funcLg!!.isLazyCalc}\n\n")