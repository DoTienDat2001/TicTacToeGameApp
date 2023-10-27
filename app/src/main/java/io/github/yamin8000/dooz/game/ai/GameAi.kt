package io.github.yamin8000.dooz.game.ai

import io.github.yamin8000.dooz.model.AiDifficulty
import io.github.yamin8000.dooz.model.DoozCell

abstract class GameAi {

    abstract var difficulty: AiDifficulty

    abstract var gameCells: List<List<DoozCell>>

    abstract fun play(): DoozCell
}
