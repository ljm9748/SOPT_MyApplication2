package com.example.sopt_2ndseminar2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    lateinit var instaAdapter: InstaAdapter

    val datas = mutableListOf<InstaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter= InstaAdapter(view.context)
        rv_home.adapter = instaAdapter //리사이클러 뷰의 어뎁터를 instaAdapter로 지정해줌
        rv_home.addItemDecoration(InstaItemDecoration(10))
        loadDatas() //데이터 임의생성하고 어뎁터에 전달하기
    }
    private fun loadDatas(){
        datas.apply{
            add(
                InstaData(
                    username = "이정민",
                    img_profile = "https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile7.uf.tistory.com%2Fimage%2F24283C3858F778CA2EFABE",
                    img_contents = "https://blog.jinbo.net/attach/615/200937431.jpg"
                ) )
            add(
                InstaData(
                    username = "SOPT",
                    img_profile = "https://taegon.kim/wp-content/uploads/2018/05/image-5.png",
                    img_contents = "https://i.pinimg.com/originals/05/1f/f3/051ff3fb781ff83c9b0f8a32f9922fa6.png"
                ) )
            add(
                InstaData(
                    username = "안드로이드 과제",
                    img_profile = "https://previews.123rf.com/images/mathayward/mathayward1106/mathayward110600005/9919836-%EA%B3%A8%EB%93%A0-%EB%A6%AC%ED%8A%B8%EB%A6%AC%EB%B2%84-%EA%B0%95%EC%95%84%EC%A7%80.jpg",
                    img_contents = "https://img.extmovie.com/files/attach/images/135/324/486/051/a46122d6a3bb33bc0153811bfaf3975d.jpg"
                ) )
        }
        instaAdapter.datas=datas
        instaAdapter.notifyDataSetChanged()
    }


}

