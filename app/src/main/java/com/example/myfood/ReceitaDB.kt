import com.example.myfood.Receita

object ReceitaDB {

    val dadosReceita = arrayListOf<Receita>()

    fun salvarReceita(receita: Receita) {
        dadosReceita.add(receita)
    }

    fun deletarReceita(receitaDeletada: Receita) {
        dadosReceita.remove(receitaDeletada)
    }

    fun alterarReceita(receita: Receita, receitaAtualizada: Receita) {
        deletarReceita(receita)
        salvarReceita(receitaAtualizada)
    }

}