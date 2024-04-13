package com.calo.labo2.ui.Componets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.calo.labo2.Data.clearNameList

@Composable
fun DeleteName() {
    val showDialog = remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {
                showDialog.value = true
            }
        ) {
            Text(text = "Delete All Names")
        }

        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = { showDialog.value = false },
                title = { Text("Confirmation") },
                text = { Text("Estas seguro de eliminar?") },
                confirmButton = {
                    Button(
                        onClick = {
                            clearNameList()
                            showDialog.value = false
                        }
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialog.value = false
                        }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun DeleteNamePreview() {
    DeleteName()
}
