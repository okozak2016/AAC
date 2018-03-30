package java.university.sigma.ws.model

import com.google.gson.annotations.SerializedName

/**
 * Created by olehkozak on 10/25/17.
 */
class Item {

    @SerializedName("owner")
    var owner: Owner? = null
    @SerializedName("answer_id")
    var answerId: Int? = null
}
