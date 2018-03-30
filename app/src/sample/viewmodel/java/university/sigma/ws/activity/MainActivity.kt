package java.university.sigma.ws.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import university.sigma.ws.R
import university.sigma.ws.util.ApiUtils
import java.university.sigma.ws.ui.AnswersAdapter
import java.university.sigma.ws.model.StackOverflowItemsList

class MainActivity : AppCompatActivity() {

    lateinit var adapter: AnswersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = AnswersAdapter(listOf(), object : AnswersAdapter.PostItemListener {
            override fun onPostClick(id: Long) {
                toast("ViewModel Sample: Post id = [$id]")
            }
        })

        initUI()
        loadItems()
    }

    private fun initUI() {
        rv_answers.layoutManager = LinearLayoutManager(baseContext)
        rv_answers.adapter = adapter
        rv_answers.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun loadItems() {
        ApiUtils.soService.answers.enqueue(object : Callback<StackOverflowItemsList> {
            override fun onResponse(call: Call<StackOverflowItemsList>, response: Response<StackOverflowItemsList>) {

                if (response.isSuccessful) {
                    val items = response.body()!!.items!!
                    adapter.updateAnswers(items)
                } else {
                    toast("Can not get items, error = [${response.code()}]")
                }
            }

            override fun onFailure(call: Call<StackOverflowItemsList>, t: Throwable) {
                //do nothing
            }
        })
    }
}
