package com.example.hesapmakinesi
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hesapmakinesi.ui.theme.bgColor
import com.example.hesapmakinesi.ui.theme.darkButtonText
import com.example.hesapmakinesi.ui.theme.lightDarkButton
import com.example.hesapmakinesi.ui.theme.worksans


@Composable
fun Anasayfa() {
    val configuration = LocalConfiguration.current
    val genislik = configuration.screenWidthDp
    val yukseklik = configuration.screenHeightDp
    val kG = (0.12165 * genislik * 0.7)
    val kY = (0.07072 * yukseklik * 0.7)

    var ekran = remember { mutableStateOf("") }
    var oncekiIslem = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    LaunchedEffect(ekran.value) {

        scrollState.animateScrollTo(scrollState.maxValue)
    }


    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(bgColor),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(bgColor),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .size((kG * 8.1).dp, 100.dp)
                        .background(color = bgColor)
                        .padding(0.dp)
                        .align(Alignment.End),

                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = oncekiIslem.value, color = lightDarkButton,
                        fontFamily = worksans,
                        fontSize = 37.sp,
                        maxLines = 1,
                        )
                }

                Box(
                    modifier = Modifier
                        .size((kG * 8.1).dp, 100.dp)
                        .background(color = bgColor)
                        .padding(0.dp)
                        .align(Alignment.End),

                    contentAlignment = Alignment.CenterEnd
                ) {

                    Row(
                        modifier = Modifier
                            .horizontalScroll(scrollState)
                            .wrapContentWidth(Alignment.End)
                            .background(bgColor),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = ekran.value,
                            color = darkButtonText,
                            fontFamily = worksans,
                            fontSize = 50.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Visible
                        )
                    }
                }
            }

            Row(horizontalArrangement = Arrangement.Start) {
                Column {
                    Row {
                        ButtonChip(icerik = "9", h = (kY * 2).toInt(), (kG * 2).toInt(), 0) {
                            ekran.value += "9"
                        }
                        ButtonChip(icerik = "8", (kY * 2).toInt(), (kG * 2).toInt(), 0) {
                            ekran.value += "8"
                        }
                        ButtonChip(icerik = "7", (kY * 2).toInt(), (kG * 2).toInt(), 0) {
                            ekran.value += "7"
                        }
                    }
                    Row {
                        ButtonChip(icerik = "6", (kY * 2).toInt(), (kG * 2).toInt(), 0) {
                            ekran.value += "6"
                        }
                        ButtonChip(icerik = "5", (kY * 2).toInt(), (kG * 2).toInt(), 0) {
                            ekran.value += "5"
                        }
                        ButtonChip(icerik = "4", (kY * 2).toInt(), (kG * 2).toInt(), 0) {
                            ekran.value += "4"
                        }
                    }
                    Row {
                        ButtonChip(icerik = "3", (kY * 2).toInt(), (kG * 2).toInt(), 0) {
                            ekran.value += "3"
                        }
                        ButtonChip(icerik = "2", (kY * 2).toInt(), (kG * 2).toInt(), 0) {
                            ekran.value += "2"
                        }
                        ButtonChip(icerik = "1", (kY * 2).toInt(), (kG * 2).toInt(), 0) {
                            ekran.value += "1"
                        }
                    }
                    Row {
                        ButtonChip(icerik = "0", (kY * 2).toInt(), (kG * 4.66).toInt(), 0) {
                            ekran.value += "0"
                        }
                        ButtonChip(icerik = ".", (kY * 2).toInt(), (kG * 2).toInt(), 0) {
                            ekran.value += "."
                        }
                    }
                }
                Column {
                    ButtonChip(icerik = "C", (kY * 2).toInt(), (kG * 2).toInt(), 2) {
                        ekran.value = ""
                        oncekiIslem.value = ""
                    }
                    ButtonChip(icerik = "Sil", (kY * 2).toInt(), (kG * 2).toInt(), 1) {
                        ekran.value = ekran.value.dropLast(1)
                    }
                    ButtonChip(icerik = "+", (kY * 2).toInt(), (kG * 2).toInt(), 1) {
                        if (ekran.value.isNotEmpty() && ekran.value.last() != '+') {
                            ekran.value += "+"
                        }
                    }
                    ButtonChip(icerik = "=", (kY * 2).toInt(), (kG * 2).toInt(), 1) {
                        oncekiIslem.value = ekran.value
                        ekran.value = calculateResult(ekran.value)



                        }

                    }
                }
            }
        }
    }


@SuppressLint("DefaultLocale")
fun calculateResult(expression: String): String {
    return try {
        val sanitizedExpression = expression.replace(",", ".")
        val result = sanitizedExpression.split("+").sumOf { it.toDouble() }

        String.format("%.2f", result) // Rounded to two decimal places

    } catch (e: Exception) {
        "Error"
    }
}