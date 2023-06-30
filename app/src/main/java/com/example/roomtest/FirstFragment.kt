package com.example.roomtest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.roomtest.databinding.FragmentFirstBinding
import com.example.roomtest.model.Task
import com.example.roomtest.model.TaskDataBase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    /*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        // contexto de la base de datos
        val instance = Room.databaseBuilder(
            requireContext().applicationContext,

            TaskDataBase::class.java,
            "task_database")
            // obligo hacer la tarea
            .allowMainThreadQueries()
            .build()

        var taskExample = Task(task = " Prueba BD 58", descripcion = "Prueba de inserción de datos",
            date = "28/08/2023")
        instance.getTaskDao().insertTask(taskExample)

        Log.d("Result: Ok", taskExample.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}