import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.fragment.app.Fragment
import com.m1ctopt1.agedatabase.R

class ResultsFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?)
            : View? {
        val view = inflater.inflate(
            R.layout.content_results,
            container,
            false)

            val dm = DataManager(requireActivity())

            val textResults = view.findViewById(R.id.textResults) as TextView

            val c = dm.selectAll()
            var list = " "

            while (c.moveToNext()){
                list += c.getString(1) + " - " + c.getString(2) + "\n"
            }

        textResults.text = list
        return view
    }
}