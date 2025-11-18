package cortez230.com.github.gs_rm551188_rm551665.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cortez230.com.github.gs_rm551188_rm551665.R

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {

    var usuario = remember { mutableStateOf("") }
    var senha = remember { mutableStateOf("") }
    var erro = remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            Text(
                text = "Usuário",
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Magenta
            )
            OutlinedTextField(
                value = usuario.value,
                onValueChange = { usuario.value = it },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Blue,
                    focusedBorderColor = Color.Blue
                ),
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Senha",
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Magenta
            )
            OutlinedTextField(
                value = senha.value,
                onValueChange = { senha.value = it },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Blue,
                    focusedBorderColor = Color.Blue
                ),
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            if (erro.value.isNotEmpty()) {
                Text(
                    text = erro.value,
                    fontSize = 16.sp,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Button(
                onClick = {
                    if (usuario.value == "eu" && senha.value == "123") {
                        navController.navigate("menu")
                        erro.value = ""
                    } else {
                        erro.value = "Tente novamente"
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Acesso Permitido",
                    fontSize = 30.sp,
                    color = Color.White
                )
            }
        }
    }
}