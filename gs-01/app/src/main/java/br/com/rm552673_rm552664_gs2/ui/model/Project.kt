package br.com.rm552673_rm552664_gs2.ui.model

data class Project(
    val id: Int,
    val name: String,
    val description: String,
    val points: Int,
    val categoryId: Int,
    val imgRes: Int
)