package studio.codable.bitriser.util.repository

interface IApplicationRepository {
    suspend fun getApps()
}