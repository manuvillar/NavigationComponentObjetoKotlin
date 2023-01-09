package es.iesoretania.navigationcomponentobjeto.Fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import es.iesoretania.navigationcomponentobjeto.Libro
import es.iesoretania.navigationcomponentobjeto.R
import es.iesoretania.navigationcomponentobjeto.databinding.FragmentPrimerBinding


class PrimerFragment : Fragment() {
    private lateinit var binding: FragmentPrimerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrimerBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        binding.botonSegundo.setOnClickListener{
            //Si todos los EditText no están vacíos
            if (binding.edTitulo.text.toString().isEmpty() || binding.edPublicacion.text.toString().isEmpty() || binding.edPaginas.text.toString().isEmpty()){
                Toast.makeText(activity, "Debes introducir algún valor en todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                //Creamos un nuevo objeto de tipo Libro, capturando los valores de los EditText.
                val registro = Libro(
                    binding.edTitulo.text.toString(),
                    binding.edPublicacion.text.toString().toInt(),
                    binding.edPaginas.text.toString().toInt()
                )

                //Una vez comprobado que los EditText no están vacíos, y almacenados sus valores en el objeto,
                // iniciamos una navegación al fragmento SegundoFragment pasánsole el objeto.
                val action = PrimerFragmentDirections.actionPrimerFragmentToSegundoFragment(registro)
                navController.navigate(action)
            }
        }
    }
}