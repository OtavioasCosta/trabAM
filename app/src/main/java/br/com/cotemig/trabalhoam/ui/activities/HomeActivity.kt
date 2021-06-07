package br.com.cotemig.trabalhoam.ui.activities

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.cotemig.trabalhoam.R
import br.com.cotemig.trabalhoam.model.Artistas
import br.com.cotemig.trabalhoam.model.ListArtistas
import br.com.cotemig.trabalhoam.services.RetrofitInitializer
import br.com.cotemig.trabalhoam.ui.adapters.artistasAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        obterArtistas()
    }
    fun obterArtistas(){

        var s = RetrofitInitializer().serviceArtistas()


        var call = s.obterListaArtistas()

        call.enqueue(object : Callback<ListArtistas> {

            override fun onFailure(call: Call<ListArtistas>, t: Throwable) {
                Toast.makeText(this@HomeActivity, "Erro", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ListArtistas>, response: Response<ListArtistas>) {

                if(response.code() == 200){
                    response.body()?.let{
                        mostraLista(it.artistas)
                        //Toast.makeText(this@MainActivity, "Sucesso! Total de registros: " + it.lista.size, Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }

        )
    }

    fun mostraLista(artistas: List<Artistas>){

        var listArtistas = findViewById<ListView>(R.id.listArtistas)
        listArtistas.adapter = artistasAdapter(this, artistas)
    }
}