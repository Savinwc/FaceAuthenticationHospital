package com.example.hustlers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hustlers.R;

public class ChatBotActivity extends AppCompatActivity {

    private TextView chatView;
    private EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);

        chatView = findViewById(R.id.chatView);
        userInput = findViewById(R.id.userInput);

        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMessage = userInput.getText().toString();
                chatView.append("You: " + userMessage + "\n");

                String botMessage = botResponse(userMessage);
                chatView.append("Bot: " + botMessage + "\n");

                userInput.setText("");
            }
        });
    }

    private String botResponse(String userMessage) {
        String lowerCaseUserMessage = userMessage.toLowerCase().trim();
        return switch (lowerCaseUserMessage) {
            case "hi", "hello" -> "Hello! How can I help you today?";
            case "what's your name?" -> "My name is ChatBot.";
            case "what do you do?" -> "I'm here to answer your questions.";
            case "how old are you?" -> "I don't have an age. I'm just a computer program!";
            case "what is the purpose of this registration?" ->
                    "The purpose of this registration is to create a patient record in our system, which allows us to provide you with the best possible medical care.";
            case "is there a fee for registering?","fee" ->
                    "No, there is no fee for registering. Our patient registration process is completely free.";
            case "what information do i need to provide during registration?","information required" ->
                    "You'll need to provide basic information such as your name, date of birth, address, phone number, and email address.";
            case "can i register more than one person at a time?" ->
                    "Our system currently allows for one person to be registered at a time. If you need to register multiple family members, you'll need to complete the registration process for each person separately.";
            case "will i be able to see my medical records after registering?","medical records" ->
                    "Yes, once you've registered, you'll have access to your medical records through our app. You'll be able to view your past appointments, lab results, and other important health information.";
            case "is my personal information safe and secure?" ->
                    "Yes, your personal information is safe and secure. We take the privacy and security of your information very seriously and have implemented appropriate measures to protect it.";
            case "how long will it take to complete the registration process?" ->
                    "The registration process typically takes around few minutes, depending on how quickly you provide the necessary information.";
            case "can i update my information later if anything changes?" ->
                    "Yes, you can easily update your information later on by logging into your account and making the necessary changes.";
            case "what happens after i complete the registration process?" ->
                    "After completing the registration process, your information will be added to our system and you'll be able to use it to make appointments and access other features of our app.";
            case "thank you", "thanks" -> "You're welcome!";
            default -> "I'm sorry, I didn't understand what you said.";
        };
    }

}