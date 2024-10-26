import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.fragment.app.Fragment
import com.m1ctopt1.agedatabase.R

class SearchFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?)
            : View? {
        val view = inflater.inflate(
            R.layout.content_search,
            container,
            false)

        val btnSearch = view.findViewById(R.id.btnSearch) as Button
        val editSearch = view.findViewById(R.id.editSearch) as EditText
        val textResult = view.findViewById(R.id.textResult) as TextView

        val dm = DataManager(requireActivity())

        btnSearch.setOnClickListener (
            {
                val c = dm.searchName(editSearch.text.toString())

                if (c.count > 0) {
                 c.moveToNext()
                    textResult.text = "Result = ${c.getString(1)} - ${c.getString(2)}"
                }
            }
        )
        return view
    }
}