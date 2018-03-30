package java.university.sigma.ws.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.university.sigma.ws.model.Item

/**
 * Created by olehkozak on 10/25/17.
 */

class AnswersAdapter(private var mItems: List<Item>, private val mItemListener: PostItemListener) : RecyclerView.Adapter<AnswersAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View, private var mItemListener: PostItemListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var titleTv: TextView = itemView.findViewById(android.R.id.text1)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val item = getItem(adapterPosition)
            this.mItemListener.onPostClick(item.answerId!!.toLong())

            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val postView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)

        return ViewHolder(postView, mItemListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mItems[position]
        val textView = holder.titleTv
        textView.text = item.owner?.displayName
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun updateAnswers(items: List<Item>) {
        mItems = items
        notifyDataSetChanged()
    }

    private fun getItem(adapterPosition: Int): Item {
        return mItems[adapterPosition]
    }

    interface PostItemListener {
        fun onPostClick(id: Long)
    }
}
