import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bmicalculator.R
import com.example.bmicalculator.ResultFragment

class InputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        val etHeight = view.findViewById<EditText>(R.id.etHeight)
        val etWeight = view.findViewById<EditText>(R.id.etWeight)
        val btnCalculate = view.findViewById<Button>(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            val height = etHeight.text.toString().toFloatOrNull()
            val weight = etWeight.text.toString().toFloatOrNull()

            if (height != null && weight != null) {
                val bmi = weight / ((height / 100) * (height / 100))

                // Bundle me data pass
                val bundle = Bundle()
                bundle.putFloat("bmi_value", bmi)

                val resultFragment = ResultFragment()
                resultFragment.arguments = bundle

                // Fragment replace
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, resultFragment)
                    .addToBackStack(null)
                    .commit()
            } else {
                Toast.makeText(requireContext(), "Enter valid values", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
