package com.example.weatherapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapi.adapter.WeatharityAdapter
import com.wetharityoptimus.app.databinding.FragmentHoursBinding
import com.wetharityoptimus.app.weatharitydata.WeatharityData
import com.wetharityoptimus.app.weatharityviewmodel.WeatharityViewModel
import org.json.JSONArray
import org.json.JSONObject


class WeatharityHoursFragment : Fragment() {
    private lateinit var binding: FragmentHoursBinding
    private lateinit var ospsdw: WeatharityAdapter
    private val weatharityViewModel: WeatharityViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        oassawww()
        weatharityViewModel.jsksawqw.observe(viewLifecycleOwner,{
               ospsdw.submitList(bbshdadas(it))
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHoursBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun oassawww() =with(binding){
        ospsdw = WeatharityAdapter()
        osoassa.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        osoassa.adapter = ospsdw



    }

    private fun bbshdadas(item : WeatharityData) : List<WeatharityData>{
        val hoursArray =  JSONArray(item.hours)
        val list = ArrayList<WeatharityData>()

        for(i in 0 until hoursArray.length()){

            val wItem = WeatharityData(
                city = item.city,
                date =  (hoursArray[i] as JSONObject).getString("time"),
                condition = (hoursArray[i] as JSONObject).getJSONObject("condition").getString("text"),
                currentTemp = (hoursArray[i] as JSONObject).getString("temp_c").toFloat().toInt().toString(),
                minTemp = "",
                maxTemp = "",
                image = (hoursArray[i] as JSONObject).getJSONObject("condition").getString("icon"),
                hours = ""
            )

            list.add(wItem)

        }

        return list


    }

    companion object {
        @JvmStatic
        fun newInstance() = WeatharityHoursFragment()

    }
}