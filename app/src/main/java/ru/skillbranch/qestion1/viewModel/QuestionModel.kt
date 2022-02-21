package ru.skillbranch.qestion1.viewModel.qestionViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import ru.skillbranch.qestion1.R
import ru.skillbranch.qestion1.entities.entities



class questionModel(): ViewModel() {
    var index  = 0
    val data = listOf(
        entities(R.string.question_eys, R.drawable.eys, true),
        entities(R.string.question_foot, R.drawable.foot, false),
        entities(R.string.question_gey, R.drawable.gey, false),
        entities(R.string.question_list, R.drawable.list, false),
        entities(R.string.question_phone, R.drawable.phone, true),
        entities(R.string.question_biznes, R.drawable.biznes, true),
        entities(R.string.question_kosmos, R.drawable.kosmos, true),
        entities(R.string.question_live, R.drawable.live, true),
        entities(R.string.question_trueOrFalse, R.drawable.nikita, false),
        entities(R.string.question_mili, R.drawable.mili, false)
    )


    fun Data(): entities {
        return data[index]

    }
   fun moveData(){
       if(index<data.size-1){
           index++
       }else{
           index = 0
       }
   }

    fun answer() = if(index!=0)data[index-1].answer else data[index].answer
}



