package org.sopt.santamanitto.view

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageButton
import org.sopt.santamanitto.R

class SantaSmallButton @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : AppCompatImageButton(context, attrs, defStyleAttr) {

    companion object {
        private const val BUTTON_MINUS = 0
        private const val BUTTON_PLUS = 1
        private const val BUTTON_CANCEL = 2
    }

    private var buttonStyle: Int = 1

    init {
        scaleType = ScaleType.CENTER_INSIDE
        //속성 가져오기
        val typeArray = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.SantaSmallButton,
                0, 0)

        if (typeArray.hasValue(R.styleable.SantaSmallButton_buttonMode)) {
            buttonStyle = typeArray.getInt(R.styleable.SantaSmallButton_buttonMode, BUTTON_PLUS)
        }

        typeArray.recycle()

        //이미지 초기화
        updateButtonImage()
    }

    /**
     * (+) 모양의 이미지로 적용
     */
    fun setPlusImage() {
        setButtonImage(BUTTON_PLUS)
    }

    /**
     * (-) 모양의 이미지로 적용
     */
    fun setMinusImage() {
        setButtonImage(BUTTON_MINUS)
    }

    /**
     * (X) 모양의 이미지로 적용
     */
    fun setCancelImage() {
        setButtonImage(BUTTON_CANCEL)
    }

    // 해당 id로 이미지 적용
    private fun setButtonImage(id: Int) {
        buttonStyle = id
        updateButtonImage()
    }

    // 이미지 업데이트
    private fun updateButtonImage() {
        @DrawableRes
        val resId = when (buttonStyle) {
            BUTTON_CANCEL -> R.drawable.ic_btn_cancle
            BUTTON_MINUS -> R.drawable.ic_btn_minus
            else -> R.drawable.ic_btn_plus
        }
        setBackgroundResource(resId)
    }
}