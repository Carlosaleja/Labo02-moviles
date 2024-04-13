package com.calo.labo2.ui.Componets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.calo.labo2.Data.nameList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNameComponent () {

    val name:MutableState <String> = remember  { mutableStateOf("") }
    val nameListScope = remember {
        nameList
    }

    Column(modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        Text(text = "Lista de nombres", modifier = Modifier.padding(6.dp))

        TextField(value = name.value, onValueChange = {name.value = it},
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Black,
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {}),
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(20.dp),
            placeholder = { Text(
            text = "Enter Name"
        )} )

        LazyColumn(modifier = Modifier
            .padding(8.dp)
            .border(1.dp, Color.Black)
            .background(Color.White)
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .padding(horizontal = 16.dp)
            .height(100.dp)) {

            itemsIndexed(nameListScope){index, item ->
                Text(text = "item #$index: $item ")
            }
        }

        Button(onClick = {
            nameList.add(name.value)
            name.value = ""
        }) { Text(text = "Add Name")

        }

    }


}

@Preview(showSystemUi = false)
@Composable
fun AddNameComponentPreview (){

    AddNameComponent()
}