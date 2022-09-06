package com.example.weatherapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wetharityoptimus.app.R
import com.wetharityoptimus.app.databinding.ListItemBinding
import com.wetharityoptimus.app.weatharitydata.WeatharityData

class WeatharityAdapter : ListAdapter<WeatharityData,WeatharityAdapter.WheatharityHolder>(Comparator()) {

    class WheatharityHolder(view : View) : RecyclerView.ViewHolder(view) {

        private val jsdasd = ListItemBinding.bind(view)

        fun setWeatherData(item : WeatharityData) = with(jsdasd){
            osodad.text = item.date

            hsdadas.text = item.condition

            lsksjsda.text = item.currentTemp.ifEmpty { "${item.maxTemp}℃ / ${item.minTemp}℃"  }

            Picasso.get().load("https:${item.image}").into(imw)


        }

    }

    class Comparator : DiffUtil.ItemCallback<WeatharityData>() {
        override fun areItemsTheSame(oldItem: WeatharityData, newItem: WeatharityData): Boolean {
           return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatharityData, newItem: WeatharityData): Boolean {
           return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WheatharityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return WheatharityHolder(view)
    }

    override fun onBindViewHolder(holder: WheatharityHolder, position: Int) {
        holder.setWeatherData(getItem(position))
    }
}