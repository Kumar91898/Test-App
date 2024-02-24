package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.ui.theme.TestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Main()
//                    Info(name = "Kailash", rollno = "22SW-32", dept = "Software")
////                    questionSet1(name = "Kailash Kumar", rollno = "32", dept = "SW")
//                    com.example.testapp.Result(
//                        name = "Kailash Kumar",
//                        rollno = "22SW-32",
//                        correctAns = 2,
//                        correctAns2 = 1
//                    )
                }
            }
        }
    }
}

@Composable
fun Main() {
    var name by remember {
        mutableStateOf("")
    }

    var rollno by remember {
        mutableStateOf("")
    }

    var dept by remember {
        mutableStateOf("")
    }

    var isButtonClicked by remember {
        mutableStateOf(false)
    }

    val logo = painterResource(R.drawable._bee95663_c8ef_4dde_9e59_8b8d0754b17a_jpeg_removebg_preview)

    if (!isButtonClicked){
        Surface(
            color = Color.DarkGray
        ) {
            Column {
                Column(
                    modifier = Modifier
                        .padding(start = 60.dp, top = 10.dp)
                ) {
                    Image(
                        painter = logo,
                        contentDescription = null,
                        modifier = Modifier
                            .width(230.dp)
                            .padding(start = 30.dp)
                    )
                    Text(
                        text = "King's Testing Service",
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center,
                        fontSize = 23.sp,
                    )
                    Text(
                        text = "Hello!\nAnd Welcome to the Test\n\nEnter your details to get started",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier
                            .padding(end = 60.dp, top = 20.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 35.dp, top = 40.dp)
                ) {
                    TextField(
                        value = name,
                        onValueChange = { newText ->
                            name = newText
                        },
                        modifier = Modifier
                            .padding(16.dp),
                        label = {
                            Text(text = "Full Name")
                        }
                    )
                    TextField(
                        value = rollno,
                        onValueChange = { newText ->
                            rollno = newText
                        },
                        modifier = Modifier
                            .padding(16.dp),
                        label = {
                            Text(text = "Roll No")
                        }
                    )
                    TextField(
                        value = dept,
                        onValueChange = { newText ->
                            dept = newText
                        },
                        modifier = Modifier
                            .padding(16.dp),
                        label = {
                            Text(text = "Department")
                        }
                    )
                    Button(
                        modifier = Modifier
                            .padding(start = 100.dp, top = 35.dp),
                        onClick = {
                            isButtonClicked = true
                        }
                    ) {
                        Text(text = "Continue")
                    }

                }
            }
        }
    } else {
        questionSet1(name = name, rollno = rollno, dept = dept)
    }
}

@Composable
fun questionSet1(name : String, rollno : String, dept : String){
    var selectOption1 by remember {
        mutableStateOf("")
    }
    val options1 = listOf("IDE to design Application", "IDE to design IOS Applications", "Software for graphic designing", "Software for designing models")
    val correctAnswer1 = "IDE to design Application"

    var selectOption2 by remember {
        mutableStateOf("")
    }
    val options2 = listOf("Graphics design software", "Android development framework", "Cloud computing platform", "Game development engine")
    val correctAnswer2 = "Android development framework"

    var isButtonClicked by remember {
        mutableStateOf(false)
    }
    var correctAns by remember {
        mutableStateOf(0)
    }

    val image = painterResource(R.drawable.bg_compose_background)

    if (!isButtonClicked){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            alignment = Alignment.TopCenter
        )
        Column {
            Column(
                modifier = Modifier
                    .padding(start = 31.dp, top = 150.dp)
            ) {
                Text(
                    text = "Hello $name!",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center,
                )
            }
            Column (
                modifier = Modifier.padding(start = 15.dp, top = 20.dp)
            ){
                Text(
                    text = "Qno1: What is Android Studio?",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )
                options1.forEach{option ->
                    Row {
                        RadioButton(
                            selected = selectOption1 == option,
                            onClick = {
                                selectOption1 = option
                                if (selectOption1 == correctAnswer1) {
                                    correctAns++
                                }
                            },
                            colors = RadioButtonDefaults.colors(selectedColor = Color.White)
                        )
                        Text(
                            text = option,
                            modifier = Modifier.padding(start = 8.dp, top = 12.dp)
                        )
                    }
                }

                Text(
                    text = "Qno2: What is Jetpack Compose?",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .padding(top = 20.dp)
                )
                options2.forEach{option ->
                    Row {
                        RadioButton(
                            selected = selectOption2 == option,
                            onClick = {
                                selectOption2 = option
                                if (selectOption2 == correctAnswer2) {
                                    correctAns++
                                }
                            },
                            colors = RadioButtonDefaults.colors(selectedColor = Color.White)
                        )
                        Text(
                            text = option,
                            modifier = Modifier.padding(start = 8.dp, top = 12.dp)
                        )
                    }
                }
            }

            Button(
                modifier = Modifier
                    .width(330.dp)
                    .height(100.dp)
                    .padding(start = 100.dp, end = 50.dp, top = 50.dp),
                onClick = {
                    isButtonClicked = true
                }
            ) {
                Text(text = "Next")
            }
        }
    } else {
//        Result(name, rollno, selectOption1, correctAnswer1, correctAns)
        questionSet2(name = name, rollno = rollno, dept = dept, correctAns)
    }
}

