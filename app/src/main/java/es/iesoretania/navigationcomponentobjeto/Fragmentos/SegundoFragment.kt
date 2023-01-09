package es.iesoretania.navigationcomponentobjeto.Fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import es.iesoretania.navigationcomponentobjeto.databinding.FragmentSegundoBinding


class SegundoFragment : Fragment() {
    private lateinit var binding: FragmentSegundoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSegundoBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        //Obtenemos los argumentos del Bundle si no son nulos
        if(arguments != null){
            val args = SegundoFragmentArgs.fromBundle(requireArguments())

            //Sacamos de este Bundle el objeto de tipo Libro
            val registro = args.libro

            binding.tvTitulo.text = registro.Titulo
            binding.tvPublicacion.text = registro.Publicacion.toString()
            binding.tvPaginas.text = registro.Paginas.toString()
        }

        binding.botonFinal.setOnClickListener {
            //Volvemos al fragmento anterior en la pila de fragmentos.
            navController.popBackStack()
        }
    }
}