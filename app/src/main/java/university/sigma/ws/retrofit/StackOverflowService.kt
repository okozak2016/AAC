package university.sigma.ws.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.university.sigma.ws.model.StackOverflowItemsList

/**
 * Created by olehkozak on 10/25/17.
 */

interface StackOverflowService {

    @get:GET("/answers?order=desc&sort=votes&site=stackoverflow")
    val answers: Call<StackOverflowItemsList>

    @GET("/answers?order=desc&sort=votes&site=stackoverflow")
    fun getAnswers(@Query("tagged") tags: String): Call<StackOverflowItemsList>

}