@Composable
fun questionSet2(name : String, rollno : String, dept : String, correctAns : Int) {
    var selectOption1 by remember {
        mutableStateOf("")
    }
    val options1 = listOf("Universal Interval", "Universal Interface", "Unknown Interface", "User Interface")
    val correctAnswer1 = "User Interface"

    var selectOption2 by remember {
        mutableStateOf("")
    }
    val options2 = listOf("var can be modified", "val can be modified", "var can not be modified", "both can be modified")
    val correctAnswer2 = "var can be modified"

    var isButtonClicked by remember {
        mutableStateOf(false)
    }
    var correctAns2 by remember {
        mutableStateOf(0)
    }

    val image = painterResource(R.drawable.bg_compose_background)

    if (!isButtonClicked){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            alignment = Alignment.TopCenter
        )
        Column {
            Column(
                modifier = Modifier
                    .padding(start = 31.dp, top = 150.dp)
            ) {
                Text(
                    text = "Hello $name!",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center,
                )
            }
            Column (
                modifier = Modifier.padding(start = 15.dp, top = 20.dp)
            ){
                Text(
                    text = "Qno3: UI Stands for?",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .padding(top = 20.dp)
                )
                options1.forEach{option ->
                    Row {
                        RadioButton(
                            selected = selectOption1 == option,
                            onClick = {
                                selectOption1 = option
                                if (selectOption1 == correctAnswer1) {
                                    correctAns2++
                                }
                            },
                            colors = RadioButtonDefaults.colors(selectedColor = Color.White)
                        )
                        Text(
                            text = option,
                            modifier = Modifier.padding(start = 8.dp, top = 12.dp)
                        )
                    }
                }

                Text(
                    text = "Qno4: Which one is correct?",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .padding(top = 20.dp)
                )
                options2.forEach{option ->
                    Row {
                        RadioButton(
                            selected = selectOption2 == option,
                            onClick = {
                                selectOption2 = option
                                if (selectOption2 == correctAnswer2) {
                                    correctAns2++
                                }
                            },
                            colors = RadioButtonDefaults.colors(selectedColor = Color.White)
                        )
                        Text(
                            text = option,
                            modifier = Modifier.padding(start = 8.dp, top = 12.dp)
                        )
                    }
                }
            }

            Button(
                modifier = Modifier
                    .width(330.dp)
                    .height(90.dp)
                    .padding(start = 100.dp, end = 50.dp, top = 40.dp),
                onClick = {
                    isButtonClicked = true
                }
            ) {
                Text(text = "Submit")
            }
        }
    } else {
        Result(name, rollno, dept, correctAns, correctAns2)
    }

}


@Composable
fun Result(name : String, rollno : String, dept : String, correctAns : Int, correctAns2 : Int){

    var totalQuestions = 4
    var CorrectAnswers = correctAns+correctAns2

    val logo = painterResource(R.drawable._bee95663_c8ef_4dde_9e59_8b8d0754b17a_jpeg_removebg_preview)

    Surface(
        color = Color.DarkGray
    ){
        Column(
        ) {
            Image(
                painter = logo,
                contentDescription = null,
                modifier = Modifier
                    .width(300.dp)
                    .padding(start = 70.dp, top = 40.dp)
            )
            Text(
                text = "Final Results!",
                fontSize = 45.sp,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center,
                color = Color.Green,
                modifier = Modifier
                    .padding(start = 40.dp, top = 20.dp)
            )
            Text(
                text = "Name : $name",
                fontSize = 27.sp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 40.dp, top = 30.dp)
            )
            Text(
                text = "Roll No : $rollno",
                fontSize = 27.sp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 40.dp)
            )
            Text(
                text = "Department : $dept",
                fontSize = 27.sp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 40.dp)
            )
            Text(
                text = "Total Questions = $totalQuestions",
                fontSize = 27.sp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                color = Color.Cyan,
                modifier = Modifier
                    .padding(start = 40.dp)
            )
            Text(
                text = "Correct Answers = $CorrectAnswers",
                fontSize = 27.sp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                color = Color.Green,
                modifier = Modifier
                    .padding(start = 40.dp)
            )
            Text(
                text = "Wrong Answers = ${totalQuestions - CorrectAnswers}",
                fontSize = 27.sp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                color = Color.Red,
                modifier = Modifier
                    .padding(start = 40.dp)
            )
            Text(
                text = "Percentage = ${(CorrectAnswers / totalQuestions.toDouble()) * 100}%",
                fontSize = 27.sp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 40.dp)
            )
            Text(
                text = "Developed by: Kailash Kumar",
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 24.dp, top = 100.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestAppTheme {
        Main()
    }
}