package com.example.dawam.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dawam.R
import com.example.dawam.databinding.FragmentHomeBinding
import com.example.dawam.ui.Constants.WAQF_IMAGE_EXTRA
import com.example.dawam.ui.Constants.WAQF_NAME_EXTRA
import com.example.dawam.ui.home.recycler_view.Waqf
import com.example.dawam.ui.home.recycler_view.WaqfAdapter
import com.example.dawam.ui.waqf_details.WaqfDetailsActivity

class HomeFragment:Fragment() {
    lateinit var viewBinding :FragmentHomeBinding
    lateinit var adapter: WaqfAdapter
    var awqaf = listOf(
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,),
        Waqf("جامعة القاهرة","الأميرة فاطمة إسماعيل","خيري","جامعة","شعبان 1324 هجريًا","أكتوبر سنة 1906م","جامعة القاهرة هي ثاني أقدم الجامعات المصرية والثالثة عربياً بعد جامعة الأزهر وجامعة القرويين تأسست كلياتها المختلفة في عهد محمد علي، كالمهندسخانة (حوالي 1820) والمدرسة الطبية عام 1827، ثم ما لبثا أن أغلقت في عهد الخديوي محمد سعيد (حوالي 1850). بعد حملة مطالبة شعبية واسعة لإنشاء جامعة حديثة بقيادة مصطفى كامل وغيره. تأسست هذه الجامعة في 21 ديسمبر 1908، عرفت باسم جامعة فؤاد الأول ثم جامعة القاهرة بعد ثورة 23 يوليو 1952.","مصر- مدينة الجيزة غرب القاهرة", R.drawable.cairo_college,)
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
         viewBinding= FragmentHomeBinding.inflate(inflater,container, false )
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = WaqfAdapter(awqaf)
        adapter.onWaqfClick = object : WaqfAdapter.OnWaqfClick {
            override fun onWaqfBtnClick(name: String,  image:Int) {
                //We should start new activity ==> Waqf details
                val intent = Intent(requireActivity(), WaqfDetailsActivity::class.java)
                intent.putExtra(WAQF_NAME_EXTRA, name)
                intent.putExtra(WAQF_IMAGE_EXTRA, image)
                startActivity(intent)
            }
        }
        viewBinding.waqfRecycler.adapter=adapter
    }
}

