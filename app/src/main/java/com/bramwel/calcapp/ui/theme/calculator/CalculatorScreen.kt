package com.bramwel.calcapp.ui.theme.screens.calculator

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(navController: NavController) {
    var firstnum by remember { mutableStateOf(TextFieldValue("")) }
    var secondnum by remember { mutableStateOf(TextFieldValue("")) }
    var answer by remember { mutableStateOf("0") }

    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF667EEA),
            Color(0xFF764BA2)
        )
    )

    val operatorButtons = listOf("+", "-", "×", "÷")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground)
            .padding(24.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Calculate,
                contentDescription = "Calculator",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Modern Calculator",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Result Display
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .shadow(
                    elevation = 16.dp,
                    shape = RoundedCornerShape(20.dp)
                ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1A1A2E)
            ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Result",
                    color = Color(0xFF8892B0),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = answer,
                    color = Color.White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Input Fields
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(16.dp)
                ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                OutlinedTextField(
                    value = firstnum,
                    label = {
                        Text(
                            text = "First Number",
                            color = Color(0xFF667EEA),
                            fontSize = 16.sp
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { firstnum = it },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF667EEA),
                        unfocusedBorderColor = Color(0xFFCCD6F6),
                        focusedTextColor = Color(0xFF1A1A2E),
                        unfocusedTextColor = Color(0xFF1A1A2E)
                    ),
                    textStyle = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = secondnum,
                    label = {
                        Text(
                            text = "Second Number",
                            color = Color(0xFF667EEA),
                            fontSize = 16.sp
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { secondnum = it },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF667EEA),
                        unfocusedBorderColor = Color(0xFFCCD6F6),
                        focusedTextColor = Color(0xFF1A1A2E),
                        unfocusedTextColor = Color(0xFF1A1A2E)
                    ),
                    textStyle = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Operator Buttons Grid
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                operatorButtons.forEach { operator ->
                    OperatorButton(
                        operator = operator,
                        onClick = {
                            calculateResult(
                                firstnum.text.trim(),
                                secondnum.text.trim(),
                                operator,
                                onSuccess = { result -> answer = result },
                                onError = { error -> answer = error }
                            )
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // Clear Button
            Button(
                onClick = {
                    firstnum = TextFieldValue("")
                    secondnum = TextFieldValue("")
                    answer = "0"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6B6B)
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Clear",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Clear All",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun OperatorButton(
    operator: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonColors = when (operator) {
        "+" -> Color(0xFF4ECDC4)
        "-" -> Color(0xFF45B7D1)
        "×" -> Color(0xFF96CEB4)
        "÷" -> Color(0xFFFECA57)
        else -> Color(0xFF667EEA)
    }

    Box(
        modifier = modifier
            .height(70.dp)
            .shadow(
                elevation = 8.dp,
                shape = CircleShape
            )
            .clip(CircleShape)
            .background(buttonColors)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = operator,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@SuppressLint("DefaultLocale")
private fun calculateResult(
    first: String,
    second: String,
    operator: String,
    onSuccess: (String) -> Unit,
    onError: (String) -> Unit
) {
    if (first.isEmpty() || second.isEmpty()) {
        onError("Please enter both numbers")
        return
    }

    try {
        val num1 = first.toDouble()
        val num2 = second.toDouble()
        val result = when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "×" -> num1 * num2
            "÷" -> {
                if (num2 == 0.0) {
                    onError("Cannot divide by zero")
                    return
                }
                num1 / num2
            }
            else -> 0.0
        }

        // Format the result to remove trailing .0 if it's an integer
        val formattedResult = if (result % 1 == 0.0) {
            result.toInt().toString()
        } else {
            String.format("%.2f", result)
        }

        onSuccess(formattedResult)
    } catch (e: NumberFormatException) {
        onError("Invalid number format")
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview() {
    CalculatorScreen(rememberNavController())
}