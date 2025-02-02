package com.example.mynewsapp.ui_Layer.Search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun SearchBox(
    query: String,
    onQueryChange: (String) -> Unit,
    onClick: () -> Unit
) {
    val customTextSelectionColors = TextSelectionColors(
        handleColor = Color.Blue,  // Selection handle color
        backgroundColor = Color.LightGray.copy(alpha = 0.4f) // Selection highlight color
    )
    val keyboardController = LocalSoftwareKeyboardController.current // Keyboard Controller


    CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(2.dp, Color.Black, shape = RoundedCornerShape(8.dp)), // Black Border
            placeholder = { Text("Search...") },
            leadingIcon = {
                Icon(tint = Color.Black,
                    imageVector = Icons.Default.Search, contentDescription = "Search Icon")
            },
            trailingIcon = {
                if (query.isNotEmpty()) {
                    IconButton(onClick = {
                        onClick.invoke()
                        keyboardController?.hide() // Close Keyboard

                    }) {
                        Icon(tint = Color.Black,
                            imageVector = Icons.Default.Done, contentDescription = "Confirm Search")
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = Color.Black,
                focusedTextColor = Color.Black
            ),
            singleLine = true,
            keyboardActions = KeyboardActions(
                onDone = {
                    onClick.invoke()   // Calls onClick when "Done" is pressed
                    keyboardController?.hide() // Close Keyboard

                }
            )
        )
    }
}
