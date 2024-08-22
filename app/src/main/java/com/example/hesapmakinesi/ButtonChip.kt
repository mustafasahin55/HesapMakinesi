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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonChip(icerik: String, h: Int, w: Int, onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .padding(1.dp)
            .background(color = Color.DarkGray, shape = RoundedCornerShape(6.dp))
            .size(height = h.dp, width = w.dp)
            .border(
                2.dp, Color.Gray,
                RoundedCornerShape(10)
            )
            .clickable {
                if (icerik == "=" || icerik == "Sil") {
                    //
                } else {
                    onClick()
                }

            }
    ) {
        Text(
            text = icerik,
            color = Color.Gray,
            fontSize = 50.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }

}