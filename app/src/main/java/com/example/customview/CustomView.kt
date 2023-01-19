package com.example.customview

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.annotation.AttrRes


class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr), ValueAnimator.AnimatorUpdateListener {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var progress = 0f
    private var widthScreen = 0f
    private var heightScreen = 0f
    private var animator = ValueAnimator()


    init {

    }

    override fun onDraw(canvas: Canvas) = with(canvas) {
        super.onDraw(canvas)


        paint.color = Color.RED
        paint.strokeWidth = 20f
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        var startPoint = widthScreen - 1.14*widthScreen
        var bottom = heightScreen*0.9
        var top = heightScreen/200


        canvas.drawArc( startPoint.toFloat(), top.toFloat(), (widthScreen*1.14).toFloat(), bottom.toFloat(), 223f,94f, false, paint)

        paint.color = Color.BLUE
        canvas.drawArc(startPoint.toFloat(), top.toFloat(), (widthScreen*1.14).toFloat(), bottom.toFloat(), 223f, progress, false, paint)

    }
    fun setDimention(width:Float, height:Float){
        widthScreen = width
        heightScreen = height
    }


    fun movingToNextStep(prog: Float) {
        animator.duration = 4000
        animator.interpolator = DecelerateInterpolator()
        animator.addUpdateListener {
            progress = animator.animatedValue as Float
            this.invalidate()
        }
        animator.setFloatValues(prog)
        animator.start()

    }
    override fun onAnimationUpdate(p0: ValueAnimator?) {
    }





}








