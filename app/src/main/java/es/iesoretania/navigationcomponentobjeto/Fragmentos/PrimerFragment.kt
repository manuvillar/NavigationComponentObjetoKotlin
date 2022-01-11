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
import kotlinx.android.synthetic.main.fragment_primer.*


class PrimerFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        botonSegundo.setOnClickListener{
            val titulo = ""
            val publi = 0
            val paginas = 0
            if (edTitulo.text.toString().isEmpty() || edPublicacion.text.toString().isEmpty() || edPaginas.text.toString().isEmpty()){
                Toast.makeText(activity, "Debes introducir algún valor en todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                //Creamos un nuevo objeto de tipo Libro, capturando los valores de los EditText.
                val registro = Libro(
                    edTitulo.text.toString(),
                    edPublicacion.text.toString().toInt(),
                    edPaginas.text.toString().toInt()
                )

                //Una vez comprobado que los EditText no están vacíos, y almacenados sus valores en el objeto,
                // iniciamos una navegación al fragmento SegundoFragment pasánsole el objeto.
                val action = PrimerFragmentDirections.actionPrimerFragmentToSegundoFragment(registro)
                navController.navigate(action)
            }
        }
    }
}