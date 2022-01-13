package es.iesoretania.navigationcomponentobjeto.Fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import es.iesoretania.navigationcomponentobjeto.R
import kotlinx.android.synthetic.main.fragment_segundo.*

class SegundoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_segundo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        //Obtenemos los argumentos del Bundle si no son nulos
        if(arguments != null){
            val args = SegundoFragmentArgs.fromBundle(requireArguments())

            //Sacamos de este Bundle el objeto de tipo Libro
            val registro = args.libro

            tvTitulo.text = registro.Titulo
            tvPublicacion.text = registro.Publicacion.toString()
            tvPaginas.text = registro.Paginas.toString()
        }

        botonFinal.setOnClickListener {
            //Volvemos al fragmento anterior en la pila de fragmentos.
            navController.popBackStack()
        }
    }
}