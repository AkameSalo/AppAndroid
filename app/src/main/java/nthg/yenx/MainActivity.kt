package nthg.yenx

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

fun Int.toDp(context: Button): Int = (this * context.resources.displayMetrics.density).toInt()

class MainActivity : AppCompatActivity() {
    fun Int.dpToPx(context: Context): Int = (this * context.resources.displayMetrics.density).toInt()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val scrollBar = findViewById<HorizontalScrollView>(R.id.sroll_test_view)

        val linearLayout = findViewById<LinearLayout>(R.id.test_scroll_vi)

        val buttonsIds = arrayOf("ID", "HOME", "ERZHAN", "NEWS", "BALANCE", "NOTHING", "AVENU", "Xuesos")

        for (buttonText in buttonsIds) {
            val view = LayoutInflater.from(this).inflate(R.layout.headers_buttons, linearLayout, false)

            val button = view.findViewById<Button>(R.id.button)
            button.text = buttonText
            button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20f)

            val myLine = view.findViewById<View>(R.id.myLine)
            val visible = if (buttonText == "ID") View.VISIBLE else View.INVISIBLE
            myLine.visibility = visible

            linearLayout.addView(view)
        }

        window.navigationBarColor = backgroundColorApp
        window.statusBarColor = backgroundColorApp

        val container: LinearLayout = findViewById(R.id.menuButtonsContainer)

        val mainLabel: TextView = findViewById<TextView>(R.id.text_id)

        val drawablesIds = arrayOf(
            R.drawable.home,
            R.drawable.search,
            R.drawable.add_post,
            R.drawable.comments,
            R.drawable.account
        )

        val buttons: MutableList<Button> = mutableListOf()
        drawablesIds.forEach {drawableId ->
            val button = Button(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    30.toDp(this), 30.toDp(this)
                ).apply {
                    background = ContextCompat.getDrawable(context, drawableId)
                    layoutParams = ViewGroup.LayoutParams(30, 30)
                    setMargins(30, 0, 30, 0)
                }
                setOnClickListener {
                    val statusBarHeight: Int = getStatusBarHeight(this@MainActivity)
                    mainLabel.text = "Размер ${statusBarHeight}"
                    updateButtonColors(this, buttons)
                }
            }
            if (drawableId == R.drawable.home) {
                button.background?.colorFilter = pressedMenuButtonColorFilter
            }
            buttons.add(button)
            container.addView(button)
        }
    }

    private fun updateButtonColors(clickedButton: Button, buttons: List<Button>) {
        buttons.forEach { button ->
            if (button == clickedButton) {
                button.background?.colorFilter = pressedMenuButtonColorFilter
            } else {
                button.background?.colorFilter = nptPressedMenuButtonColorFilter
            }
        }
    }
}