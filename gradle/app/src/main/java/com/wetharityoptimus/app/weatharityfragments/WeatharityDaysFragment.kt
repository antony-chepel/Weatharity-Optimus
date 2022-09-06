package com.example.weatherapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapi.adapter.WeatharityAdapter
import com.wetharityoptimus.app.databinding.FragmentDaysBinding
import com.wetharityoptimus.app.weatharityviewmodel.WeatharityViewModel


class WeatharityDaysFragment : Fragment() {

    private lateinit var binding: FragmentDaysBinding

    private lateinit var nsnsjsa: WeatharityAdapter

    private val model : WeatharityViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        jdfjfsdfsd()
        model.bbhshdaw.observe(viewLifecycleOwner,{
            nsnsjsa.submitList(it.subList(1,it.size))
        })
    }

    private fun jdfjfsdfsd() = with(binding){
        nsnsjsa = WeatharityAdapter()

        osoassa.adapter = nsnsjsa

        osoassa.layoutManager = LinearLayoutManager(activity)
    }

    companion object {
        @JvmStatic
        fun newInstance() = WeatharityDaysFragment()
    }
}