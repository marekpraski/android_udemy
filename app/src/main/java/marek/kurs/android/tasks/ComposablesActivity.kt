package marek.kurs.android.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ComposablesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MyColumn()
            //MyRow()
            //MyColumnExcercise()
            //MyModifier()
            //ModifierExcercise()
            //MyText()
            //MyTextAlign()
            //MyIcon()
            //MySpacer()
            //MyDivider()
            //MyProgress()
            //MyTextDividerProgressExcercise()
            //MyButton()
            //MySurface()
            //MyCard()
            //MyBox()
            //MyWeigth()
            //ExerciseBottomBar()
            //MyClickButton()
            //ButtonClickExcercise()
            //MyCheckBox()
            //MyRadioButton()
            //MySwitch()
            //MySlider()
            //MyIconButton()
            //MyFAB()
            //MyClickableModifier()
            //MyShowHideClick()
            //SliderSettingsExcercise()
            //MyTextField()
            //MyOutlinedTextField()
            //TextFieldExcercise1()
            //TextFieldExcercise2()
            //MyLazyColumn()
            //MyLazyRow()
            //MyLazyRowCustomItems()
            //MyLazyVerticalGrid()
            //MyLazyHorizontalGrid()
            //LazyColumnExcercise1()
            //LazyRowExcerise()
            //LazyColumnAndRowExcercise()
            LazyGridExcercise()
        }
    }

    @Composable
    fun LazyGridExcercise(){
        var nrCols by remember{ mutableStateOf(5) }

        Column() {
            Row() {
                Button(onClick = { nrCols = 1 }) {
                    Text(text = "1")
                }
                Button(onClick = { nrCols = 3 }) {
                    Text(text = "3")
                }
                Button(onClick = { nrCols = 5 }) {
                    Text(text = "5")
                }
            }
            LazyVerticalGrid(columns = GridCells.Fixed(nrCols)) {
                items(count = 100) {i->
                    LazyCard(i)
                }
            }
        }
    }

    @Composable
    fun LazyColumnAndRowExcercise(){
        LazyColumn(){

            items(count = 100){columnIndex->
                LazyRow() {
                    items(count = 100) { i ->
                        LazyCard(columnIndex * i)
                    }
                }
            }
        }
    }

    @Composable
    fun LazyRowExcerise(){
        var idClicked: MutableState<Int> = remember{ mutableStateOf(-1) }

        LazyRow(){
            items(count = 20){i->
                TextBoxItem(i, idClicked)
            }
        }
    }

    @Composable
    fun TextBoxItem(id: Int, idClicked: MutableState<Int>){
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .border(width = 1.dp, color = Color.Black)
                .size(30.dp, 50.dp)
                .clickable(true, onClick = { idClicked.value = id })
                .background(color = if (id == idClicked.value) Color.LightGray else Color.White)
        ){
            Text(text = "$id")
        }
    }

    @Composable
    fun LazyColumnExcercise1(){
        Column(){
            var ids = remember{ mutableStateListOf<Int>() }
            var id: MutableState<Int> = remember{ mutableStateOf(0) }

            Button(onClick = { ids.add(id.value)
                id.value++},
                modifier = Modifier.padding(vertical = 5.dp)
            ) {
                Text(text = "Add", color = Color.White,
                    modifier = Modifier.padding(10.dp)
                )
            }
            LazyColumn(contentPadding = PaddingValues(vertical = 5.dp)){
                items(items = ids){item ->
                    Text(text = "$item")
                }
            }
        }
    }

    @Composable
    fun MyLazyHorizontalGrid(){
        LazyHorizontalGrid(rows = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(20.dp)
        ){
            items(count = 32){index ->
                LazyCard(index)
            }
        }
    }

    @Composable
    fun MyLazyVerticalGrid(){
        LazyVerticalGrid(columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        )
        {
            items(count = 11){i ->
                LazyCard(i)
            }
        }
    }

    @Composable
    fun MyLazyRowCustomItems(){
        LazyRow(
            contentPadding = PaddingValues((10.dp)),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(count = 10){i ->
                LazyCard(i)
            }
        }
    }

    @Composable
    fun LazyCard(index: Int){
        Card(border = BorderStroke(width = 1.dp, color = Color.DarkGray)){
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ){
                Icon(imageVector = Icons.Default.List, contentDescription = "")
                Text(text = "t $index")
            }
        }
    }


    @Composable
    fun MyLazyRow(){
        val itemList = remember{ mutableStateListOf("a", "a", "c") }
        LazyRow(
            contentPadding = PaddingValues(20.dp),
            horizontalArrangement = Arrangement.spacedBy((20.dp))
        ){
            item {Text(text = "itemText")}
            items(items = itemList){i ->
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(20.dp)
                        .width(30.dp)
                        .border(width = 1.dp, color = Color.Red, shape = RoundedCornerShape(4.dp))
                ){Text(text = "li $i")}
            }
            items(count = 30){k ->
                Text(text = "count $k")
            }
            for(j in 1..11)
                item{Text(text = "ttt $j")}
        }
    }

    @Composable
    fun MyLazyColumn(){

        var list0 = remember { mutableStateListOf(1,2,3,4,5,9,77) }  //można dodawać i usuwać elementy list
        var list1 = remember { mutableStateListOf("hoho", "huhu", "hiiiii") }
        var listEmpty = remember { mutableStateListOf<Int>() }

        var list2 = listOf("one", "two", "three")   //lista stała, nie można dodawać ani usuwać elementów
        var list3 = listOf(44,55,66,77)

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(vertical = 30.dp, horizontal = 10.dp)
        ){
            item {Text(text = "A")}

            items(count = 20){
                    i -> Text(text = "item $i")
            }

            for(i in 0..15){
                item {Text(text = "loopItem nr $i")}
            }
            items(items = list0){
                    t -> Text(text = "$t")
            }
            items(items = list1){
                    listItem -> Text(text = listItem)
            }
            items(items = list2){
                    i -> Text(text = i)
            }
            items(items = list3){
                    li -> Text(text = "list3 nr $li")
            }
        }
    }

    @Composable
    fun TextFieldExcercise2(){
        Column(                modifier = Modifier
            .fillMaxWidth()
            .padding((10.dp))) {
            var txt: MutableState<String> = remember{ mutableStateOf("") }
            TextField(value = txt.value, onValueChange = {txt.value = it},
                modifier = Modifier
                    .fillMaxWidth(),
                isError = txt.value.length > 20
            )

            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                renderErrorMessage(txt.value.length )
                Row(){
                    Text(text = "${txt.value.length}")
                    Text(text = "/20")
                }
            }
        }
    }
    @Composable
    fun renderErrorMessage(length: Int){
        var txt = ""
        if(length > 20)
            txt = "text is too long"
        Text(text = txt,
            color = Color.Red)
    }

    @Composable
    fun TextFieldExcercise1(){
        Column(){
            var email: MutableState<String> = remember{ mutableStateOf("") }
            var pass: MutableState<String> = remember{ mutableStateOf("") }
            OutlinedTextField(value = email.value, onValueChange = {email.value = it},
                placeholder = {Text(text = "Email")},
                label = {Text(text = "Email")},
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                isError = !email.value.contains('@'),
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(value = pass.value, onValueChange = {pass.value = it},
                placeholder = {Text(text = "Password")},
                label = {Text(text = "Password")},
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            )
        }
    }

    @Composable
    fun MyOutlinedTextField(){
        var txt: MutableState<String> = remember {
            mutableStateOf("")
        }
        OutlinedTextField(value =txt.value,
            onValueChange ={txt.value = it},
            colors = OutlinedTextFieldDefaults.colors(),
            textStyle = TextStyle(color = Color.Blue)
        )
    }

    @Composable
    fun MyTextField(){
        var text: MutableState<String> = remember{ mutableStateOf("") }

        TextField(value = text.value, onValueChange = {text.value = it},
            label = {Text(text = "adres email")},
            placeholder = {Text(text = "wpisz wartość")},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
            trailingIcon = { Icon(imageVector = Icons.Default.Create, contentDescription = null) },
            singleLine = true,
            colors = TextFieldDefaults.colors(unfocusedTextColor = Color.LightGray),
            textStyle = TextStyle(color = Color.Black)
        )
    }

    @Composable
    fun SliderSettingsExcercise(){
        Column(){
            var isChecked: MutableState<Boolean> = remember{ mutableStateOf(false) }
            var sl: MutableState<Float> = remember{ mutableStateOf(0f) }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(checked = isChecked.value, onCheckedChange = {isChecked.value = !isChecked.value})
                Icon(imageVector = Icons.Default.Settings, contentDescription = "")
                Text(text = "settings", fontSize = 20.sp)

            }
            renderSlider(isChecked.value, sl)
            renderWarning(sl.value, isChecked.value)
        }
    }
    @Composable
    fun renderSlider(isChecked: Boolean, sl: MutableState<Float>){
        if(!isChecked)
            return;
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = null)

            Box(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .border(width = 2.dp, color = Color.Cyan, shape = RoundedCornerShape(8.dp))
                    .padding(end = 30.dp)
                    .weight(1f)
            ){
                Slider(value = sl.value,
                    //onValueChange = {value -> sl.value = value},
                    onValueChange = {sl.value = it},    //zapis skrócony, odpowiednik wiersza powyżej
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                )
            }
            Icon(imageVector = Icons.Filled.Notifications, contentDescription = "",
                tint = if(sl.value > 0.8) Color.Red else Color.Black
            )
        }
    }
    @Composable
    fun renderWarning(slideValue: Float, isChecked: Boolean){
        if(isChecked && slideValue > 0.8)
            Text("Uwaga!", color = Color.Red)
    }

    @Composable
    fun MyShowHideClick(){
        Row(){
            var clicked: MutableState<Boolean> = remember{ mutableStateOf(false) }

            Button(onClick = { clicked.value = !clicked.value }) {
                Text(text = if(clicked.value == false) "show" else "hide")
            }
            renderText(clicked)
        }
    }

    @Composable
    fun renderText(clicked: MutableState<Boolean>){
        if(clicked.value == true)
            Text(text =  "hi there"
            )
    }

    @Composable
    fun MyClickableModifier(){
        var isClicked by remember { mutableStateOf(false) }
        Text(text = if(isClicked) "clicked" else "not clicked yet",
            modifier = Modifier.clickable { isClicked = true }
        )
    }


    @Composable
    fun MyFAB(){
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            FloatingActionButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(20.dp)) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    }

    @Composable
    fun MyIconButton(){
        Column() {
            var isClicked: MutableState<Boolean> = remember { mutableStateOf(false) }
            IconButton(onClick = { isClicked.value = !isClicked.value }) {
                Icon(
                    imageVector = if (isClicked.value == true) Icons.Filled.Favorite else Icons.Outlined.Done,
                    contentDescription = "",
                    tint = Color.Red
                )
            }
            Text(text = "${isClicked.value}")
        }
    }

    @Composable
    fun MySlider(){
        Column() {
            var sl: MutableState<Float> = remember { mutableStateOf(0f) }
            Slider(value = sl.value,
                onValueChange = { value -> sl.value = value },
                valueRange = 0f..100f,
                steps = 5,
                colors = SliderDefaults.colors(activeTrackColor = Color.Green),
                modifier = Modifier
                    .padding(horizontal = 20.dp)

            )
            Text(text = "value = ${sl.value}")
        }
    }

    @Composable
    fun MySwitch(){
        var isOn: MutableState<Boolean> = remember {
            mutableStateOf(false)
        }
        Switch(checked = isOn.value,
            onCheckedChange = {state -> isOn.value = state},
            colors = SwitchDefaults.colors(checkedThumbColor = Color.Green)
        )
    }

    @Composable
    fun MyRadioButton(){
        var isSelected: MutableState<Boolean> = remember {
            mutableStateOf(false)
        }
        RadioButton(selected = isSelected.value,
            onClick = { isSelected.value = !isSelected.value },
            colors = RadioButtonDefaults.colors(selectedColor = Color.Magenta))
    }

    @Composable
    fun MyCheckBox(){
        var isChecked: MutableState<Boolean> = remember{ mutableStateOf(false) }
        Checkbox(checked = isChecked.value,
            onCheckedChange = { state -> isChecked.value = state },
            colors = CheckboxDefaults.colors(checkedColor = Color.Green))
    }

    @Composable
    fun ButtonClickExcercise(){
        Row(){
            var count: MutableState<Int> = remember {
                mutableStateOf(0)
            }
            Button(enabled = count.value > 0,
                onClick = { count.value-- }) {
                Text(text = "-")
            }

            Text(text = "${count.value}",
                modifier = Modifier
                    .padding(10.dp)
                    .size(height = 30.dp, width = 50.dp)
                    .border(width = 1.dp, color = Color.Black)
                    .wrapContentSize()
            )

            Button(border = BorderStroke(width = 1.dp, color = Color.Black),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
                onClick = { count.value++ }) {
                Text(text = "+")
            }
        }
    }

    @Composable
    fun MyClickButton(){
        Column() {
            var count: MutableState<Int> = remember { mutableStateOf(0) }
            Button(onClick = { count.value++ }) {
                Text(text = "click count 1 ${count.value}")
            }
            SecondClickButton(click = count)
        }
    }

    @Composable
    fun SecondClickButton(click: MutableState<Int>){
        Button(onClick = { click.value++ }) {
            Text(text = "click count 2 ${click.value}")
        }
    }

    @Composable
    fun ExerciseBottomBar(){
        Row(modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(modifier= Modifier.background(color = Color.Yellow)){
                Text(text = "Kurs Kotlin + porwnanie Java vs Kotlin & quizy&zadania ", color = Color.White
                    , textAlign = TextAlign.Start, maxLines=1

                )

            }
            Row(verticalAlignment = Alignment.CenterVertically){
                Column(modifier= Modifier.background(color = Color.Red)){
                    Text(text = "49,99 zł", color = Color.White,
                        textAlign = TextAlign.End, fontWeight = FontWeight.Bold
                    )
                    Text(text = "229,99 zł", color = Color.White,
                        textAlign = TextAlign.End, textDecoration = TextDecoration.LineThrough)
                }
                Column(modifier= Modifier.background(color = Color.Green)){
                    Box(
                        modifier = Modifier.background(color = Color.White)
                    ){
                        Text(text = "Kup teraz", color = Color.Black,
                            modifier = Modifier.align(Alignment.Center))
                    }
                }

            }


        }
    }


    @Composable
    fun MyWeigth(){
        Row(){
            Text(text = "text 1", modifier = Modifier
                .background(color = Color.Green)
                .weight(1f)
            )
            Text(text = "text 2", modifier = Modifier
                .background(color = Color.Magenta)
                .weight(2f)
            )
            Text(text = "text 3", modifier = Modifier
                .background(color = Color.Cyan)
                .weight(3f)
            )
        }
    }


    @Composable
    fun MyBox(){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
        ){
            Box(
                modifier = Modifier
                    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                    .size(200.dp)
                    .align(alignment = Alignment.Center)
                    .padding(10.dp)
            ){
                Spacer(modifier = Modifier
                    .size(70.dp)
                    .align(alignment = Alignment.TopStart)
                    .background(color = Color.Magenta, shape = RoundedCornerShape(5.dp))
                )
                Spacer(modifier = Modifier
                    .size(70.dp)
                    .align(alignment = Alignment.BottomEnd)
                    .background(color = Color.Magenta, shape = RoundedCornerShape(5.dp))
                )

                Spacer(modifier = Modifier
                    .size(100.dp)
                    .align(alignment = Alignment.Center)
                    .background(color = Color.Red, shape = RoundedCornerShape(5.dp))
                )

            }
        }
    }

    @Composable
    fun MyCard(){
        Card(modifier = Modifier.padding(20.dp),    //zastosowanie do uzyskania efektu cieniowania
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(contentColor = Color.Red, containerColor = Color.Cyan)) {
            Text("Card1",
                modifier = Modifier.padding((10.dp)))
            Text("Card2",
                modifier = Modifier.padding((10.dp)))
        }
    }

    @Composable
    fun MySurface(){
        Surface(    //zastosowanie głównie do tego by ustawić kolor wszystkich elementów wewnątrz jedną linijką kodu
            color = Color.Green,
            contentColor = Color.Red,
            border = BorderStroke(2.dp, Color.Black),
            shape = RoundedCornerShape(8.dp)
        ){
            Text(text = "Surface",
                modifier = Modifier.padding((10.dp)))
        }
    }

    @Composable
    fun MyButton(){
        Column(){
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Click me!")
            }
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black),
                border = BorderStroke(2.dp, color = Color.Black),
                modifier = Modifier.width(100.dp),
                enabled = false
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                    Text(text = "Add")
                }
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "outlined button")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "click me!")
            }
        }

    }

    @Composable
    fun MyTextDividerProgressExcercise(){
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Welcome!",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray),
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Light,
                color = Color.White,
                fontSize = 30.sp)
            Divider()
            CircularProgressIndicator(progress = 0.8f)
            Divider()
            Text(text = "Nice progress!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                color = Color.Blue)
        }
    }

    @Composable
    fun MyProgress(){
        Column(
            modifier = Modifier.padding((10.dp))
        ){
            CircularProgressIndicator()
            Divider(thickness = 10.dp)
            CircularProgressIndicator(color = Color.Green,
                progress = 0.6f)
            Divider(thickness = 10.dp, color = Color.Cyan)
            LinearProgressIndicator()
            Divider(thickness = 20.dp, color = Color.White)
            LinearProgressIndicator(progress = 0.7f, color= Color.Black)
        }
    }


    @Composable
    fun MyDivider(){
        Column(){
            Text(text = "Top text")
            Divider(
                thickness = 40.dp,
                color = Color.Cyan
            )
            Text(text = "bottom text")
        }
    }

    @Composable
    fun MySpacer(){
        Column(){
            Text(text = "Top text")
            Spacer(modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
                .background(color = Color.LightGray)
            )
            Text(text = "bottom text")
        }
    }

    @Composable
    fun MyIcon(){
        Column() {
            Icon(imageVector = Icons.Default.Email, contentDescription = "email icon")
            Icon(
                imageVector = Icons.Default.Done, contentDescription = "done",
                tint = Color.White,
                modifier = Modifier
                    .background(color = Color.Green, shape = CircleShape)
                    .border(width = 2.dp, color = Color.LightGray, shape = CircleShape)
                    .padding(5.dp)
            )
        }
    }


    @Composable
    fun MyTextAlign(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.LightGray),
            //horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Lorem Ipsum",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Green)
                    .align(Alignment.End),
                textAlign = TextAlign.End
            )
            Text(
                text = "tekstem stosowanym",
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .align(Alignment.CenterHorizontally)
                    .height(100.dp)
                    .fillMaxWidth()
                    .wrapContentSize()
            )
            Text(
                text = "przykładowy wypełniacz",
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .align(Alignment.Start)
            )
        }
    }

    @Composable
    fun MyText(){
        Text(text = "Lorem Ipsum jest tekstem stosowanym jako przykładowy wypełniacz",
            fontSize = 20.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            letterSpacing = 6.sp
        )
    }

    @Composable
    fun ModifierExcercise(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ){
            Text(modifier = Modifier
                .padding(top = 10.dp)
                .background(Color.Cyan),
                text = "Top")
            Text(modifier = Modifier
                .background(color = Color.Green, shape = RoundedCornerShape(6.dp))
                .padding(3.dp)
                ,
                text = "bottom")
        }
    }


    @Composable
    fun MyModifier(){
        Column(
            modifier = Modifier
                .background(Color.Cyan)
                //.fillMaxHeight()
                .fillMaxSize(),
            //.padding(50.dp)
            //.padding(top = 20.dp, bottom = 50.dp, start = 5.dp, end = 60.dp)
            //.padding(horizontal = 20.dp)
            //.size(width = 100.dp, height = 200.dp)
            //.height(100.dp)
            //.width(50.dp)
            //.padding(vertical = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                modifier = Modifier
                    .width(200.dp)
                    .background(Color.Green)
                    .padding(8.dp)
                    .rotate(45f)
                    .border(width = 3.dp, color = Color.Black),
//                    .background(Color.Green, shape = CircleShape)
//                    .clip(CircleShape),
                text = "Lorem Ipsum jest tekstem stosowanym jako przykładowy wypełniacz w przemyśle poligraficznym. Został po raz pierwszy użyty w XV w. przez nieznanego drukarza do wypełnienia tekstem próbnej książki.")        }
    }


    @Composable
    fun MyColumnExcercise(){

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Hellllllllo world!")
            Text(text = "hi there")
            Text(text = "hohoho")
        }

    }




    @Composable
    fun MyRow(){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Text(text = "Hello world!")
            Text(text = "hi there")
            Text(text = "hohoho")
        }


    }

    @Composable
    fun MyColumn(){
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween)
        {
            Text(text = "Hello world!")
            Text(text = "hi there")
            Text(text = "hohoho")
        }
    }

    @Composable
    fun MyElement() {
        Text(text = "Hello world!")
        Text(text = "hi there")
        Text(text = "huhuhu")
    }
}

