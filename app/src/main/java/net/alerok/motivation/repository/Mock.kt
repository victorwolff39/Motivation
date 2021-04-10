package net.alerok.motivation.repository

import net.alerok.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase (val description: String, val category: Int)

class Mock {

    private val ALL = MotivationConstants.QUOTEFILTER.ALL
    private val HAPPY = MotivationConstants.QUOTEFILTER.HAPPY
    private val SAD = MotivationConstants.QUOTEFILTER.SAD

    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", HAPPY),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas!", HAPPY),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", HAPPY),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", HAPPY),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", HAPPY),
        Phrase("A luta é grande, mas a derrota é certa.", SAD),
        Phrase("Onde há vontade, há chance de dar errado.", SAD),
        Phrase("Continue sonhando, você acabará se atrasando.", SAD),
        Phrase("Não há nada tão ruim que não possa piorar.", SAD),
        Phrase("Não espere nada de ninguém, muito menos de você.", SAD),
        Phrase("A vida não é uma caixinha de surpresas, é um container de frustrações.", SAD),
        Phrase("Na hora certa, vai tudo dar errado.", SAD)
    )

    fun getPhrase(categoryId: Int) : String {

        val filteredList = mListPhrases.filter { (it.category == categoryId || categoryId == ALL) }
        val rand = Random.nextInt(filteredList.size)
        return filteredList[rand].description
    }

}