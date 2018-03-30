package java.university.sigma.ws.model

import com.google.gson.annotations.SerializedName

/**
 * Created by olehkozak on 10/25/17.
 */

class StackOverflowItemsList {

    @SerializedName("items")
    var items: List<Item>? = null
    @SerializedName("has_more")
    var hasMore: Boolean? = null

}
