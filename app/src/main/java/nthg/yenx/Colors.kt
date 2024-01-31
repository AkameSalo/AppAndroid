package nthg.yenx

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter

val colorWhite = Color.rgb(255, 255, 255)

val notpressedColor = Color.rgb(142, 142, 142)

val backgroundColorApp = Color.rgb(0, 0, 0)

val pressedMenuButtonColorFilter = PorterDuffColorFilter(
    colorWhite, PorterDuff.Mode.SRC_ATOP)
val nptPressedMenuButtonColorFilter = PorterDuffColorFilter(
    notpressedColor, PorterDuff.Mode.SRC_ATOP)