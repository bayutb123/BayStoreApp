package com.bayutb.baystoreapp.presentation.screen.payment

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.bayutb.baystoreapp.R
import com.bayutb.baystoreapp.presentation.Screen
import com.bayutb.baystoreapp.presentation.screen.TitleText
import com.bayutb.baystoreapp.presentation.screen.convertToRupiah
import com.bayutb.baystoreapp.ui.theme.BayStoreAppTheme
import kotlinx.coroutines.delay
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    modifier: Modifier = Modifier,
    accountId: Int,
    itemId: Int,
    paymentId: Int,
    onBackPressed: () -> Unit
) {
    val paymentViewModel: PaymentViewModel = hiltViewModel()
    var isPaid by remember { mutableStateOf(false) }
    val orderData = paymentViewModel.getOrderData(accountId, itemId, paymentId)
    val clipboardManager = LocalClipboardManager.current
    val loading by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.ani_stick))
    val loadingProgress by animateLottieCompositionAsState(
        composition = loading,
        iterations = LottieConstants.IterateForever
    )
    var isLoading by remember { mutableStateOf(true) }
    var isSuccess by remember { mutableStateOf(false) }
    val success by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.ani_success))
    val successProgress by animateLottieCompositionAsState(
        composition = success,
        isPlaying = isSuccess
    )
    LaunchedEffect(key1 = null) {
        delay(1000L)
        isLoading = false
    }
    LaunchedEffect(key1 = isPaid) {
        if (isPaid) {
            isLoading = true
            // PROCESSING PAYMENT WILL BE HERE
            delay(2000L)
            isLoading = false
            // ANIMATION DELAY
            delay(500L)
            isSuccess = true
            // SUCCESS ANIMATION DISPLAY TIME
            delay(3000L)
            isPaid = false
            // GO BACK TO HOME
            onBackPressed()
        }
    }
    val generateQR by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.ani_qr_enter))
    var isQRRequested by remember { mutableStateOf(false) }
    val generateQRProgress by animateLottieCompositionAsState(
        composition = generateQR,
        isPlaying = isQRRequested
    )

    Scaffold(
        topBar = {
            AnimatedVisibility(
                visible = !isQRRequested && !isLoading && !isPaid,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                TopAppBar(title = {
                    Text(text = "Payment")
                }, navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                })
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues),
        ) {
            AnimatedVisibility(
                visible = isLoading,
                exit = fadeOut()
            ) {
                Box(
                    modifier = modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    if (!isPaid) {
                        Text(
                            text = "preparing your payment method..",
                            modifier = modifier.offset(y = 100.dp)
                        )
                    }
                    LottieAnimation(composition = loading, progress = { loadingProgress })
                }
            }
            AnimatedVisibility(
                visible = isPaid && !isLoading,
                enter = EnterTransition.None,
                exit = fadeOut()
            ) {
                Box(
                    modifier = modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    LottieAnimation(composition = success, progress = { successProgress })
                }
            }
            AnimatedVisibility(
                visible = !isLoading && !isQRRequested,
                enter = fadeIn()
            ) {
                Box(
                    modifier = modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = modifier
                            .fillMaxWidth()
                    ) {
                        Box(
                            modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {

                            Column {
                                TitleText(value = "Order Details")
                                Column(modifier.padding(16.dp)) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(text = "Item Name", modifier = modifier.weight(0.4f))
                                        Text(text = " : ", modifier = modifier.weight(0.1f))
                                        Text(
                                            text = "ML Diamonds",
                                            textAlign = TextAlign.End,
                                            modifier = modifier.weight(1f)
                                        )

                                    }
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(text = "Price", modifier = modifier.weight(0.4f))
                                        Text(text = " : ", modifier = modifier.weight(0.1f))
                                        Text(
                                            text = convertToRupiah(orderData.inGameCurrency.price * 100 / 111),
                                            textAlign = TextAlign.End,
                                            modifier = modifier.weight(1f)
                                        )
                                    }
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(text = "Tax", modifier = modifier.weight(0.4f))
                                        Text(text = " : ", modifier = modifier.weight(0.1f))
                                        Text(
                                            text = convertToRupiah(orderData.inGameCurrency.price * 11 / 100),
                                            textAlign = TextAlign.End,
                                            modifier = modifier.weight(1f)
                                        )
                                    }
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = "Total Order", modifier = modifier.weight(0.4f),
                                            fontWeight = FontWeight.Bold,
                                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                        )
                                        Text(
                                            text = " : ", modifier = modifier.weight(0.1f),
                                            fontWeight = FontWeight.Bold,
                                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                        )
                                        Text(
                                            text = convertToRupiah(orderData.inGameCurrency.price),
                                            textAlign = TextAlign.End,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                            modifier = modifier.weight(1f)
                                        )
                                    }
                                    Text(text = "Please complete this payment next 24 hours")
                                }
                                if (orderData.paymentMethod.id != 1) {
                                    TitleText(value = "Payment Code")
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = modifier
                                            .padding(horizontal = 16.dp)
                                            .padding(top = 8.dp)
                                            .background(
                                                MaterialTheme.colorScheme.primaryContainer,
                                                RoundedCornerShape(8.dp)
                                            )
                                            .fillMaxWidth()
                                    ) {
                                        Spacer(modifier = modifier.height(16.dp))
                                        Text(text = orderData.paymentMethod.name)
                                        Text(
                                            text = orderData.paymentCode.toString(),
                                            fontWeight = FontWeight.Bold,
                                            fontSize = MaterialTheme.typography.titleLarge.fontSize
                                        )
                                        TextButton(onClick = {
                                            clipboardManager.setText(AnnotatedString(orderData.paymentCode.toString()))
                                        }) {
                                            Text(text = "Copy")
                                        }
                                    }
                                } else {
                                    TitleText(value = "Bay-Wallet")
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = modifier
                                            .padding(horizontal = 16.dp)
                                            .padding(top = 8.dp)
                                            .background(
                                                MaterialTheme.colorScheme.primaryContainer,
                                                RoundedCornerShape(8.dp)
                                            )
                                            .padding(vertical = 16.dp)
                                            .fillMaxWidth()
                                    ) {
                                        Text(text = "Bay-Wallet Balance")
                                        Text(
                                            text = convertToRupiah(900000),
                                            fontWeight = FontWeight.Bold,
                                            fontSize = MaterialTheme.typography.titleLarge.fontSize
                                        )
                                    }
                                }
                            }
                        }
                        if (orderData.paymentMethod.id != 1) {
                            ElevatedButton(onClick = { isQRRequested = true }) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.QrCode,
                                        contentDescription = null
                                    )
                                    Text(text = "Show QR Code")
                                }
                            }
                        } else {
                            Button(onClick = {
                                isPaid = true
                            }) {
                                Text(text = "Confirm Payment")
                            }
                        }
                    }
                }
            }
            AnimatedVisibility(
                visible = isQRRequested,
                enter = fadeIn()
            ) {
                Box(
                    modifier = modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(16.dp), contentAlignment = Alignment.TopEnd
                    ) {
                        IconButton(onClick = { isQRRequested = false }) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = "Close QR")
                        }
                    }
                    Text(
                        text = "Scan here",
                        modifier = modifier.offset(y = 200.dp),
                        fontSize = MaterialTheme.typography.displaySmall.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                    LottieAnimation(
                        composition = generateQR,
                        progress = { generateQRProgress },
                        modifier = modifier.background(
                            Color.White, RoundedCornerShape(8.dp)
                        )
                    )
                }
            }
        }

    }
    BackHandler {
        onBackPressed()
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun PreviewPayment() {
    BayStoreAppTheme {
    }
}