package studio.codable.bitriser.util.errorHandling

interface DisplayableError {
    val code: Int?
    val message: String?
    val causedBy: Throwable?

    fun extractStringToDisplay(): String?
}