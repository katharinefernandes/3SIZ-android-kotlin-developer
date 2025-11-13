package br.com.rm552673_rm552664_gs2.ui.repository

import br.com.rm552673_rm552664_gs2.R
import br.com.rm552673_rm552664_gs2.ui.model.Category

val categories = listOf(
    Category(1, "Produtividade", R.drawable.ic_produtividade),
    Category(2, "Colaboração", R.drawable.ic_colaboracao),
    Category(3, "Bem-Estar", R.drawable.ic_bemestar),
    Category(4, "Inovação", R.drawable.ic_inovacao),
    Category(5, "Sustentabilidade", R.drawable.ic_sustentabilidade),
)

fun getAllCategories(): List<Category> {
    return categories
}