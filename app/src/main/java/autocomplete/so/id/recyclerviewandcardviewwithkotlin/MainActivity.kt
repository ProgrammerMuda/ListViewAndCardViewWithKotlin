package autocomplete.so.id.recyclerviewandcardviewwithkotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    class Buah(private var nama: String, private var image: Int){
        fun getBuah(): String{ return nama}
        fun getImage(): Int{ return image}
    }


    class CustomAdapter(private var c: Context, private var buah: ArrayList<Buah>) : BaseAdapter(){

        override fun getCount(): Int {return buah.size}
        override fun getItem(i: Int): Any{return buah[i]}
        override fun getItemId(i: Int): Long {return i.toLong()}

        override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View{
            var view = view
            if (view == null){
                view = LayoutInflater.from(c).inflate(R.layout.list_item, viewGroup, false)
            }

           val buah = this.getItem(i) as Buah

            val img = view!!.findViewById<ImageView>(R.id.imgList) as ImageView
            val txt = view.findViewById<TextView>(R.id.lbList) as TextView

            img .setImageResource(buah.getImage())
            txt.text = buah.getBuah()

            view.setOnClickListener { Toast.makeText(c, buah.getBuah(), Toast.LENGTH_SHORT).show() }

            return view



        }
    }

    private lateinit var adapter: CustomAdapter
    private lateinit var myListView: ListView

    private val data : ArrayList<Buah>
    get(){
        val buahs = ArrayList<Buah>()
        var buah = Buah("Apel", R.drawable.apple)
        buahs.add(buah)

        buah = Buah("Alpukat", R.drawable.avocado)
        buahs.add(buah)

        buah = Buah("Pisang", R.drawable.banana)
        buahs.add(buah)

        buah = Buah("chery", R.drawable.cherries)
        buahs.add(buah)


        buah = Buah("Kelapa", R.drawable.coconut)
        buahs.add(buah)

        buah = Buah("Anggur", R.drawable.grapes)
        buahs.add(buah)

        buah = Buah("Lemon", R.drawable.lemon)
        buahs.add(buah)

        buah = Buah("Jeruk", R.drawable.orange)
        buahs.add(buah)

        buah = Buah("pepaya", R.drawable.papaya)
        buahs.add(buah)

        buah = Buah("Nanas", R.drawable.pineapple)
        buahs.add(buah)

        buah = Buah("Labu", R.drawable.pumpkin)
        buahs.add(buah)

        buah = Buah("Tomat", R.drawable.tomato)
        buahs.add(buah)

        buah = Buah("Strawberry", R.drawable.strawberry)
        buahs.add(buah)

        buah = Buah("Semangka", R.drawable.watermelon)
        buahs.add(buah)

        return buahs
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        myListView = findViewById(R.id.myListView) as ListView
        adapter = CustomAdapter(this, data)
        myListView.adapter = adapter



    }
}
