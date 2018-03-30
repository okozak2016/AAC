package university.sigma.ws.util


import university.sigma.ws.retrofit.RetrofitClient
import university.sigma.ws.retrofit.StackOverflowService

/**
 * Created by olehkozak on 10/25/17.
 */

object ApiUtils {

    val BASE_URL = "https://api.stackexchange.com/2.2/"

    val soService: StackOverflowService get() = RetrofitClient.getClient(BASE_URL)!!.create(StackOverflowService::class.java)
}
