package nthg.yenx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val items: List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Определение ViewHolder
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(android.R.id.text1)
    }

    // Создание новых представлений (вызывается layout manager'ом)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Создаем новое представление
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return MyViewHolder(view)
    }

    // Замена содержимого представления (вызывается layout manager'ом)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Получаем элемент из вашего набора данных в этой позиции
        // и заменяем содержимое представления этим элементом
        holder.textView.text = items[position]
    }

    // Возвращает размер вашего набора данных (вызывается layout manager'ом)
    override fun getItemCount() = items.size
}
