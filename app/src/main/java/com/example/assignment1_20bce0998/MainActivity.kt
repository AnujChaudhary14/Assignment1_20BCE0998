package com.example.assignment1_20bce0998

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment1_20bce0998.ui.theme.Assignment1_20BCE0998Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            googlebody()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun googlebody()
{
    Column(modifier=Modifier.fillMaxSize().background(Color.White), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        var fn = remember {
            mutableStateOf(TextFieldValue())
        }

        var ln = remember {
            mutableStateOf(TextFieldValue())
        }

        var un = remember {
            mutableStateOf(TextFieldValue())
        }

        var ps = remember {
            mutableStateOf(TextFieldValue())
        }

        var cnf = remember {
            mutableStateOf(TextFieldValue())
        }

        var checkedState =
            remember { mutableStateOf(false) }

        var context= LocalContext.current
        Image(
            painterResource(id = R.drawable.gg), contentDescription ="Google Pic",
            contentScale = ContentScale.Fit, modifier=Modifier.size(110.dp)
        )

        Text("Create your Google Account", fontSize = 24.sp,
            color= Color.Black, fontWeight = FontWeight.Medium
        )

        Spacer(modifier=Modifier.height(10.dp))

        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier=Modifier.fillMaxWidth()){
            TextField(value = fn.value, onValueChange ={fn.value=it}, modifier= Modifier
                .width(170.dp).border(BorderStroke(1.dp, Color.Black))
                , colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                label = {Text("First Name")})
            Spacer(modifier=Modifier.width(5.dp))
            TextField(value = ln.value, onValueChange ={ln.value=it}, modifier= Modifier
                .width(170.dp).border(BorderStroke(1.dp, Color.Black))
                ,
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                label = {Text("Last Name")})
        }

        TextField(value = un.value, onValueChange ={un.value=it},
            modifier=Modifier.width(220.dp).border(BorderStroke(1.dp, Color.Black)),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
            label = {Text("Username")})

        Text(text = "You can use letters, numbers & periods", fontSize = 15.sp, )

        TextButton(onClick = { Toast.makeText(context,"Using your current email address", Toast.LENGTH_LONG).show() }) {
            Text(text = "Use my current email address instead", color = Color.Blue, fontSize = 15.sp)
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier=Modifier.fillMaxWidth()){
            TextField(value = ps.value, onValueChange ={ps.value=it}, modifier= Modifier
                .width(170.dp).border(BorderStroke(1.dp, Color.Black))
                , colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                label = {Text("Password")},
                visualTransformation = if(!checkedState.value) {
                    PasswordVisualTransformation()
                }
                else{
                    VisualTransformation.None
                }
            )
            Spacer(modifier=Modifier.width(5.dp))
            TextField(value = cnf.value, onValueChange ={cnf.value=it}, modifier= Modifier
                .width(170.dp).border(BorderStroke(1.dp, Color.Black))
                ,
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                label = {Text("Confirm")},

                visualTransformation = if(!checkedState.value) {
                    PasswordVisualTransformation()
                }
                else{
                    VisualTransformation.None
                })
        }
        Text(text = "Use 8 or more characters with a mix of letters, numbers and symbols", textAlign = TextAlign.Center)


        Row(){
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { isChecked ->
                    checkedState.value = isChecked
                }
            )
            Text("Show Password", Modifier.padding(top=13.dp))
        }

        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            TextButton(onClick = { Toast.makeText(context,"Signing in instead", Toast.LENGTH_LONG).show() }) {
                Text("Sign in instead",color= Color.Blue)
            }
            Button(onClick = { Toast.makeText(context,"Going to the Next Option", Toast.LENGTH_LONG).show() }, colors= ButtonDefaults.buttonColors(
                Color.Blue)) {
                Text("Next", color= Color.White)
            }
        }
    }
}

