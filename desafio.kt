enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} foi matriculado na formação $nome.")
    }
}

fun main() {
   
    val kotlinBasico = ConteudoEducacional("Kotlin Básico", 90, Nivel.BASICO)
    val kotlinIntermediario = ConteudoEducacional("Kotlin Intermediário", 120, Nivel.INTERMEDIARIO)
    val kotlinAvancado = ConteudoEducacional("Kotlin Avançado", 180, Nivel.AVANCADO)
 
    val formacaoKotlin = Formacao("Formação Kotlin Developer", listOf(kotlinBasico, kotlinIntermediario, kotlinAvancado))

    val usuario1 = Usuario("Ana")
    val usuario2 = Usuario("Pedro")
    val usuario3 = Usuario("Mariana")

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)

    println("\n--- Resumo da Formação ---")
    println("Formação: ${formacaoKotlin.nome}")
    println("Conteúdos:")
    formacaoKotlin.conteudos.forEach { 
        println("- ${it.nome} (${it.duracao} min) | Nível: ${it.nivel}")
    }

    println("\nUsuários matriculados:")
    formacaoKotlin.inscritos.forEach { println("- ${it.nome}") }
}
