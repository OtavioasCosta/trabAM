package br.com.cotemig.trabalhoam.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.trabalhoam.R
import br.com.cotemig.trabalhoam.model.Artistas
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class artistasAdapter(var context: Context, var artistas: List<Artistas>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_artistas, null)

        var nome = view.findViewById<TextView>(R.id.nome)
        nome.text = artistas[position].nome

        var image = view.findViewById<ImageView>(R.id.img)
        Glide.with(context).load(artistas[position].imagens).apply(RequestOptions().transform(
            RoundedCorners(200)
        )).into(image)

        return view
    }

    override fun getItem(position: Int): Any {
        return  ""
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return artistas.size
    }
}