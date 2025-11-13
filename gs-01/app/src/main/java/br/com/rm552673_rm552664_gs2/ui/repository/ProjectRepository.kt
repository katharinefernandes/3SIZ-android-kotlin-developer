package br.com.rm552673_rm552664_gs2.ui.repository

import br.com.rm552673_rm552664_gs2.R
import br.com.rm552673_rm552664_gs2.ui.model.Category
import br.com.rm552673_rm552664_gs2.ui.model.Project

val projects = listOf(
    Project(
        id = 1,
        name = "Desafio Pomodoro",
        description = "Aumente sua produtividade com ciclos de foco de 25 minutos.",
        points = 100,
        categoryId = 1,
        imgRes = R.drawable.ic_pomodoro
    ),
    Project(
        id = 2,
        name = "Equipe Engajada",
        description = "Crie uma atividade de integração online com sua equipe.",
        points = 150,
        categoryId = 2,
        imgRes = R.drawable.ic_engajamento
    ),
    Project(
        id = 3,
        name = "Pausa Ativa",
        description = "Realize uma pausa ativa de 10 minutos durante o expediente.",
        points = 80,
        categoryId = 3,
        imgRes = R.drawable.ic_pausa
    ),
    Project(
        id = 4,
        name = "Ideia Inovadora",
        description = "Envie uma ideia que possa melhorar um processo do time .",
        points = 200,
        categoryId = 4,
        imgRes = R.drawable.ic_ideia
    ),
    Project(
        id = 5,
        name = "Consciência Verde",
        description = "Implemente uma ação sustentável no ambiente de trabalho.",
        points = 120,
        categoryId = 5,
        imgRes = R.drawable.ic_verde,
    ),
)


fun getAllProjects(): List<Project> {
    return projects
}

fun getProjectByCategory(category: Category): List<Project> {
    return projects.filter {
        it.categoryId.equals(category.id)
    }
}

fun getProjetByName(title: String): List<Project> {
    return getAllProjects().filter {
        it.name.startsWith(prefix = title, ignoreCase = true)
    }
}