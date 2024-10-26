import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

import androidx.fragment.app.Fragment
import com.m1ctopt1.agedatabase.R

class DeleteFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?)
            : View? {
        val view = inflater.inflate(
            R.layout.content_delete,
            container,
            false)

        val dm = DataManager(requireActivity())

        val btnDelete = view.findViewById(R.id.btnDelete) as Button
        val editDelete = view.findViewById(R.id.editDelete) as EditText

        btnDelete.setOnClickListener(
            {
                dm.delete(editDelete.text.toString())
            }
        )
        return view
    }
}