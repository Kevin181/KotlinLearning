package net.println.kt08

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * @Author: Kevin
 * @Description:
 * @Date: Created in 22:51 2017/12/3
 * @Modified By:
 */
interface GitHubService {

    @GET("/repos/enbandari/Kotlin-Tutorials/stargazers")
    fun getStarGazers():Call<List<User>>
}

object Service {
    val gitHubService: GitHubService by lazy {
        Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubService::class.java)
    }
}

fun main(args: Array<String>) {
   val data = Service.gitHubService
            .getStarGazers()
            .execute()
            .body()
//            .map{ println(it)}
    println(data)
}