package com.example.weatherapi.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.activityViewModels
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherapi.adapter.WeatharityVpAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import com.wetharityoptimus.app.databinding.FragmentMainBinding
import com.wetharityoptimus.app.weatharitydata.WeatharityData
import com.wetharityoptimus.app.weatharityviewmodel.WeatharityViewModel
import org.json.JSONObject

const val API_KEY = "aa7a0fc2128148ae931154725221206"

class MainFragment : Fragment() {
    private lateinit var activityLauncher: ActivityResultLauncher<String> // Благодаря лаунчера запускается запрос на разрешения
    private lateinit var binding: FragmentMainBinding
    val weatharityViewModel: WeatharityViewModel by activityViewModels()
    val usususd = listOf<Fragment>(WeatharityHoursFragment.newInstance(), WeatharityDaysFragment.newInstance())
    private val nshsaudw = listOf<String>("Hours", "Days")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        opwqweqwe()
        jsjsdadqw("Kiev")
        aasdsadqw()
    }


    private fun opwqweqwe() = with(binding) {
        val adapter = WeatharityVpAdapter(requireActivity(), usususd)
        vpWeather.adapter = adapter
        TabLayoutMediator(tabLayout, vpWeather) { tab, pos ->
            tab.text = nshsaudw[pos]

        }.attach()

    }


    private fun aasdsadqw() = with(binding){
        weatharityViewModel.jsksawqw.observe(viewLifecycleOwner, {
            tvCity.text = it.city
            tvDateTime.text = it.date
            lsksjsda.text = "${it.currentTemp}℃"
            tvMinMaxTemp.text = "${it.minTemp}/${it.maxTemp}℃"
            tvWeatherDesc.text = it.condition
            Picasso.get().load("https:${it.image}").into(imWeather)

        })
    }


    private fun jsjsdadqw(city: String) {
        val url = "https://api.weatherapi.com/v1/forecast.json?key=" +
                API_KEY +
                "&q=" +
                city +
                "&days=" +
                "3" +
                "&aqi=no&alerts=no"

        val queue = Volley.newRequestQueue(context) // Инстанция очереди
        val request = StringRequest( // Формирование запроса
            Request.Method.GET,
            url,
            { result ->
                oskskdaswqwq(result)

            },
            { error ->
                Log.d("LogInfo", "Error: $error")
            }
        )
        queue.add(request) // Добавляем запрос
    }


    private fun oskskdaswqwq(result: String) {
        val mainObject = JSONObject(result)
        val list = jsjsaowiqwe(mainObject)
        parseData(mainObject,list[0])

    }

    private fun parseData(mainObject: JSONObject, weatharityData: WeatharityData) {
        val item = WeatharityData(
            city = mainObject.getJSONObject("location").getString("name"),
            date = mainObject.getJSONObject("current").getString("last_updated"),
            condition = mainObject.getJSONObject("current").getJSONObject("condition")
                .getString("text"),
            image = mainObject.getJSONObject("current").getJSONObject("condition")
                .getString("icon"),
            currentTemp = mainObject.getJSONObject("current").getString("temp_c"),
            minTemp = weatharityData.minTemp,
            maxTemp = weatharityData.maxTemp,
            hours = weatharityData.hours
        )

        weatharityViewModel.jsksawqw.value = item // Передаем значение


    }

    private fun jsjsaowiqwe(mainObject: JSONObject): List<WeatharityData> {
        val list = ArrayList<WeatharityData>()
        val daysArray = mainObject.getJSONObject("forecast").getJSONArray("forecastday")
        for (i in 0 until daysArray.length()) { // беребираем весь массив
            val name = mainObject.getJSONObject("location").getString("name")
            val day = daysArray[i] as JSONObject
            val item = WeatharityData(
                city = name,
                date = day.getString("date"),
                condition = day.getJSONObject("day").getJSONObject("condition").getString("text"),
                minTemp = day.getJSONObject("day").getString("mintemp_c").toFloat().toInt().toString(),
                maxTemp =  day.getJSONObject("day").getString("maxtemp_c").toFloat().toInt().toString(),
                hours = day.getJSONArray("hour").toString(),
                image = "",
                currentTemp = ""
            )
            list.add(item)

        }
        weatharityViewModel.bbhshdaw.value = list
        return list

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()

    }
}