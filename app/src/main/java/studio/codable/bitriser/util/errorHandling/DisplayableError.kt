package studio.codable.bitriser.util.errorHandling

interface DisplayableError {
    val code: Int?
    val message: String?
    val causedBy: Throwable?

    fun extractStringToDisplay(): String?
}

class EmptyDisplayableError(override val message: String?) : DisplayableError {
    override val causedBy: Throwable? = null
    override val code: Int? = null
    override fun extractStringToDisplay(): String? = message
}