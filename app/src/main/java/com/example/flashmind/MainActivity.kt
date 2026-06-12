package com.example.flashmind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.background

data class Flashcard(
    val question: String,
    val answer: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                FlashMindApp()
            }
        }
    }
}

@Composable
fun FlashMindApp() {

    val flashcards = arrayListOf(
        Flashcard("What is AI?", "Artificial Intelligence"),
        Flashcard("What is ML?", "Machine Learning"),
        Flashcard("What is DL?", "Deep Learning"),
        Flashcard("What is Kotlin?", "Android Programming Language"),
        Flashcard("What is Java?", "Programming Language"),
        Flashcard("What is Python?", "Programming Language"),
        Flashcard("What is Firebase?", "Google Backend Platform"),
        Flashcard("What is Android Studio?", "Android IDE"),
        Flashcard("What is HTML?", "HyperText Markup Language"),
        Flashcard("What is CSS?", "Cascading Style Sheets"),
        Flashcard("What is JavaScript?", "Web Programming Language"),
        Flashcard("What is SQL?", "Database Query Language"),
        Flashcard("What is DBMS?", "Database Management System"),
        Flashcard("What is Cloud Computing?", "Delivery of Computing Services Over Internet"),
        Flashcard("What is Git?", "Version Control System"),
        Flashcard("What is GitHub?", "Code Hosting Platform"),
        Flashcard("What is API?", "Application Programming Interface"),
        Flashcard("What is JSON?", "JavaScript Object Notation"),
        Flashcard("What is HTTP?", "HyperText Transfer Protocol"),
        Flashcard("What is HTTPS?", "Secure HyperText Transfer Protocol"),
        Flashcard("What is RAM?", "Random Access Memory"),
        Flashcard("What is ROM?", "Read Only Memory"),
        Flashcard("What is CPU?", "Central Processing Unit"),
        Flashcard("What is OS?", "Operating System"),
        Flashcard("What is Linux?", "Open Source Operating System"),
        Flashcard("What is Windows?", "Operating System"),
        Flashcard("What is Compiler?", "Converts Source Code to Machine Code"),
        Flashcard("What is Interpreter?", "Executes Code Line by Line"),
        Flashcard("What is Algorithm?", "Step-by-Step Problem Solving Procedure"),
        Flashcard("What is Data Structure?", "Method of Organizing Data"),
        Flashcard("What is Array?", "Collection of Similar Elements"),
        Flashcard("What is Linked List?", "Linear Data Structure"),
        Flashcard("What is Stack?", "LIFO Data Structure"),
        Flashcard("What is Queue?", "FIFO Data Structure"),
        Flashcard("What is Tree?", "Hierarchical Data Structure"),
        Flashcard("What is Graph?", "Collection of Nodes and Edges"),
        Flashcard("What is OOP?", "Object Oriented Programming"),
        Flashcard("What is Class?", "Blueprint for Objects"),
        Flashcard("What is Object?", "Instance of a Class"),
        Flashcard("What is Inheritance?", "Acquiring Properties of Another Class"),
        Flashcard("What is Polymorphism?", "Many Forms of a Method"),
        Flashcard("What is Encapsulation?", "Wrapping Data and Methods Together"),
        Flashcard("What is Abstraction?", "Hiding Implementation Details"),
        Flashcard("What is Android?", "Mobile Operating System"),
        Flashcard("What is Jetpack Compose?", "Modern Android UI Toolkit"),
        Flashcard("What is RecyclerView?", "Displays Large Data Lists"),
        Flashcard("What is Room Database?", "Local Android Database Library"),
        Flashcard("What is XML?", "Extensible Markup Language"),
        Flashcard("What is UI?", "User Interface"),
        Flashcard("What is UX?", "User Experience")
    )


    var currentIndex by remember { mutableIntStateOf(0) }
    var showAnswer by remember { mutableStateOf(false) }

    val currentCard = flashcards[currentIndex]
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.flash_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // ⭐ DARK OVERLAY (THIS FIXES TITLE VISIBILITY)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "⚡FlashMind⚡",
                    fontSize = 30.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(24.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCE93D8),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    shape = RoundedCornerShape(16.dp),

                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF2F1533)
                    )
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = currentCard.question,
                            fontSize = 22.sp,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        if (showAnswer) {
                            Text(
                                text = currentCard.answer,
                                fontSize = 18.sp,
                                color = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = { showAnswer = !showAnswer }) {
                    Text(if (showAnswer) "Hide Answer" else "Show Answer")
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {

                    Button(onClick = {
                        if (currentIndex > 0) {
                            currentIndex--
                            showAnswer = false
                        }
                    }) {
                        Text("Previous")
                    }

                    Button(onClick = {
                        if (currentIndex < flashcards.size - 1) {
                            currentIndex++
                            showAnswer = false
                        }
                    }) {
                        Text("Next")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Card ${currentIndex + 1} of ${flashcards.size}",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}