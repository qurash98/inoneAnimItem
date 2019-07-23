package uz.anor_system.animcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import uz.anor_system.animcard.adapter.ProductAdapter
import uz.anor_system.animcard.models.ProductData
import android.animation.Animator
import android.widget.Toast
import uz.anor_system.animcard.util.CircleAnimationUtil
import android.widget.RelativeLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.layoutManager = LinearLayoutManager(this)

        val adapter = ProductAdapter(context = this, data = initData())

        list.adapter = adapter

        adapter.setActionListener(object : ProductAdapter.ProductItemActionListener {
            override fun onItemTap(imageView: ImageView) {
                makeFlyAnimation(imageView)
            }
        })
    }

    private fun initData(): ArrayList<ProductData> {
        val data = ArrayList<ProductData>()
        for (i in 0..100) {
            data.add(
                ProductData(i, "Feruz $i", R.drawable.one)
            )
        }
        return data
    }

    private fun makeFlyAnimation(targetView: ImageView) {

        CircleAnimationUtil().attachActivity(this).setTargetView(targetView).setMoveDuration(1000)
            .setDestView(cartButtonIV)
            .setAnimationListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {

                }

                override fun onAnimationEnd(animation: Animator) {
                    Toast.makeText(this@MainActivity, "Continue Shopping...", Toast.LENGTH_SHORT).show()
                }

                override fun onAnimationCancel(animation: Animator) {

                }

                override fun onAnimationRepeat(animation: Animator) {

                }
            }).startAnimation()
    }


}
