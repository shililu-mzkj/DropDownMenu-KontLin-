package com.example.wilson.dropdownmenu.kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.wilson.dropdownmenu.R

/**
 * Created by ggg on 2018/12/6.
 */
class GirdDropDownAdapter constructor(private var context: Context, private val list: List<String>) : BaseAdapter() {

    var checkPosition: Int = 0
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItem(position: Int): String {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var viewHolder: ViewHolder
        var view: View
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list_drop_down, null)
            viewHolder = ViewHolder()
            viewHolder.tv = view.findViewById(R.id.tv)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.getTag() as ViewHolder
        }
        fillValue(position, viewHolder)
        return view
    }

    private fun fillValue(position: Int, viewHolder: ViewHolder) {
        viewHolder.tv.text = list[position]
        if (checkPosition != -1) {
            if (checkPosition == position) {
                viewHolder.tv.setTextColor(context.resources.getColor(R.color.drop_drop_selected))
                viewHolder.tv.setCompoundDrawablesWithIntrinsicBounds(null, null,
                        context.resources.getDrawable(R.drawable.ic_drop_down_city_selected), null)
            } else {
                viewHolder.tv.setTextColor(context.resources.getColor(R.color.drop_drop_unselected))
                viewHolder.tv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
            }
        }
    }

    class ViewHolder {
        lateinit var tv: TextView
    }

}