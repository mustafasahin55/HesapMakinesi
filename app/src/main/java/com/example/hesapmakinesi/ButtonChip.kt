package com.example.hesapmakinesi

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hesapmakinesi.ui.theme.blueButton
import com.example.hesapmakinesi.ui.theme.blueButtonBorder
import com.example.hesapmakinesi.ui.theme.darkButton
import com.example.hesapmakinesi.ui.theme.darkButtonText
import com.example.hesapmakinesi.ui.theme.lightDarkButton

@Composable
fun ButtonChip(icerik: String, h: Int, w: Int,stil:Int, onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .padding(12.dp)
            .background(
                color = if (stil == 0) darkButton else (if (stil == 2) lightDarkButton else blueButton),
                shape = RoundedCornerShape((if (icerik == "0") ((h / 3).dp) else ((w / 3).dp)))
            )
            .size(height = h.dp, width = w.dp)
            .border(
                1.dp,
                if (stil == 0) darkButton else (if (stil == 2) lightDarkButton else blueButtonBorder),

                RoundedCornerShape(33)
            )
            .clickable {
                onClick()

            }
    ) {
        if (icerik == "Sil"){
            Icon(painter = painterResource(id = R.drawable.baseline_backspace_24), contentDescription ="" ,
                modifier = Modifier.align(Alignment.Center).size(35.dp))
        }else{
            Text(
                text = icerik,
                color = darkButtonText,
                fontSize = 32.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                textAlign = TextAlign.Center,
            )
        }


    }

}