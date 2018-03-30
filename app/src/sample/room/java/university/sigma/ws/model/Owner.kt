package java.university.sigma.ws.model

import com.google.gson.annotations.SerializedName

/**
 * Created by olehkozak on 10/25/17.
 */

class Owner {

    @SerializedName("user_id")
    var userId: Int? = null
    @SerializedName("display_name")
    var displayName: String? = null
}
